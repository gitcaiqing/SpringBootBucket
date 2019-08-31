package com.caiqing.bootwebsocket.controller;

import com.caiqing.bootwebsocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/7/30 18:47
 **/
@RestController
@RequestMapping(value = "/websocketsend")
public class WebSocketSendController {

    @GetMapping(value = "/sendString")
    public boolean sendString(String message){
        try {
            WebSocketServer webSocketServer = new WebSocketServer();
            webSocketServer.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
