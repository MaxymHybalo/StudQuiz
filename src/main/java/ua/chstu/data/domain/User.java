package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseDocument{

    private String login;

    private String password;

    private String role;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String login,String password) {

        this.login = login;
        this.password = password;

    }

    public User() {
    }
}
