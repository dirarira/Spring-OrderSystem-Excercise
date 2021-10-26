package Hello.Demo.order;

import Hello.Demo.discount.DiscountPolicy;
import Hello.Demo.discount.FixDiscountPolicy;
import Hello.Demo.member.Member;
import Hello.Demo.member.MemberRepository;
import Hello.Demo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
