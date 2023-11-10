package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.ui.Model;

import java.util.Map;

public interface ControllerV3 {
    // 생성자가 String 뿐인데 해쉬맵을 넘기지?
    ModelView process(Map<String, String> paramMap);
}
