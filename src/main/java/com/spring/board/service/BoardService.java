package com.spring.board.service;

import com.spring.board.domain.BoardVo;
import com.spring.board.entity.Board;
import com.spring.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardVo> boardList() {
        List<Board> boardEntityList = boardRepository.findAll();

        List<BoardVo> boardList = new ArrayList<>();

        for(Board boardEntity : boardEntityList) {
            BoardVo boardVo = BoardVo.builder()
                    .id(boardEntity.getId())
                    .regDate(boardEntity.getRegDate())
                    .updateDate(boardEntity.getUpdateDate())
                    .author(boardEntity.getAuthor())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .build();
            boardList.add(boardVo);
        }

        return boardList;
    }
}
