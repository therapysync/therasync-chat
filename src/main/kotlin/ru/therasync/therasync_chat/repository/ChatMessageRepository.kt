package ru.therasync.therasync_chat.repository

import ru.therasync.therasync_chat.model.ChatMessage
import org.springframework.data.jpa.repository.JpaRepository

interface ChatMessageRepository : JpaRepository<ChatMessage, Long> {
    fun findByRoomIdOrderByTimestampAsc(roomId: Long): List<ChatMessage>
}