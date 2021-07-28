package com.spring.board.domain;

import com.spring.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVo {

    private Long id;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private String author;

    private String title;

    private String content;

    public Board toEntity() {
        Board entity = Board.builder()
                .id(id)
                .regDate(regDate)
                .updateDate(updateDate)
                .author(author)
                .title(title)
                .content(content)
                .build();

        return entity;
    }

    @Builder
    public BoardVo(Long id, LocalDateTime regDate, LocalDateTime updateDate, String author, String title, String content) {
        this.id = id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
