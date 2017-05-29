package ua.chstu.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseDocument {
    @Id
    private String id;
}
