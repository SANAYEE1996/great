package com.best.great.service;

import com.best.great.entity.Board;
import com.best.great.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board save(Board board){

        return boardRepository.save(board);
    }
}
