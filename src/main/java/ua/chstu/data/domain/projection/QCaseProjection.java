package ua.chstu.data.domain.projection;

import lombok.Getter;
import lombok.Setter;
import ua.chstu.data.domain.Question;

@Getter
@Setter
public class QCaseProjection {

    private Question data;

    private Params params;

    public QCaseProjection() {
    }
}

