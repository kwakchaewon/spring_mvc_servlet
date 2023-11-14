package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // 해당 컨트롤러 처리할 수 있는지 판단 메서드
    boolean supports(Object handler);

    // 어댑터를 통해 실제 컨트롤러 호출, ModelVeiw 반환
    // 프론트 컨트롤러가 호출하던걸 어댑터를 통해 컨트롤러 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
