package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 1. front-controller 하위의 어떠한 url 이든 호출
@WebServlet(name = "frontControllerServletV1" ,urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // 2. url 을 담을 HashMap 선언
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    // 3. 생성자 안에 url 담기
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");
        
        // 4. request 로부터 url 을 꺼내와 controllerMap 에서 일치하는 컨트롤러를 찾음
        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);

        // 없으면 404 return
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 5. 해당 컨트롤러 인스턴스 반환
        controller.process(request, response);
    }
}
