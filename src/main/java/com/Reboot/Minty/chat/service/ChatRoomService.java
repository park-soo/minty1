package com.Reboot.Minty.chat.service;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.chat.repository.ChatRoomRepository;
import com.Reboot.Minty.member.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    public ChatRoom seveChatRoom(User my, User other) {

        System.out.println(my.getId());
        System.out.println(other.getId());

        ChatRoom chatRoom = new ChatRoom();
        // 중복 체크
        if (chatRoomRepository.existsByMyAndOther(my.getId(), other.getId()) ||
                other.equals(my.getId())) {
            // 이미 해당 값이 존재하거나 seller가 현재 유저와 동일한 경우 처리할 로직 작성
            System.out.println("중복 및 판매자가 같아");

        } else {
            chatRoom.setMy(my.getId());
            chatRoom.setOther(other.getId());

            chatRoomRepository.save(chatRoom);

        }
        return chatRoom;

    }

    public List<ChatRoom> getChatRoomList(Long userId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findByOtherOrMyOrderByIdDesc(userId, userId);

        return chatRoomList;
    }

}
