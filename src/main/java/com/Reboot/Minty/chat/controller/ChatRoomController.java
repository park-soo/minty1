package com.Reboot.Minty.chat.controller;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.chat.service.ChatRoomService;
import com.Reboot.Minty.member.entity.User;
import com.Reboot.Minty.member.service.UserService;
import com.Reboot.Minty.trade.entity.Trade;
import com.Reboot.Minty.tradeBoard.entity.TradeBoard;
import com.google.api.Http;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatRoomController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatRoomService chatRoomService;


    @PostMapping("/chatRoom")
    public String chatRoom(@RequestBody TradeBoard tradeBoard, HttpSession session) {

        System.out.println(tradeBoard.getUser().getId());
        System.out.println(tradeBoard.getContent());

            User buyer = userService.getUserInfoById((Long) session.getAttribute("userId"));
            User seller = userService.getUserInfoById(tradeBoard.getUser().getId());

        System.out.println(tradeBoard.getUser().getId());
        System.out.println(tradeBoard.getContent());
        System.out.println(buyer);

            chatRoomService.seveChatRoom(buyer, seller);

        return "redirect:/chatRoom";
    }


    @GetMapping("/chatRoom")
    public String getChatRoom(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");

        List<ChatRoom> chatRoomList = chatRoomService.getChatRoomList(userId);

        model.addAttribute("chatRoomLists",chatRoomList);

        return "chat/chatRoom";
    }







}
