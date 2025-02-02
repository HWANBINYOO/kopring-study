package com.training.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment(
    val userName: String,
    val content: String,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    val board: Board
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    constructor(): this("", "", Board())
}