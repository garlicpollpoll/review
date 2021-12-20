package hello.review.springcoreprinciple.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
