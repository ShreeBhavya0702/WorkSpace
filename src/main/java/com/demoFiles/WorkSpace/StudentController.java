package com.demoFiles.WorkSpace;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@RestController
@RequiredArgsConstructor

public class StudentController {
    @Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {
    }

        @GetMapping(value = "/studentDetails")
        public Student getStudentDetails(@RequestParam int id) throws Exception {
            Student s1 = new Student(101, "Bhavya", "shree");
            Student s2 = new Student(102, "Divya", "shree");
            Student s3 = new Student(103, "Ramya", "shree");
            return s1;

        }

        @PostMapping("/students")
        public void postStudent(@RequestBody Student studentDetails) {
            Student student = new Student();
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
           // StudentRepository.save(student);

        }

        @PutMapping("/students/{id}")
        public void putStudent(@PathVariable int id, @RequestBody Student studentDetail) {
            Student student = new Student();
            student.setStudent_id(id);
            student.setFirstName(studentDetail.getFirstName());
            student.setLastName(studentDetail.getLastName());
            //StudentRepository.save(student);
        }

      /* @DeleteMapping("/students/{id}")
        public void deleteStudent(@PathVariable long id) {
           StudentRepository.deleteById(id);
       }*/
}


