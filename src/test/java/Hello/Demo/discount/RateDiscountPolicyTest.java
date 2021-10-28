package Hello.Demo.discount;

import Hello.Demo.member.Grade;
import Hello.Demo.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x(){
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}