package ua.chstu.data.domain.projection;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class QuizResultProjection {

    private Map<Integer,List<Boolean>> data;
    private Params params;
    private String user;

    public QuizResultProjection() {
    }
}
