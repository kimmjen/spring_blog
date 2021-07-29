package org.kimmjen.guest.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    // http://localhost:8080/blog/temp/home
    @GetMapping("/temp/home")
    public String testHome() {
        System.out.println("tempHome()");
        // 스프링 파일 기본 경로 : src/main/resources/static
        // 리턴 명을 : /home.html "/" 슬러쉬 를 붙여야함
        // 풀경로 : src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg() {
        return "/a.png";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // preifx : /WEB-INF/views/
        // suffix : .jsp
        // 풀네임 : /WEB-INF/views/test.jsp
        return "/test";
    }
}
