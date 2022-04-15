package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence=0L;
    private static final MemberRepository instance= new MemberRepository();
    //싱글톤으로 만드는 것
    private MemberRepository(){ //private으로 생성자 막아야한다. 아무나 못생성하게!
    }
    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }
    public Member findById(Long id){
        return store.get(id);
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
