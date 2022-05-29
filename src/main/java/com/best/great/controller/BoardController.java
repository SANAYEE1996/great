package com.best.great.controller;

import com.best.great.entity.Board;
import com.best.great.service.BoardService;
import com.best.great.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public String board(){
        return "board/boardPage.html";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/write")
    public String write(Board board){
        board.setUsername(userService.getUsername());
        System.out.println("제대로 받아오나? 체크");
        System.out.println("게시판 아이디 : "+board.getId());
        System.out.println("제목 : "+board.getTitle());
        System.out.println("내용 : "+board.getContent());
        System.out.println("유저 네임 : "+board.getUsername());
        boardService.save(board);

        return "redirect:/board";
    }



}
