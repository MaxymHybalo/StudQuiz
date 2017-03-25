package ua.chstu.data.domain.projection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Params {

    private String category;

    private String name;

    private String categoryName;

    private String questionCase;

    public Params() {
    }
}
