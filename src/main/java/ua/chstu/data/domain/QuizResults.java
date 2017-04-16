package ua.chstu.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Contain data about solved test result
 */
@Data
@Document(collection = "results")
public class QuizResults {

    @Id
    private String id;
    private String userId;
    private Short mark;
    private LocalDate data;

    public QuizResults() {
    }
}
