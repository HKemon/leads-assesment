package com.leads.assesment.repo;

import com.leads.assesment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Implementation of JpaRepository of Student Class
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
