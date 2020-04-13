package com.example.demo.controller;

import com.example.demo.utils.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

@RequestMapping("/")
@RestController
public class WebsocketController {

    @GetMapping("/index")
    public ResponseEntity<String> show(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("/")
    public ModelAndView page(){
        return new ModelAndView("test");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
