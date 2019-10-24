package com.petadev.backend;

import com.petadev.backend.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// Rest Controller is needed in order for spring to pick up this class.
@RestController
public class StudentController {
    // We don't use System.out.println, we use this LOG variable
    // example: LOG.debug("Hello World") will log Hello World to the console.
    // See further usage in code.
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    // In this example we don't use a database, we store data in memory.
    // We have a map, for which each unique UUID stores a unique student
    // example UUID: 83529923-7874-47d8-abf7-9b804f75078a
    final private Map<UUID, Student> studentMap = new HashMap<>();

    // Constructor for the rest controller. Here we initialize the data that will be stored in memory by default
    // we add two Students, with two random ids.
    public StudentController() {
        this.studentMap.put(
                UUID.randomUUID(),
                new Student("John", "Doe", new Date())
        );

        this.studentMap.put(
                UUID.randomUUID(),
                new Student("Marry", "Doe", new Date())
        );

        // Here we iterate through each created UUID, and log it to the console
        // it first be converted to string, then it can be logged. every object has a .toString() method.
        // float, boolean, int, double, void are not objects, they are base-types. These don't have a .toString() method.
        for (final UUID uuid : this.studentMap.keySet()) {
            LOG.debug(uuid.toString());
        }
    }

    // Here we handle a GET request on the /students endpoint
    // We find all our stored students, and we return them
    @GetMapping("/students")
    List<Student> getAllStudents() {
        LOG.info("Returning all students...");
        return List.copyOf(this.studentMap.values());
    }

    // Here we handle a POST request on the /students endpoint
    // We receive a student which we should insert in to the memory.
    // We create a random uuid and put it into our map.
    @PostMapping("/students")
    Student createStudent(final @RequestBody Student student) {
        LOG.info("Creating student with name " + student.getLastName());
        this.studentMap.put(
                UUID.randomUUID(),
                student
        );

        return student;
    }

    // Here we handle a GET request on the /students/<someId> endpoint
    // where <someId> is a UUID. We try to find the user with set id and return it.
    // @RequestBody means that it will be stored in the Request Body, so not in the url
    // @PathVariable will mean it is stored in the URI.
    // ID is a path variable
    // example /students/83529923-7874-47d8-abf7-9b804f75078a is a valid get request
    @GetMapping("/students/{id}")
    Student getStudentById(final @PathVariable UUID id) {
        LOG.info("Returning student with id " + id);
        // if there is no user with id, then return null.
        return this.studentMap.getOrDefault(id, null);
    }


    // Here we handle a PUT request on the /students/<someId> endpoint
    // where <someId> is a UUID. We try to find the user with set id, and replace it.
    // note @RequestBody and @PathVariable
    @PutMapping("/students/{id}")
    Student replaceStudentById(final @RequestBody Student student, final @PathVariable UUID id) {
        LOG.info("Replacing student with id " + id);
        this.studentMap.replace(id, student);
        return this.studentMap.get(id);
    }

    // Here we handle a DELETE request on the /students/<someId> endpoint
    // where <someId> is a UUID. We try to find the user with set id, and delete it.
    // note @PathVariable
    @DeleteMapping("/students/{id}")
    void deleteStudentById(final @PathVariable UUID id) {
        LOG.info("Deleting student with id " + id);
        this.studentMap.remove(id);
    }
}
