package com.petadev.backend.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Comment;
import com.petadev.backend.entity.Post;
import com.petadev.backend.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class StudentController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);


    private Dao<Student, Integer> studentDao = DaoStore.getStudentDao();


    public StudentController() {
    }


    @GetMapping("/students")
    List<Student> getAllStudents() throws SQLException {
        LOG.info("Returning all students...");
        return this.studentDao.queryForAll();
    }

    @PostMapping("/students")
    int createStudent(final @RequestBody Student student) throws SQLException {
        LOG.info("Creating student with name " + student.getLastName());
        return this.studentDao.create(student);
    }


    @GetMapping("/students/{id}")
    Student getStudentById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Returning student with id " + id);
        return this.studentDao.queryForId(id);
    }


    @PutMapping("/students/{id}")
    int replaceStudentById(final @RequestBody Student student, final @PathVariable Integer id) throws SQLException {
        UpdateBuilder<Student, Integer> updateBuilder = this.studentDao.updateBuilder();

        updateBuilder.where().eq("studentId", id);

        updateBuilder.updateColumnValue("firstName", student.getFirstName());
        updateBuilder.updateColumnValue("lastName", student.getLastName());
        updateBuilder.updateColumnValue("birthDate", student.getBirthDate());
        updateBuilder.updateColumnValue("userName", student.getUserName());
        return updateBuilder.update();
    }


    @DeleteMapping("/students/{id}")
    int deleteStudentById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Deleting student with id " + id);
        DeleteBuilder<Student, Integer> deleteBuilder = this.studentDao.deleteBuilder();

        deleteBuilder.where().eq("studentId", id);

        return deleteBuilder.delete();
    }

    @GetMapping("/students/{studentId}/comments")
    public List<Comment> getUserComments(@PathVariable String studentId) throws SQLException {
        return DaoStore.getCommentDao().queryForEq("student_id", studentId);
    }

    @GetMapping("/students/{studentId}/posts")
    public List<Post> getUserPosts(@PathVariable String studentId) throws SQLException {
        return DaoStore.getPostDao().queryForEq("student_id", studentId);
    }
}
