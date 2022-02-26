package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        @Autowired(required = false) //의존관계 없으면 메소드 자체가 호출이 아예 안된다.
        public void setNoBean1(Member noBean1){
            //없는거 아무거나 집어넣음
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ //호출이 되고 싶을 때 호출은 된다. 대신 널로 들어옴
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ //들어오면 스프링 빈이 없으면 Optional.empty로 값이 들어감
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
