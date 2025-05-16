package ru.therasync.therasync_chat.controller

import ru.therasync.therasync_chat.model.ChatMessage
import ru.therasync.therasync_chat.model.ChatRoom
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.therasync.therasync_chat.repository.ChatMessageRepository
import ru.therasync.therasync_chat.repository.ChatRoomRepository

@RestController
@RequestMapping("/api/chat")
class ChatController(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatMessageRepository: ChatMessageRepository
) {
    @GetMapping("/rooms/{userId}")
    fun getChatRooms(@PathVariable userId: Long): List<ChatRoom> {
        return chatRoomRepository.findByParticipant1IdOrParticipant2Id(userId, userId)
    }

    @GetMapping("/messages/{roomId}")
    fun getMessages(@PathVariable roomId: Long): List<ChatMessage> {
        return chatMessageRepository.findByRoomIdOrderByTimestampAsc(roomId)
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    fun sendMessage(message: ChatMessage): ChatMessage {
        val savedMessage = chatMessageRepository.save(message)
        return savedMessage
    }
}