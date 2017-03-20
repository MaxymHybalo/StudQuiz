package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.domain.projection.SubjectProjection;
import ua.chstu.data.services.impl.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/")
    public Subject getByIdAndName(
                        @RequestParam(value = "category") String id,
                        @RequestParam(value = "name") String name){

        System.out.println("Id: " + id + ", Name: " + name);
        return service.findByIdAndName(id, name);
    }

    @PostMapping("/update")
    public Category update(@RequestBody SubjectProjection subject){
        return service.update(subject);
    }
}
