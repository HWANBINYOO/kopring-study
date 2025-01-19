package com.training.backend.repository

import com.training.backend.entity.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<Board, Long> { // insert into BOARD  (id, title, description) values (1, 'hello', 'world');

}