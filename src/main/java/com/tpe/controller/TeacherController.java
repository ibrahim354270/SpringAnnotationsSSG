package com.tpe.controller;

import com.tpe.domain.Teacher;
import com.tpe.dto.Teacherdto;
import com.tpe.service.TeacherService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    //http://localhost:8080/teachers/save

    @GetMapping("/greet")
    public String selamSpringBoot(){
        return "Hello Spring Boot";
    }


    @Autowired
    private TeacherService teacherService;
    @PostMapping("/save")
    public ResponseEntity<String>saveTeacher(@Valid @RequestBody Teacherdto teacherdto){
        teacherService.saveTeacher(teacherdto);
        return new ResponseEntity<>("Teacher saved succesfully", HttpStatus.CREATED);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Teacher>>getAllTeachersByPage(@RequestParam("page")int page,
                                                             @RequestParam("size")int size,
                                                             @RequestParam("sort")String prop,
                                                             @RequestParam("direction")Sort.Direction direction){
        Pageable pageable= PageRequest.of(page,size,Sort.by(direction,prop));
        Page<Teacher>teacherByPage=teacherService.getAllTeachersPaging(pageable);
        return new ResponseEntity<>(teacherByPage,HttpStatus.OK);

    }

}
