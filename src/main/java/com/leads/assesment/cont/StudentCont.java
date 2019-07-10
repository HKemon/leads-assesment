package com.leads.assesment.cont;

import com.leads.assesment.entity.Student;
import com.leads.assesment.exceptions.EntityNotFound;
import com.leads.assesment.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.validation.Valid;
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
        if (studentList.isEmpty()) {
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
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        Student saveStudent = studentRepo.save(student);

        URI url = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveStudent.getId())
                .toUri();

        return ResponseEntity.created(url).build();
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<String> putStudent(@RequestBody Student student,
                                             @PathVariable("id") long id) {
        Optional<Student> newStudent = getStudent(id);
        if (newStudent.isPresent()) {
            student.setId(newStudent.get().getId());
            Student saveStudent = studentRepo.save(student);

            URI url = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saveStudent.getId())
                    .toUri();

            return ResponseEntity.ok("Resource saved and uri is " + id);
        }
        return null;
    }

    @PatchMapping("/update-student/{id}")
    public ResponseEntity patchStudent(@RequestBody Student newStudent,
                                       @PathVariable("id") Long id) {
        Optional<Student> student = getStudent(id);
        if (student.isPresent()) {
            if (newStudent.getAddress() != null) {
                student.get().setAddress(newStudent.getAddress());
            }
            if (newStudent.getDateOfBirth() != null) {
                student.get().setDateOfBirth(newStudent.getDateOfBirth());
            }
            if (newStudent.getName() != null) {
                student.get().setName(newStudent.getName());
            }
            saveStudent(student.get());
            return ResponseEntity.ok("Resource saved on id " + student.get().getId());
        }
        return ResponseEntity.noContent().build();
    }
}
