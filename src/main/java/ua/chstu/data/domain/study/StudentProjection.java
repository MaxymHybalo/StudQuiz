package ua.chstu.data.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.chstu.data.domain.User;

@Getter
@Setter
@ToString
public class StudentProjection {

    private User user;
    private Group group;

}
