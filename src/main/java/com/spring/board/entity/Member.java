package com.spring.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pass")
    private String memberPass;

    @Column(name = "member_name")
    private String memberName;

    @Builder
    public Member(Long id, String memberId, String memberPass, String memberName){
        this.id = id;
        this.memberId = memberId;
        this.memberPass = memberPass;
        this.memberName = memberName;
    }

}