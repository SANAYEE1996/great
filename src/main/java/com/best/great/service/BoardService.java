package com.best.great.service;

import com.best.great.entity.Board;
import com.best.great.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<Board> getBoard(Pageable pageable){
        return boardRepository.findAll(pageable);
    }


    public Board save(Board board){

        return boardRepository.save(board);
    }
}
