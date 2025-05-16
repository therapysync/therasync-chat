package ru.therasync.therasync_chat.model

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "chat_rooms")
data class ChatRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "participant1_id", nullable = false)
    val participant1Id: Long,  // ID психолога

    @Column(name = "participant2_id", nullable = false)
    val participant2Id: Long,  // ID пользователя

    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Instant.now()
)