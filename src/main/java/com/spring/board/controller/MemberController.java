package com.spring.board.controller;

import com.spring.board.domain.MemberVo;
import com.spring.board.entity.Member;
import com.spring.board.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/index")
    public String index(Model model) {

        MemberVo member = new MemberVo();

        member.setMemberName("ROONEY");
        member.setMemberId("World Class");
        member.setMemberPass("RooneyPass");

        memberService.insertMember(member);

        return "index";
    }

    @GetMapping("/member/list")
    public String memberList(Model model) {

        model.addAttribute("memberList", memberService.memberList());

        return "member/memberList";
    }
}
