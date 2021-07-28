package com.spring.board.controller;

import com.spring.board.domain.BoardVo;
import com.spring.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("boardList", boardService.boardList());

        return "board/boardList";
    }

    @GetMapping("/board/listPage")
    public String boardList(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {


        model.addAttribute("boardList", boardService.getBoardList(pageNum));

        return "board/boardList";
    }

    @GetMapping("/board/write")
    public String boardWrite() {

        return "board/boardWrite";
    }

    @PostMapping("/board/write")
    public String boardWriteDo(BoardVo vo) {


        System.out.println(vo.getAuthor());
        System.out.println(vo.getTitle());
        System.out.println(vo.getContent());

        boardService.boardInsert(vo);

        return "redirect:/board/list";
    }
}
