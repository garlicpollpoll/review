package hello.review.springcoreprinciple.discount;

import hello.review.springcoreprinciple.member.Grade;
import hello.review.springcoreprinciple.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}