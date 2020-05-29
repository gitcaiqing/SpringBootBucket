package com.caiqing.bootjpa.controller;

import com.alibaba.fastjson.JSON;
import com.caiqing.bootjpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addUser() throws Exception {

        User user = new User();
        user.setName("我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我");
        user.setName(null);
        user.setName("");
        String requestJson = JSON.toJSONString(user);
        log.info("测试-请求参数：{}", requestJson);

        String uri = "/user/add";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("测试-响应内容：{}", mockMvcResult);
    }

    @Test
    public void listUserMap() throws Exception {
        String uri = "/user/listUserMap";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("测试-响应内容：{}", mockMvcResult);
    }

    @Test
    public void listUserBean() throws Exception {
        String uri = "/user/listUserBean";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("测试-响应内容：{}", mockMvcResult);
    }

    @Test
    public void listUserName() throws Exception {
        String uri = "/user/listUserName";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("测试-响应内容：{}", mockMvcResult);
    }

    @Test
    public void getUserMap() {
        String uri = "/user/getUserMap";
        try {
            String mockMvcResult = mockMvc
                    .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            log.info("测试-响应内容：{}", mockMvcResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void joinUserMap() {
        String uri = "/user/joinUserMap";
        try {
            String mockMvcResult = mockMvc
                    .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            log.info("测试-响应内容：{}", mockMvcResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}