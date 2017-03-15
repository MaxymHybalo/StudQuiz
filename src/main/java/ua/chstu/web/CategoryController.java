package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.Category;
import ua.chstu.data.services.impl.CategoryService;


@RestController()
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public String test(){
        return "Tested!";
    }
    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        System.out.println(category.getName());
        service.save(category);
        return category;
    }
}