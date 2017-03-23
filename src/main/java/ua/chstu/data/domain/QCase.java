package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class QCase {

    private String name;

    private Set<Question> questions;

    public QCase(String name) {
        this.name = name;
    }

    public QCase() {
    }
}
