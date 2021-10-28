package Hello.Demo;

import Hello.Demo.discount.FixDiscountPolicy;
import Hello.Demo.member.MemberService;
import Hello.Demo.member.MemberServiceImpl;
import Hello.Demo.member.MemoryMemberRepository;
import Hello.Demo.order.OrderService;
import Hello.Demo.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
