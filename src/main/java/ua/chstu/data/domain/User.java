package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseDocument{

    private String login;

    private String password;

    private String email;

    private String role; //TEACHER, PARENT, STUDENT

    private String first;

    private String last;

    private String middle;

    private String sex;

    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", middle='" + middle + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public User(String login, String password) {

        this.login = login;
        this.password = password;

    }

    public User() {
    }
}
