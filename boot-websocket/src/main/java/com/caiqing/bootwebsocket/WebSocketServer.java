package com.caiqing.bootwebsocket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.LongAdder;


/**
  *  ━━━━━━神兽出没━━━━━━ 
  *　　　┏┓　　　┏┓ 
  *　　┏┛┻━━━┛┻┓ 
  *　    ┃　　　　　　　┃
  *　   ┃　　　━　　　┃ 
  *　    ┃　┳┛　┗┳    ┃ 
  *　　┃　　　　　　　┃ 
  *　　┃　　　┻　　　┃ 
  *　　┃　　　　　　　┃ 
  *　　┗━┓　　　┏━┛ 
  *　　　　┃　　　┃   
  *　　　　┃　　　┃ 
  *　　　　┃　　　┗━━━┓ 
  *　　　　┃　　　　　　　┣┓ 
  *　　　　┃　　　　　　　┏┛ 
  *　　　　┗┓┓┏━┳┓┏┛ 
  *　　　　　┃┫┫　┃┫┫ 
  *　　　　　┗┻┛　┗┻┛ 
  * 
  * ━━━━━━感觉萌萌哒━━━━━━ 
  */
@ServerEndpoint(value = "/websocket")
@Component
@Slf4j
public class WebSocketServer {

    //记录当前websocket的连接数，保证线程安全
    private static LongAdder connectAccount = new LongAdder();

    //存放每个客户端对应的websocketServer对象（需保证线程安全）
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    //与客户端的连接对象
    private Session session;

    /**
     * 连接成功
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        //连接数+1
        connectAccount.increment();
        log.info("有新的连接接入，当前连接数为{}", connectAccount);
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        //连接数据-1
        connectAccount.decrement();
        log.info("有连接关闭，当前连接数为：{}",connectAccount);
    }

    /**
     * 收到客户端消息时调用
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        log.info("收到客户端发来的消息，message -->{}", message);
    }

    /**
     * 发送消息
     * @param messaeg
     */
    public void sendMessage(String messaeg) throws IOException {
        this.session.getBasicRemote().sendText(messaeg);
    }

    /**
     * 群发消息
     * @param message
     */
    public static void sendInfo(String message){
        for(WebSocketServer webSocketService : webSocketSet){
            try {
                webSocketService.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
