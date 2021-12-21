package hello.review.springcoreprinciple;

import hello.review.springcoreprinciple.member.Grade;
import hello.review.springcoreprinciple.member.Member;
import hello.review.springcoreprinciple.member.MemberService;
import hello.review.springcoreprinciple.member.MemberServiceImpl;
import hello.review.springcoreprinciple.order.Order;
import hello.review.springcoreprinciple.order.OrderService;
import hello.review.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
