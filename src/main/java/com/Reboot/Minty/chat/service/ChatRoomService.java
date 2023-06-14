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

    public ChatRoom seveChatRoom(User buyer, User seller) {

        System.out.println(buyer.getId());
        System.out.println(seller.getId());
        // 중복 체크
//        if (chatRoomRepository.existsByBuyerAndSeller(buyer, seller) ||
//                seller.equals(buyer)) {
//            // 이미 해당 값이 존재하거나 seller가 현재 유저와 동일한 경우 처리할 로직 작성
//            System.out.println("중복 및 판매자가 같아");
//            return null;
//        }

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setBuyer(buyer.getId());
        chatRoom.setSeller(seller.getId());

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

    public List<ChatRoom> getChatRoomList(Long userId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findBySellerOrBuyerOrderByIdDesc(userId, userId);



        return chatRoomList;
    }

}
