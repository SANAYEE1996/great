package com.best.great.controller;

import com.best.great.entity.Board;
import com.best.great.service.BoardService;
import com.best.great.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;


    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable){
        Page<Board> boards = boardService.getBoard(pageable);
        int startPage = Math.max(1,boards.getPageable().getPageNumber()-4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber()+4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards",boards);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/write")
    public String write(Board board){
        board.setUsername(userService.getUsername());
        System.out.println("제대로 받아오나? 체크");
        System.out.println("제목 : "+board.getTitle());
        System.out.println("내용 : "+board.getContent());
        System.out.println("유저 네임 : "+board.getUsername());
        boardService.save(board);

        return "redirect:/board/list";
    }



}
