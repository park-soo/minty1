package com.Reboot.Minty.chat.service;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.chat.dto.ChatRoomDTO;
import com.Reboot.Minty.chat.repository.ChatRoomRepository;
import com.Reboot.Minty.member.entity.User;
import com.Reboot.Minty.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    private UserService userService;

    public ChatRoom saveChatRoom(ChatRoomDTO chatRoomDTO) {

        User my = userService.getUserInfoById(chatRoomDTO.getMyId());
        User other = userService.getUserInfoById(chatRoomDTO.getOtherId());

        System.out.println(my.getId());
        System.out.println(other.getId());
        System.out.println(my.getNickName());



        // 중복 체크
        if (chatRoomRepository.existsByMyAndOther(my, other) || my.getId().equals(other.getId())) {
            // 이미 해당 값이 존재하거나 seller가 현재 유저와 동일한 경우 처리할 로직 작성
            System.out.println("중복 및 판매자가 같아");
            throw new IllegalArgumentException("중복 및 판매자가 같은 경우 처리");

        } else {

            ChatRoom chatRoom = new ChatRoom(my, other);
            chatRoomRepository.save(chatRoom);

        return chatRoom;
        }

    }



    public List<ChatRoom> getChatRoomList(User userId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findByOtherOrMyOrderByIdDesc(userId,userId);

        return chatRoomList;
    }

}
