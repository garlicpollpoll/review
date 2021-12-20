package hello.review.springcoreprinciple;

import hello.review.springcoreprinciple.member.Grade;
import hello.review.springcoreprinciple.member.Member;
import hello.review.springcoreprinciple.member.MemberService;
import hello.review.springcoreprinciple.member.MemberServiceImpl;
import hello.review.springcoreprinciple.order.Order;
import hello.review.springcoreprinciple.order.OrderService;
import hello.review.springcoreprinciple.order.OrderServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
