package ua.chstu.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.chstu.data.domain.Category;

public interface CategoriesRepository extends MongoRepository<Category, String> {

}
