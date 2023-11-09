package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    // 싱글톤으로 만들때는 private으로 생성자를 생성해 아무나 생성하지 못하도록 막음
    private MemberRepository(){
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
        // new 로 선언한 이유: store 값들을 보호하려고
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }




}
