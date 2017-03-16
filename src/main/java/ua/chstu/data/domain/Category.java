package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "categories")
public class Category {
    @Id
    private String id;

    private String name;

    private List<Subject> subjects;

    public Category(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Category() {
    }
}
