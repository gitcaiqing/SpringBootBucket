package com.caiqing.bootelasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/1/6 16:53
 **/
@Configuration
public class TransportClientConfig {

    //elasticsearch配置
    @Autowired
    private EsProperties esProperties;

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", esProperties.getClusterName()).build();
        TransportClient client = new PreBuiltTransportClient(settings);//6.3.2这里TransportAddress代替InetSocketTransportAddress
        /*client.addTransportAddress(new InetSocketTransportAddress(
                new InetSocketAddress(InetAddresses.forString("127.0.0.1"), 9300)));*/

        Map<String, Integer> nodeMap = parseNodeIpInfo(esProperties.getClusterNodes());
        for (Map.Entry<String, Integer> entry : nodeMap.entrySet()) {
            client.addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName(entry.getKey()), entry.getValue()));
        }

        return client;
    }

    /**
     * 解析节点IP信息,多个节点用逗号隔开,IP和端口用冒号隔开
     * @return
     */
    private Map<String, Integer> parseNodeIpInfo(String clusterNodes) {
        String[] nodeIpInfoArr = clusterNodes.split(","); //esNodes为外部注入的es的ip
        Map<String, Integer> map = new HashMap<String, Integer>(nodeIpInfoArr.length);
        for (String ipInfo : nodeIpInfoArr) {
            String[] ipInfoArr = ipInfo.split(":");
            map.put(ipInfoArr[0], Integer.parseInt(ipInfoArr[1]));
        }
        return map;
    }
}
