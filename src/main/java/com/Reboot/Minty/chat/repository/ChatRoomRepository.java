package com.Reboot.Minty.chat.repository;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {


    boolean existsByBuyerAndSeller(User buyer, User seller);

}
