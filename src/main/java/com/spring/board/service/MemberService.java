package com.spring.board.service;


import com.spring.board.domain.MemberVo;
import com.spring.board.entity.Member;
import com.spring.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> searchMember(Long id){

        Optional<Member> member = memberRepository.findById(id);

        System.out.println();

        return member;
    }

    public void insertMember(MemberVo member) {

        memberRepository.save(member.toEntity());
    }

    public List<MemberVo> memberList() {
        List<Member> memberEntityList = memberRepository.findAll();

        List<MemberVo> memberList = new ArrayList<>();

        for (Member memberEntity : memberEntityList) {
            MemberVo memberVo = MemberVo.builder()
                    .id(memberEntity.getId())
                    .memberId(memberEntity.getMemberId())
                    .memberName(memberEntity.getMemberName())
                    .memberPass(memberEntity.getMemberPass())
                    .build();

            memberList.add(memberVo);
        }

        return memberList;
    }
}
