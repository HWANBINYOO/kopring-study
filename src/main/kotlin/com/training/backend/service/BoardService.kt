package com.training.backend.service

import com.training.backend.controller.BoardRequest
import com.training.backend.controller.BoardResponse
import com.training.backend.entity.Board
import com.training.backend.repository.BoardRepository
import org.springframework.stereotype.Component

@Component
class BoardService(
    private val boardRepository: BoardRepository,
) {
    fun createBoard(request: BoardRequest) {
        val board = Board(
            title = request.title,
            description = request.description,
        )
        boardRepository.save(board)
    }

    fun modifyBoard(request: BoardRequest, id : Long) {
        val board = Board(
            title = request.title,
            description = request.description,
        )
//        boardRepository.
    }

    fun deleteBoard(id: Long) {
        boardRepository.deleteById(id)
    }

    fun getBoards(): List<BoardResponse> {
        // DB 붙여서 가져오는 로직이 있을거임
        return boardRepository.findAll().map { board ->
            BoardResponse(board.id, board.title, board.description)
        }
    }
}