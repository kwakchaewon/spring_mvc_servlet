package hello.servlet.basic.response;

import javax.lang.model.element.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet" ,urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // [status-line] : Status 200 or 400 세팅
        // response.setStatus(HttpServletResponse.SC_OK);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        // [response-header]
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        content(response);

        // 캐시 무효화
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache"); //

        // 내가 임의의 값 싣기
        response.setHeader("my-header","hello");

        // 앞의 값 상관없이 redirect 로 덮어버림
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok, 반갑습니다. 소통해요");
    }

    // Content 편의 메서드
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //response.setContentLength(2); //(생략시 자동 생성)
    }

    // 쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        
        // 쿠캐 객체 생성 후 response에 담기
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    // redirect 편의 메서드: 302 설정 후 hello-form.html 로 보내버리기
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        
        // 302 로 설정후 리다이렉트
        response.sendRedirect("/basic/hello-form.html");
    }
}
