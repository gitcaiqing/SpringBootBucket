package com.caiqing.bootelasticsearch.controller;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/1/6 16:18
 **/
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private TransportClient transportClient;

    @RequestMapping("/add/book/novel")
    public ResponseEntity add(@RequestParam String title, @RequestParam String author){

        XContentBuilder content;
        try {
            content = XContentFactory.jsonBuilder().startObject()
                    .field("title", title)
                    .field("author", author)
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        IndexResponse result = this.transportClient.prepareIndex("book", "novel")
                .setSource(content).get();
        return new ResponseEntity(result.getId(), HttpStatus.OK);
    }

}
