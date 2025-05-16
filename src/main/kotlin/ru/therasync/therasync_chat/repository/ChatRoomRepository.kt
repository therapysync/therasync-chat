package ru.therasync.therasync_chat.repository

import ru.therasync.therasync_chat.model.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository

interface ChatRoomRepository : JpaRepository<ChatRoom, Long> {
    fun findByParticipant1IdOrParticipant2Id(userId1: Long, userId2: Long): List<ChatRoom>
}