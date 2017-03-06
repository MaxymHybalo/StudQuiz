package ua.chstu.data.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BaseDocument {
    @Id
    private String id;
}
