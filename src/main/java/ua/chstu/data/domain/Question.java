package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
public class Question{

    private String condition;

    private Map<String,Boolean> options;

    public Question() {
    }

    public Question(String condition, String type, Map<String,Boolean> options) {

        this.condition = condition;
        this.options = options;

    }
}
