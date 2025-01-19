package com.training.backend.controller

import com.training.backend.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class Controller(
    private val boardService: BoardService, // spring DI, IoC 컨테이너
) {
    @GetMapping("hello")
    fun hello(): String {
        return "Hello World"
    }

    @GetMapping
    fun getBoards(): List<BoardResponse> {
        return boardService.getBoards()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBoard(@RequestBody request: BoardRequest) {
        boardService.createBoard(request)
    }
}

data class BoardRequest(
    val title: String,
    val description: String
)

data class BoardResponse(
    val id: Long, // val == 불변,
    var title: String, // var == 가변
    val description: String,
    //adf
)
