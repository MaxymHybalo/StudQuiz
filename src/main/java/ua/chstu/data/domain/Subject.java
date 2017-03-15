package ua.chstu.data.domain;


import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class Subject {

    private String name;

    private List<QCase> questionCases;

    public Subject(String name, List<QCase> questionCases) {
        this.name = name;
        this.questionCases = questionCases;
    }

    public Subject() {
    }
}
