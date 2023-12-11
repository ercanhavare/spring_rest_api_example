package net.havare.springboot.controller;

import net.havare.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

//    @GetMapping("/student")
//    public Student getStudent() {
//        Student student = new Student(1, "Oktay", "Havare");
//
//        return student;
//    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Oktay", "Havare");

        //1- return new ResponseEntity<>(student, HttpStatus.OK);
        //2- return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom header", "oktay").body(student);
    }

//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        List<Student> students = new ArrayList<>();
//
//        students.add(new Student(1, "Oktay", "Havare"));
//        students.add(new Student(2, "Oktay2", "Havare"));
//        students.add(new Student(3, "Oktay3", "Havare"));
//        students.add(new Student(4, "Oktay4", "Havare"));
//
//        return students;
//    }


 //   @GetMapping("/students")
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Oktay", "Havare"));
        students.add(new Student(2, "Oktay2", "Havare"));
        students.add(new Student(3, "Oktay3", "Havare"));
        students.add(new Student(4, "Oktay4", "Havare"));

        return ResponseEntity.ok(students);
    }


    // http://localhost:8080/students/1

//Ex:    GetMapping("/students/{id}")
//    public Student studentPathVariable(@PathVariable int id) {
//    }

//Ex:    @GetMapping("/students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId) {
//        return new Student(studentId, "Oktay", "Havare");
//    }

//    @GetMapping("/students/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
//        return new Student(studentId, firstName, lastName);
//    }

    //@GetMapping("/students/{id}/{first-name}/{last-name}")
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);

        return ResponseEntity.ok(student);
    }

//    // http://localhost:8080/students/query?id=1&firstName=Oktay&lastName=Havare  --> request query param
//    @GetMapping("/students/query")
//    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
//        return new Student(id, firstName, lastName);
//    }

    // http://localhost:8080/students/query?id=1&firstName=Oktay&lastName=Havare  --> request query param
    //@GetMapping("/students/query")
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);

        return ResponseEntity.ok(student);
    }

    // Spring Boot post request
//
//    @PostMapping("/students/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student) {
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//
//        return student;
//    }


    //@PostMapping("/students/create")
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // spring boot put request
//    @PutMapping("/students/{id}/update")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    //@PutMapping("/students/{id}/update")
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    // spring boot delete request
//    @DeleteMapping("/students/{id}/delete")
//    public String deleteStudent(@PathVariable("id") int studentId) {
//        System.out.println(studentId);
//        return "Student deleted successfully!";
//    }

    //@DeleteMapping("/students/{id}/delete")
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
