package ua.chstu.data.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Used for saving data for user tab and list for group detail
 */
@Getter
@Setter
@ToString
public class Student {

    private String name;

    private String login;
    private String password;
    private String id;

    private String groupName;


    public Student(String first,
                   String last,
                   String login,
                   String password,
                   String id) {
        this.name = last + " " + first;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public Student(String first,
                   String last,
                   String login,
                   String password,
                   String id, String groupName){
        this(first, last, login, password,id);
        this.groupName = groupName;
    }
}
