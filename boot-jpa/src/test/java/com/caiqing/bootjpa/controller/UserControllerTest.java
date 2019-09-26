package com.caiqing.bootjpa.controller;

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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addUser() throws Exception {
        String uri = "/user/add";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mockMvcResult);
    }

    @Test
    public void listUserMap() throws Exception {
        String uri = "/user/listUserMap";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mockMvcResult);
    }

    @Test
    public void listUserBean() throws Exception {
        String uri = "/user/listUserBean";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mockMvcResult);
    }

    @Test
    public void listUserName() throws Exception {
        String uri = "/user/listUserName";
        String mockMvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mockMvcResult);
    }
}