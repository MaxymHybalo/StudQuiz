package ua.chstu.data.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User extends BaseDocument{

    private String login;

    private String password;

    private String email;

    private String role; //TEACHER, PARENT, STUDENT, ADMIN

    private String first;

    private String last;

    private String middle;

    private String sex;

    private String phone;

    public User(String login, String password) {

        this.login = login;
        this.password = password;

    }

    public User() {
    }
}
