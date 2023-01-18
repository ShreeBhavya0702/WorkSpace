package com.demoFiles.WorkSpace;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TeachDetails")
public class TeacherController {


    List<Teacher> teachers = new ArrayList<Teacher>();

    @GetMapping(value = "/teacher")
    public String returnValue() {
        return "Teacher Details";
    }

    @GetMapping(value = "/teacherDetails")
    public Teacher getTeacherDetails(@RequestParam int id) throws Exception {
        Teacher t1 = new Teacher(101, "Bhavya", "MCA");
        Teacher t2 = new Teacher(102, "Harshini", "BE");
        Teacher t3 = new Teacher(103, "Asha", "MBA");
        for (Teacher teacher : teachers) {
            if (id == teacher.id) {

                return teacher;
            }
        }
        return null;
    }

    @PostMapping(value = "/add")
    public String addNewTeacher(@RequestBody Teacher s1) {
        Teacher t = new Teacher(s1.id, s1.name, s1.qualification);
        teachers.add(t);
        return "Teacher added Successfully";
    }

    @PutMapping(value = "/update")
    public String updateTeacherDetails(@RequestBody Teacher t1) throws Exception {
        for (Teacher teacher : teachers) {
            if (teacher.id == t1.id) {
                BeanUtils.copyProperties(t1, teacher);
                return "Teacher details updated";
            }
        }
        return null;
    }

    @GetMapping(value = "/teacherDetails/{name}")
    public Teacher getTeacherDetails(@PathVariable String name) throws Exception {
        Teacher t1 = new Teacher(101, "Bhavya", "MCA");
        Teacher t2 = new Teacher(102, "Harshini", "BE");
        Teacher t3 = new Teacher(103, "Asha", "MBA");
        for (Teacher teacher : teachers) {
            if (name.equalsIgnoreCase(teacher.name)) {

                return teacher;
            }
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTeacherById(@PathVariable int id) throws Exception {
        Teacher s4 = new Teacher(104, "Deeksha", "BE");
        Teacher s5 = new Teacher(105, "Ramya", "B'Com");
        for (Teacher teacher : teachers) {
            if (id == teacher.id) {
                teachers.remove(teacher);
                return teacher.name + "deleted";
            }
        }
        return null;
    }

    @GetMapping(value = "/search/all")
    public List<Teacher> getAllStudents() {

        return teachers;
    }
}