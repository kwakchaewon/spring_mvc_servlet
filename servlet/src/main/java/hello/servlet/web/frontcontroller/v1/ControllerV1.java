package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    // servlet 과 같은 패턴의 인터페이스. 각 컨트롤러는 이 인터페이스 구현하며, 구현과 관계없이 로직의 일광성을 유지.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
