package hello.review.springcoreprinciple.order;

import hello.review.springcoreprinciple.discount.DiscountPolicy;
import hello.review.springcoreprinciple.discount.FixDiscountPolicy;
import hello.review.springcoreprinciple.discount.RateDiscountPolicy;
import hello.review.springcoreprinciple.member.Member;
import hello.review.springcoreprinciple.member.MemberRepository;
import hello.review.springcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;

    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
