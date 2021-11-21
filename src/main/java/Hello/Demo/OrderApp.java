package Hello.Demo;

import Hello.Demo.member.Grade;
import Hello.Demo.member.Member;
import Hello.Demo.member.MemberService;
import Hello.Demo.order.Order;
import Hello.Demo.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(memberId);
        Order order = orderService.createOrder(memberId, "memberA", 20000);

        System.out.println("new member : " + order);
    }
}
