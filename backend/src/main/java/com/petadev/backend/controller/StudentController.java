package com.petadev.backend.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
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

// Rest Controller is needed in order for spring to pick up this class.
@RestController
public class StudentController {
    // We don't use System.out.println, we use this LOG variable
    // example: LOG.debug("Hello World") will log Hello World to the console.
    // See further usage in code.
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    // We don't need a map anymore, since we are going to store entries in the database
    // Dao = DataAccessObject
    // what's between the <> tags is called generics.
    private Dao<Student, Integer> studentDao = DaoStore.getStudentDao();

    // Constructor for the rest controller. Here we initialize the data that will be stored in memory by default
    // we add two Students, with two random ids.
    public StudentController() {

    }

    // Here we handle a GET request on the /students endpoint
    // We find all our stored students, and we return them
    @GetMapping("/students")
    List<Student> getAllStudents() throws SQLException {
        LOG.info("Returning all students...");
        return this.studentDao.queryForAll();
    }

    // Here we handle a POST request on the /students endpoint
    // We receive a student which we should insert in to the database.
    @PostMapping("/students")
    int createStudent(final @RequestBody Student student) throws SQLException {
        LOG.info("Creating student with name " + student.getLastName());
        return this.studentDao.create(student);
    }

    // Here we handle a GET request on the /students/<someId> endpoint
    // where <someId> is an Integer. We try to find the user with set id and return it.
    // @RequestBody means that it will be stored in the Request Body, so not in the url
    // @PathVariable will mean it is stored in the URI.
    // ID is a path variable
    // example /students/1 is a valid get request
    @GetMapping("/students/{id}")
    Student getStudentById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Returning student with id " + id);
        return this.studentDao.queryForId(id);
    }

    // Here we handle a PUT request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and replace it.
    // note @RequestBody and @PathVariable
    @PutMapping("/students/{id}")
    int replaceStudentById(final @RequestBody Student student, final @PathVariable Integer id) throws SQLException {
        UpdateBuilder<Student, Integer> updateBuilder = this.studentDao.updateBuilder();
        // we want to update entries where studentId == id
        updateBuilder.where().eq("studentId", id);
        // we update each column with the information received from the client
        updateBuilder.updateColumnValue("firstName", student.getFirstName());
        updateBuilder.updateColumnValue("lastName", student.getLastName());
        updateBuilder.updateColumnValue("birthDate", student.getBirthDate());
        updateBuilder.updateColumnValue("userName", student.getUserName());
        return updateBuilder.update();
    }

    // Here we handle a DELETE request on the /students/<someId> endpoint
    // where <someId> is of type Integer. We try to find the user with set id, and delete it.
    // note @PathVariable
    @DeleteMapping("/students/{id}")
    int deleteStudentById(final @PathVariable Integer id) throws SQLException {
        LOG.info("Deleting student with id " + id);
        DeleteBuilder<Student, Integer> deleteBuilder = this.studentDao.deleteBuilder();
        // we want to delete each entry where studentId == id
        deleteBuilder.where().eq("studentId", id);
        // we return the number of deleted users
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
