package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  1. @Component("/springmvc/old-controller") 에 의해 스프링 빈으로 등록됨
 *  2. 핸들러 조회: @RequestMapping 이 없으므로 스프링 빈 이름 (/springmvc/old-controller) 핸들러 조회/URL 매핑, OldController 반환
 *  3. 핸들러 어댑터 조회:  @RequestMapping, HttpRequestHandler가 사용되지 않음
 *  SimpleControllerHandlerAdapter (Controller 인터페이스) 실행하면서 핸들러 정보도 함께 리턴
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return null;
    }
}
