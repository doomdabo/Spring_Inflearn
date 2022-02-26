package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //파이널 값 가진 두개를 파라미터로 가진 생성자 만들어줌
public class OrderServiceImpl implements OrderService{ //오더 서비스 입장에서는 할인에 대한거 모름 결과만 떨궈줘
    private final MemberRepository memberRepository; //회원찾기
    private final DiscountPolicy discountPolicy;//인터페이스에만 의존

    /* 오더 서비스가 정책을 직접 선택하는것 배우가 직접 상대역을 정하는 것 처럼.
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정할인
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인정책 변경
    위에처럼 하면 OrderServiceImpl이 DiscountPolicy의 인터페이스와 구현 클래스에 둘다 의존. OrderServiceImpl도 바꿔야 하니까!.
    DIP 위반.(추상에만 의존해야지 구현에도 의존하면 안됨)
    * */

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
//할인은 디스카운트 폴리쓰가 알아서 해주는거 ->단일 체계 원칙 잘지켜짐. 할인 명령 있으면 할인쪽만 고치면 된다

