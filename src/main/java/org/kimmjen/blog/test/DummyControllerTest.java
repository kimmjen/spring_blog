package org.kimmjen.blog.test;

import java.util.function.Supplier;

import org.kimmjen.blog.model.RoleType;
import org.kimmjen.blog.model.User;
import org.kimmjen.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// html 파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입(DI)
    private UserRepository userRepository;

    // {id} 주소로 파라미터를 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {

        // user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것인가?
        // 그럼 return null이 리턴이 되기 때문에 문제가 발생.
        // 따라서 Optional로 user객체를 감싸서 가져와 null인지 아닌지 판단해서 return
        // User user = userRepository.findById(id).orElseGet(new Supplier<User>(){

        // @Override
        // public User get() {
        // return new User();
        // }
        // });
        // User user = userRepository.findById(id).orElseThrow(new
        // Supplier<IllegalArgumentException>() {

        // @Override
        // public IllegalArgumentException get() {
        // return new IllegalArgumentException("해당 유저는 없습니다. id" + id);
        // }
        // });
        // User user = userRepository.findById(id).get();
        // 람다식
        // User user = userRepository.findById(id).orElseThrow(() -> {
        // return new IllegalArgumentException("해당 유저는 없습니다.");
        // });
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다.");
            }
        });
        // 요청 : 웹브라우저
        // user 객체 : 자바 오브젝트
        // 변환 (웹 브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
        // 스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에게 던진다.
        return user;
    }

    // http://localhost:8000/blog/dummy/join (요청)
    // http의 body에 username, password, email 데이터를 가지고 요청
    @PostMapping("/dummy/join")
    // public String join(String username, String password, String email) { //
    // key=value (약속된 규칙)
    public String join(User user) {

        System.out.println("id : " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role : " + user.getRole());
        System.out.println("createDate : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}
