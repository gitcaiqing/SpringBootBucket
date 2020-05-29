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


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootSpringeventApplication.class)
//@WebAppConfiguration
@AutoConfigureMockMvc
@Slf4j
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loginSuccessWithGenericEvent() throws Exception {

        String uri = "/event/login/loginSuccessWithGenericEvent";

        String requestJson = JSONObject.toJSONString("");

        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("loginSuccessWithGenericEvent-请求结果：{}", mockMvcResult);
    }
}