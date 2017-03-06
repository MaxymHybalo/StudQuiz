package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "questions")
@Getter
@Setter
public class Question extends BaseDocument{

    private String condition; // How to be with special data for it(images e.g.)

    private String type;

    private Map<String,Boolean> options;

    public Question() {
    }

    public Question(String condition, String type, Map<String,Boolean> options) {

        this.condition = condition;
        this.type = type;
        this.options = options;

    }
}
