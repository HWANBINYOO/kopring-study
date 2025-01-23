package com.training.backend.service

import com.training.backend.controller.BoardRequest
import com.training.backend.controller.BoardResponse
import com.training.backend.entity.Board
import com.training.backend.repository.BoardRepository
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class BoardService(
    private val em: EntityManager,  // EntityManager 주입
    private val boardRepository: BoardRepository,
) {
    fun createBoard(request: BoardRequest) {
        val board = Board(
            title = request.title,
            description = request.description,
        )
        boardRepository.save(board)
    }

    fun modifyBoard(request: BoardRequest, id: Long) {
        val board = em.find(Board::class.java, id) ?: throw IllegalArgumentException("Board not found with id: $id")
        board.title = request.title
        board.description = request.description
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