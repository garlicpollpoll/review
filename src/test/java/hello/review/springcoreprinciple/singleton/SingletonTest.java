package hello.review.springcoreprinciple.singleton;

import hello.review.springcoreprinciple.AppConfig;
import hello.review.springcoreprinciple.member.MemberService;
import hello.review.springcoreprinciple.member.MemberServiceImpl;
import hello.review.springcoreprinciple.member.MemoryMemberRepository;
import hello.review.springcoreprinciple.order.OrderService;
import hello.review.springcoreprinciple.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("세번 호출되는지 확인하는 테스트")
    void singletonTest() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        System.out.println("memberService = " + memberService.getMemberRepository());
        System.out.println("orderService = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
    }
}
