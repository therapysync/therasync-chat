package ru.therasync.therasync_chat.model

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "messages")
data class ChatMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "room_id", nullable = false)
    val roomId: Long,

    @Column(name = "sender_id", nullable = false)
    val senderId: Long,

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    val content: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: MessageStatus = MessageStatus.SENT,

    @Column(name = "timestamp", nullable = false)
    val timestamp: Instant = Instant.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    val room: ChatRoom? = null
)
