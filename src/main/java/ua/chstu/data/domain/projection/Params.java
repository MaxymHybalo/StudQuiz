package ua.chstu.data.domain.projection;

import lombok.*;

@Getter
@Setter
@ToString
public class Params {

    private String category;

    private String name;

    private String categoryName;

    private String questionCase;

    public Params(String category, String name, String questionCase) {
        this.category = category;
        this.name = name;
        this.questionCase = questionCase;
    }

    public Params() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Params params = (Params) o;

        if (category != null ? !category.equals(params.category) : params.category != null) return false;
        if (name != null ? !name.equals(params.name) : params.name != null) return false;
        if (categoryName != null ? !categoryName.equals(params.categoryName) : params.categoryName != null)
            return false;
        return questionCase != null ? questionCase.equals(params.questionCase) : params.questionCase == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (questionCase != null ? questionCase.hashCode() : 0);
        return result;
    }
}
