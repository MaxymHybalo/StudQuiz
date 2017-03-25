package ua.chstu.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.Category;
import ua.chstu.data.services.impl.CategoryService;

import java.util.List;


@RestController()
@RequestMapping("/category")
public class CategoryController {

    private static final Logger log = Logger.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public String test(){
        return "Tested!";
    }

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        log.info("New category: " + category.getName());
        service.save(category);
        return category;
    }

    @GetMapping("/names")
    public List<Category> getNames(){
        return service.findCategoryNames();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category){
        return service.update(category);
    }

}