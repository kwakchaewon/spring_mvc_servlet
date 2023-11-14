package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  1. @Component("/springmvc/old-controller") 에 의해 스프링 빈으로 등록됨
 *  2. 핸들러 조회: @RequestMapping 이 없으므로 스프링 빈 이름 (/springmvc/request-handler) 핸들러 조회/URL 매핑, MyHttpRequestHandler 반환
 *  3. 핸들러 어댑터 조회:  @RequestMapping 사용되지 않음
 *  HttpRequestHandlerAdapter (HttpRequestHandler 인터페이스) 실행하면서 핸들러 정보도 함께 리턴
 */
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
