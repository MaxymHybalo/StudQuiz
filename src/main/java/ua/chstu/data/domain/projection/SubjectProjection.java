package ua.chstu.data.domain.projection;


import lombok.Getter;
import lombok.Setter;
import ua.chstu.data.domain.Subject;

@Getter
@Setter
public class SubjectProjection {

    private Subject data;

    private Params params;

    public SubjectProjection() {
    }
}

