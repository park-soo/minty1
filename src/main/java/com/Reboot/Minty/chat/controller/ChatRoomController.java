package com.Reboot.Minty.chat.controller;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.chat.service.ChatRoomService;
import com.Reboot.Minty.member.entity.User;
import com.Reboot.Minty.member.service.UserService;
import com.Reboot.Minty.tradeBoard.entity.TradeBoard;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatRoomController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatRoomService chatRoomService;


//    @PostMapping("/chatRoom")
//    @ResponseBody
//    public ResponseEntity<?> chatRoom(@RequestBody TradeBoard tradeBoard, HttpSession session) {
//
//        System.out.println(tradeBoard.getUser().getId());
//        System.out.println(tradeBoard.getContent());
//        ;
//            User buyer = userService.getUserInfoById((Long) session.getAttribute("userId"));
//            User seller = userService.getUserInfoById(tradeBoard.getUser().getId());
//
//            chatRoomService.seveChatRoom(buyer, seller);
//
//            //return ResponseEntity.ok().redirect("chat/chatRoom.html");
//    }

    @GetMapping("/chatRoom")
    public String getChatRoom() {
        return "chat/chatRoom";
    }






}
