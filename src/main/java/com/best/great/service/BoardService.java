package com.best.great.service;

import com.best.great.entity.Board;
import com.best.great.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BoardService {


    BoardRepository boardRepository;

    public Page<Board> getBoard(Pageable pageable){
        return boardRepository.findAll(pageable);
    }


    public void save(Board board){

        boardRepository.save(board);
    }
}
