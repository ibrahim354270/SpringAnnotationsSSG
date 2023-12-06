package com.tpe.service;

import com.tpe.domain.Teacher;
import com.tpe.dto.Teacherdto;
import com.tpe.exception.AlreadyVariableException;
import com.tpe.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveTeacher(Teacherdto teacherdto){

        Teacher teacher=new Teacher();
        Boolean isAlreadyEmail=teacherRepository.existsByEmail(teacherdto.getEmail());
        Boolean isAlreadyPhone=teacherRepository.existsByPhone(teacherdto.getPhone());
        if (isAlreadyEmail){
            throw new AlreadyVariableException("Teachers already exist by : "+teacherdto.getEmail());
        } else if (isAlreadyPhone) {
            throw new AlreadyVariableException("Teachers already exist by : "+teacherdto.getPhone());
        }
        teacher.setName(teacherdto.getName());
        teacher.setSurname(teacherdto.getSurname());
        teacher.setPhone(teacherdto.getPhone());
        teacher.setEmail(teacherdto.getEmail());
        teacher.setBrans(teacherdto.getBrans());
        teacherRepository.save(teacher);

    }

    public Page<Teacher> getAllTeachersPaging(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }
}
