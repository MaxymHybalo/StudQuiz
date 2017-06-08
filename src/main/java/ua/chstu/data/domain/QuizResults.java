package ua.chstu.data.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.chstu.data.domain.projection.Params;

import java.time.LocalDate;

/**
 * Contain data about solved test result
 */
@Data
@Document(collection = "results")
@EqualsAndHashCode
public class QuizResults {

    @Id
    private String id;
    private String userId;
    private Short mark;
    private String gradation;
    private LocalDate data;
    private String dateCaption;
    private Params params;

    public QuizResults() {
    }
}
