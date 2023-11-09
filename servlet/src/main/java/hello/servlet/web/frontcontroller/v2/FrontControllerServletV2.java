package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 1. front-controller 하위의 어떠한 url 이든 호출
@WebServlet(name = "frontControllerServletV2" ,urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    // 2. url 을 담을 HashMap 선언
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    // 3. 생성자 안에 url 담기
    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");
        
        // 4. request 로부터 url 을 꺼내와 controllerMap 에서 일치하는 컨트롤러를 찾음
        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        // 없으면 404 return
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 5. 해당 컨트롤러 인스턴스 반환
        MyView view = controller.process(request, response);
        view.render(request,response);
    }
}
