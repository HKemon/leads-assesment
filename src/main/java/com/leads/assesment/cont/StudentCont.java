package com.leads.assesment.cont;

import com.leads.assesment.entity.Student;
import com.leads.assesment.exceptions.ControllerExceptionHandler;
import com.leads.assesment.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentCont {

    @Autowired
    private ControllerExceptionHandler controllerExceptionHandler;

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/get-student-list")
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }

    @GetMapping("/get-student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") long id) {
//        if (!studentRepo.findById(id).isPresent()) {
//            controllerExceptionHandler.entityNotFoundException(new ObjectNotFoundException("No Object Found"));
//        } else
//            System.out.println(studentRepo.findById(id));
        return studentRepo.findById(id);
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentRepo.save(student);
    }

//    @PatchMapping("/save")
//    public void patchStudent(@RequestBody Student student){
//        Student toBePatchedManager = objectMapper.convertValue(student, Student.class);
//        studentRepo.save(toBePatchedManager);
////        managerService.patch(toBePatchedManager);
//    }
}
