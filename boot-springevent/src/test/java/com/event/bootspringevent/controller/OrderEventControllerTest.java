package com.event.bootspringevent.controller;

import com.alibaba.fastjson.JSONObject;
import com.event.bootspringevent.BootSpringeventApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootSpringeventApplication.class)
//@WebAppConfiguration
@AutoConfigureMockMvc
@Slf4j
public class OrderEventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception {

        String uri = "/event/order/createOrder";

        String requestJson = JSONObject.toJSONString("");

        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("createOrder测试-请求结果：{}",mockMvcResult);
    }

    @Test
    public void createOrderWithEventSync() throws Exception {

        String uri = "/event/order/createOrderWithEventSync";

        String requestJson = JSONObject.toJSONString("");

        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("createOrderWithEventSync-请求结果：{}",mockMvcResult);
    }

    /**
     * 异步
     * @param
     * @return void
     * @author CQ
     * @date 2020/2/21 16:47
     */
    @Test
    public void createOrderWithEventAsync() throws Exception {

        String uri = "/event/order/createOrderWithEventAsync";

        String requestJson = JSONObject.toJSONString("");

        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("createOrderWithEventAsync-请求结果：{}",mockMvcResult);
    }

    /**
     * 泛型
     * @param
     * @return void
     * @author CQ
     * @date 2020/2/21 16:47
     */
    @Test
    public void createOrderWithGenericEvent() throws Exception {

        String uri = "/event/order/createOrderWithGenericEvent";

        String requestJson = JSONObject.toJSONString("");

        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("createOrderWithEventAsync-请求结果：{}",mockMvcResult);
    }
}