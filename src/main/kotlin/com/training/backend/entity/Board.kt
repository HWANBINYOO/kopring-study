package com.training.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "board")
class Board(
    val title: String,

    val description: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 값 관련 부여함수
    val id: Long = 0

    constructor(): this( "", "")
}