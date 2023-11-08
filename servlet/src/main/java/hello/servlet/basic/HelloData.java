package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// lombok 사용시 어노테이션으로 Getter, Setter 가 자동 추가됨
@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
