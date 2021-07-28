package org.kimmjen.guest.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
@Data
@Builder
@AllArgsConstructor // 생성자, 모든 필드 생성자
@NoArgsConstructor // 빈 생성자, 전체
// @RequiredArgsConstructor // final 붙은 애들에 대한 contstuctor 만들어줌
public class Member {

    private int id;
    private String username;
    private String password;
    private String email;

    // 불변성유지 final

    // public int getId() {
    // return id;
    // }
    // public void setId(int id) {
    // this.id = id;
    // }
    // public String getUsername() {
    // return username;
    // }
    // public void setUsername(String username) {
    // this.username = username;
    // }
    // public String getPassword() {
    // return password;
    // }
    // public void setPassword(String password) {
    // this.password = password;
    // }
    // public String getEmail() {
    // return email;
    // }
    // public void setEmail(String email) {
    // this.email = email;
    // }

//    @Builder
    // public Member(int id, String username, String password, String email) {
    // super();
    // this.id = id;
    // this.username = username;
    // this.password = password;
    // this.email = email;
    // }

}
