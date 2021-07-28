package com.spring.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private String author;

    private String title;

    private String content;

    @Builder
    public Board(Long id, LocalDateTime regDate, LocalDateTime updateDate, String author, String title, String content) {
        this.id = id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
