package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //자기자신을 내부에 private, static으로 가짐->클래스 레벨에 올라감 ->딱하나만 존재
    //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }//조회

    private SingletonService(){
    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출출");
    }
}
