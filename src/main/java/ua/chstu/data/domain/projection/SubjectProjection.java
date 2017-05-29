package ua.chstu.data.domain.projection;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.chstu.data.domain.Subject;

@Data
public class SubjectProjection {

    private Subject data;

    private Params params;

    public SubjectProjection() {
    }
}

