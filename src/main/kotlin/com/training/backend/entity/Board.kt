package com.training.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "board")
class Board(
    var title: String,
    var description: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 값 관련 부여함수
    val id: Long = 0

    /*
    FetchType.LAZY - comments 를 참조해야 가져옴 / 쿼리 1번
    FetchType.EAGER - comments 를 참조하지 않아도 가져옴 / 쿼리 2번
     */
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    val comments: MutableList<Comment> = mutableListOf()

    constructor(): this( "", "")

    fun addComment(comment: Comment) {
        comments.add(comment)
    }
}