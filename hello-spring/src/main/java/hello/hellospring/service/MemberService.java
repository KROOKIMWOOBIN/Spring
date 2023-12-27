package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.domain.Member;

import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        Optional<Member> result = memberRepository.findById(member.getId());
        result.ifPresent(m -> {
           throw new IllegalStateException(("이미 존재하는 회원입니다."));
        });
        memberRepository.save(member);
        return member.getId();
    }
}
