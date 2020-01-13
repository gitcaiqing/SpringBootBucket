package com.caiqing.bootelasticsearch.controller;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/1/6 16:18
 **/
@RestController
@RequestMapping("/es")
public class EsController {

    private static final String ES_INDEX = "book";

    private static final String ES_TYPE = "novel";

    @Autowired
    private TransportClient transportClient;

    /**
     * 新增
     * @param title 标题
     * @param author 作者
     * @param wordCount 字数
     * @return org.springframework.http.ResponseEntity
     * @author CQ
     * @date 2020/1/10 14:40
     */
    @GetMapping("/add/book/novel")
    public ResponseEntity add(@RequestParam(required = false) String title, @RequestParam(required = false) String author,
                              @RequestParam(required = false) Long wordCount){
        //return new ResponseEntity(1, HttpStatus.OK);
        XContentBuilder content;
        try {
            content = XContentFactory.jsonBuilder().startObject()
                    .field("title", title)
                    .field("author", author)
                    .field("word_count", wordCount)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        IndexResponse result = this.transportClient.prepareIndex(ES_INDEX, ES_TYPE)
                .setSource(content).get();
        return new ResponseEntity(result.getId(), HttpStatus.OK);
    }

    /**
     * 根据ID删除
     * @param id
     * @return org.springframework.http.ResponseEntity
     * @author CQ
     * @date 2020/1/10 14:40
     */
    @DeleteMapping("/delete/book/novel")
    public ResponseEntity delete(@RequestParam String id){
        DeleteResponse result = this.transportClient.prepareDelete(ES_INDEX, ES_TYPE, id).get();
        return new ResponseEntity(result.getId(), HttpStatus.OK);
    }

    /**
     * 根据ID查询
     * @param id
     * @return org.springframework.http.ResponseEntity
     * @author CQ
     * @date 2020/1/10 14:46
     */
    @GetMapping("/get/book/novel")
    public ResponseEntity get(@RequestParam String id){
        if(id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = this.transportClient.prepareGet(ES_INDEX, ES_TYPE, id).get();
        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }

    /**
     * 根据ID更新
     * @param id
     * @param title
     * @param author
     * @return org.springframework.http.ResponseEntity
     * @author CQ
     * @date 2020/1/10 15:06
     */
    @PutMapping("/put/book/novel")
    public ResponseEntity update(@RequestParam String id, @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String author,
                                 @RequestParam(required = false) Long price){

        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            if(StringUtils.hasText(title)){
                builder.field("title", title);
            }
            if(StringUtils.hasText(author)){
                builder.field("author",author);
            }
            if(price != null){
                builder.field("price", price);
            }
            builder.endObject();
            UpdateRequest updateRequest = new UpdateRequest(ES_INDEX, ES_TYPE, id);
            updateRequest.doc(builder);

            UpdateResponse result = this.transportClient.update(updateRequest).get();
            return new ResponseEntity(result.getResult(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 复合查询   价格小于price的novel
     * @param author
     * @param title
     * @param price
     * @return org.springframework.http.ResponseEntity
     * @author CQ
     * @date 2020/1/13 15:29
     */
    @GetMapping("/query/book/novel")
    public ResponseEntity query(@RequestParam(required = false) String author,
                                @RequestParam(required = false) String title,
                                @RequestParam(required = false) Long price){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if(!StringUtils.isEmpty(author)){
            boolQueryBuilder.must(QueryBuilders.matchQuery("author", author));
        }
        if(!StringUtils.isEmpty(title)){
            boolQueryBuilder.must(QueryBuilders.matchQuery("title", title));
        }

        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").from(0);
        if(price != null){
            rangeQueryBuilder.to(price);
        }
        boolQueryBuilder.filter(rangeQueryBuilder);

        SearchRequestBuilder searchRequestBuilder = this.transportClient.prepareSearch(ES_INDEX).setTypes(ES_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder)
                .setFrom(0)
                .setSize(10);
        SearchResponse response = searchRequestBuilder.get();
        List<Map<String, Object>> result = new ArrayList<>();
        for(SearchHit searchHit : response.getHits()){
            result.add(searchHit.getSource());
        }
        return new ResponseEntity(result, HttpStatus.OK);

    }
}
