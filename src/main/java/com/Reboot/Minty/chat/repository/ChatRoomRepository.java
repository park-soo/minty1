package com.Reboot.Minty.chat.repository;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    List<ChatRoom> findBySellerOrBuyerOrderByIdDesc(Long userId, Long userId1);
}
