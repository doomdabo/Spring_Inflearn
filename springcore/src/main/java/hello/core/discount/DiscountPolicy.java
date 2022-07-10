package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액 (1000원 할인 됐어)
     * */

    int discount(Member member,int price);

}
