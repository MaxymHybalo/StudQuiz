package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QCase {
    private String name;

    public QCase(String name) {
        this.name = name;
    }

    public QCase() {
    }
}
