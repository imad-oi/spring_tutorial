package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            deleteAllStudents(studentDao);
        };
    }

    private void deleteAllStudents(StudentDao studentDao) {
        int numRowsDeleted = studentDao.deleteAll();
        System.out.println("Deleted row count : " +numRowsDeleted);
    }

    private void deleteStudent(StudentDao studentDao) {
        long id = 2;
        studentDao.delete(id);
    }

    private void updateStudent(StudentDao studentDao) {
        long id = 1;
        Student foundedStudent = studentDao.findById(id);
        if (foundedStudent == null) {
            System.out.println("Student not found");
        } else {
            foundedStudent.setEmail("jamal@gmail.com");
            studentDao.update(foundedStudent);
            System.out.println(foundedStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDao studentDao) {
        List<Student> students = studentDao.findByLastName("oissafe");
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    private void readStudents(StudentDao studentDao) {
        List<Student> students = studentDao.findAll();
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDao studentDao) {
        // create a student object
        System.out.println("creating new student ...");
        Student student = new Student("ahmed", "el aadi", "ahmed@gmail.com");

        // save the studenti
        System.out.println("saving the student ...");
        studentDao.save(student);

        // display id of the saved student
        System.out.println("saved student " + student.getId());

        // retrieve student based on id
        Student myStudent = studentDao.findById(student.getId());

        // display student
        System.out.println("Founded Student :" + myStudent);
    }

    private void createStudent(StudentDao studentDao) {
        // create the student object
        Student newStudent = new Student("imad", "oissafe", "imad@gmail.com");

        // save the student object
        studentDao.save(newStudent);

        // display id of the saved student
        System.out.println(newStudent.getId());
        System.out.println("student saved succefelly");
    }

}
