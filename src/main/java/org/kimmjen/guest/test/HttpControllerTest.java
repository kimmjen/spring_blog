package org.kimmjen.guest.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// 사용자가 요청 -> 응답(HTML파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    // http://localhost:8080/http/get
    // @GetMapping("/http/get")
    // // (POSTMAN = GET -> http://localhost:8080/http/get?id=1&username=ssar)
    // public String getTest1(@RequestParam int id, @RequestParam String username) {
    // return "get요청" + id + "," + username;
    // }

    @GetMapping("/http/lombok")
    public String lombokTest() {

        // Member m = new Member(1, "kimmjen", "1234", "email");
        Member m = Member.builder().username("kimmjen").password("1234").email("email").build();

        System.out.println(TAG + "getter" + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter" + m.getId());
        return "lombok TEST 완료";
    }

    // 위와 같은 방법도 존재하나 한번에 받는방법
    @GetMapping("/http/get")
    public String getTest(Member m) {



        return "get요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") // test/plain(평문), application/json
    public String postTest(@RequestBody String text) {
        return "post요청" + text;
    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest() {
        return "put요청";
    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete요청";
    }
}
