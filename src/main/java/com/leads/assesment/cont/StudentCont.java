package com.leads.assesment.cont;

import com.leads.assesment.entity.Student;
import com.leads.assesment.exceptions.EntityNotFound;
import com.leads.assesment.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentCont {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/get-student-list")
    public List<Student> getStudentList() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty()){
            throw new EntityNotFound("No Student in database.");
        }
        return studentRepo.findAll();
    }

    @GetMapping("/get-student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (!student.isPresent()) {
            throw new EntityNotFound("id = " + id);
        }
        return student;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saveStudent = studentRepo.save(student);

        URI url = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveStudent.getId())
                .toUri();

        return ResponseEntity.created(url).build();
    }

//    @PatchMapping("/save")
//    public void patchStudent(@RequestBody Student student){
//        Student toBePatchedManager = objectMapper.convertValue(student, Student.class);
//        studentRepo.save(toBePatchedManager);
////        managerService.patch(toBePatchedManager);
//    }
}
