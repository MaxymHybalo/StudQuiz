package ua.chstu.data.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@ToString
public class QCase {

    private String name;

    private Set<Question> questions;

    public QCase(String name) {
        this.name = name;
    }

    public QCase() {
    }
}
