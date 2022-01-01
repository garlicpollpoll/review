package hello.review.springcoreprinciple;

import hello.review.springcoreprinciple.discount.DiscountPolicy;
import hello.review.springcoreprinciple.discount.FixDiscountPolicy;
import hello.review.springcoreprinciple.discount.RateDiscountPolicy;
import hello.review.springcoreprinciple.member.MemberService;
import hello.review.springcoreprinciple.member.MemberServiceImpl;
import hello.review.springcoreprinciple.member.MemoryMemberRepository;
import hello.review.springcoreprinciple.order.OrderService;
import hello.review.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
