package com.god.dream.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hack on 16/6/13.
 */
@Configuration
@EnableWebSocket
public class BossWebSocketConfigurer implements WebSocketConfigurer {
    private static Map<String, WebSocketHandler> handlerMap = new HashMap<String, WebSocketHandler>();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new DefaultWebSocketHandler(), "/echo").addInterceptors(new DefaultHandshakeInterceptor());
    }
}
