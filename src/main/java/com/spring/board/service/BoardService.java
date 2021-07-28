package com.spring.board.service;

import com.spring.board.domain.BoardVo;
import com.spring.board.entity.Board;
import com.spring.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    private static final int BlockPageCount = 5;
    private static final int PageArticleCount = 10;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void boardInsert(BoardVo vo) {
        Board board = Board.builder()
                        .id(vo.getId())
                        .regDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .author(vo.getAuthor())
                        .title(vo.getTitle())
                        .content(vo.getContent())
                        .build();

        boardRepository.save(board);
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

    public List<BoardVo> getBoardList(Integer pageNum) {

        Page<Board> page = boardRepository.findAll(PageRequest.of(
                pageNum-1, PageArticleCount, Sort.by(Sort.Direction.DESC, "id")
        ));

        List<Board> boards = page.getContent();
        List<BoardVo> boardList = new ArrayList<>();

        for (Board board : boards) {
            BoardVo boardVo = BoardVo.builder()
                    .id(board.getId())
                    .regDate(board.getRegDate())
                    .updateDate(board.getUpdateDate())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent()).build();

            boardList.add(boardVo);
        }

        return boardList;
    }
}
