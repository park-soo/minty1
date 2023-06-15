package com.Reboot.Minty.chat.service;

import com.Reboot.Minty.chat.Entity.ChatRoom;
import com.Reboot.Minty.chat.repository.ChatRoomRepository;
import com.Reboot.Minty.member.entity.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserAndGroupService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ChatRoomRepository chatRoomRepository;


    public List<Map<String,Object>> fetchAll(String myId) {
        List<Map<String,Object>> getAllUser = jdbcTemplate.queryForList("SELECT * FROM chat_room WHERE my = ? OR other = ? ORDER BY id DESC", myId, myId);
        return getAllUser;
    }


    public List<ChatRoom> getChatRoomList(User userId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findByOtherOrMyOrderByIdDesc(userId,userId);

        return chatRoomList;
    }


    public List<Map<String,Object>> fetchAllGroup(String groupId) {
        List<Map<String,Object>> getAllUser=jdbcTemplate.queryForList("SELECT gr.* FROM `groupss` gr " +
                "join group_members gm on gm.group_id=gr.id and gm.user_id=?",groupId);

        return getAllUser;
    }
}
