package ua.chstu.data.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;


import java.util.List;

@Data
@ToString
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
