package ua.chstu.data.domain.study;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.chstu.data.domain.BaseDocument;
import ua.chstu.data.domain.User;

import java.util.List;

@Data
@ToString
@Document(collection = "groups")
public class Group extends BaseDocument{

    private String name;
    private List<String> studentIds;
    private List<User> students;

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }
}
