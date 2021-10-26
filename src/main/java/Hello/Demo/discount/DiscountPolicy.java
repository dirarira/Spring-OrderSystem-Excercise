package Hello.Demo.discount;

import Hello.Demo.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
