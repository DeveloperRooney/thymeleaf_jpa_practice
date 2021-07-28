package com.spring.board.domain;

import com.spring.board.entity.Member;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberVo {

    private Long id;

    private String memberId;


    private String memberName;

    private String memberPass;

    public Member toEntity(){
        Member build = Member.builder()
                .id(id)
                .memberId(memberId)
                .memberName(memberName)
                .memberPass(memberPass)
                .build();

        return build;
    }

    @Builder
    public MemberVo(Long id, String memberId, String memberName, String memberPass) {
        this.id = id;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPass = memberPass;
    }
}
