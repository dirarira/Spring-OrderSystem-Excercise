package Hello.Demo;

import Hello.Demo.discount.DiscountPolicy;
import Hello.Demo.discount.RateDiscountPolicy;
import Hello.Demo.member.MemberRepository;
import Hello.Demo.member.MemberService;
import Hello.Demo.member.MemberServiceImpl;
import Hello.Demo.member.MemoryMemberRepository;
import Hello.Demo.order.OrderService;
import Hello.Demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
