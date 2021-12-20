package hello.review.springcoreprinciple.order;

import hello.review.springcoreprinciple.discount.DiscountPolicy;
import hello.review.springcoreprinciple.discount.FixDiscountPolicy;
import hello.review.springcoreprinciple.member.Member;
import hello.review.springcoreprinciple.member.MemberRepository;
import hello.review.springcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
