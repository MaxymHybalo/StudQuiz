package ua.chstu.data.domain.projection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Params {

    private String category;

    private String name;

    private String categoryName;

    private String questionCase;

    public Params(String category, String name, String questionCase) {
        this.category = category;
        this.name = name;
        this.questionCase = questionCase;
    }

    public Params() {
    }
}
