package ru.hogwarts.school.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.dto.StudentDtoOut;
import ru.hogwarts.school.service.AvatarService;
import ru.hogwarts.school.service.StudentService;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final AvatarService avatarService;

    @PostMapping
    public StudentDtoOut create(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.create(studentDtoIn);
    }

    @GetMapping("/{id}")
    public StudentDtoOut get(@PathVariable long id) {
        return studentService.get(id);
    }

    @PutMapping("/{id}")
    public StudentDtoOut update(@PathVariable long id,
                                @RequestBody StudentDtoIn studentDtoIn) {
        return studentService.update(id, studentDtoIn);
    }

    @DeleteMapping("/{id}")
    public StudentDtoOut delete(@PathVariable long id) {
        return studentService.delete(id);
    }

    @GetMapping("/{age}/students")
    public Collection<StudentDtoOut> findAll(@PathVariable(required = false) int age) {
        return studentService.findAll(age);
    }

    @GetMapping("/filter")
    public Collection<StudentDtoOut> findStudentsByAgeBetween(@RequestParam int from,
                                                              @RequestParam int to) {
        return studentService.findStudentsByAgeBetween(from, to);
    }
}