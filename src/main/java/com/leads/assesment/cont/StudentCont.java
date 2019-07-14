package com.leads.assesment.cont;

import com.leads.assesment.entity.Student;
import com.leads.assesment.exceptions.EntityNotFound;
import com.leads.assesment.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/*
 * Stores all rest api of Student table
 */
@RestController
public class StudentCont {
    @Autowired
    private StudentRepo studentRepo;

    /*
     * Fetch student records from student table
     * @return List<Student> - All records from student table
     * @throws EntityNotFound - if no student record found in database
     */
    @GetMapping("/get-student-list")
    public List<Student> getStudentList() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty()) {
            throw new EntityNotFound("No Student in database.");
        }
        return studentRepo.findAll();
    }

    /*
     * Fetch student of a specific id from student table
     * @return Optional<Student> - Record the a student of specific id from student table
     * @throws EntityNotFound - if no student record found in database
     */
    @GetMapping("/get-student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (!student.isPresent()) {
            throw new EntityNotFound("id = " + id);
        }
        return student;
    }

    /*
     * Save the student in database
     * @return ResponseEntity<Student> - Return uri to find the student record from database
     * @throws EntityNotFound - if no student record found in database
     */
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

    /*
     * Update full the student record in database
     * @return ResponseEntity<Student> - Return uri to find the student record from database
     *                                  else return Bad Request
     */
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

            return ResponseEntity.ok("Resource saved and uri is " + url);
        }else return ResponseEntity.noContent().build();
    }

    /*
     * Update partial the student record in database
     * @return ResponseEntity<Student> - Return uri to find the student record from database
     *                                  else return Bad Request
     */
    @PatchMapping("/update-student/{id}")
    public ResponseEntity<String> patchStudent(@RequestBody Student newStudent,
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
