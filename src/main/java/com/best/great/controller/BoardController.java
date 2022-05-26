package com.best.great.controller;

import com.best.great.entity.Board;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/board")
public class BoardController {

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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = userDetails.getUsername();
        board.setUsername(username);
        System.out.println("제대로 받아오나? 체크");
        System.out.println("게시판 아이디 : "+board.getId());
        System.out.println("제목 : "+board.getTitle());
        System.out.println("내용 : "+board.getContent());
        System.out.println("유저 네임 : "+board.getUsername());

        return "board/boardPage.html";
    }



}
