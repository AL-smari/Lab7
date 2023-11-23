package com.example.lab7lms.Controller;

import com.example.lab7lms.Model.Teacher;
import com.example.lab7lms.Services.SubjectService;
import com.example.lab7lms.Services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final SubjectService subjectService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){

        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id,@Valid @RequestBody Teacher teacher , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }else if(teacherService.updateTeacher(id, teacher)){
            return ResponseEntity.status(HttpStatus.OK).body("Teacher updated");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){

        if(teacherService.deleteTeacher(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");

    }
    @PutMapping("/addSubject/{teacherId}/{subjectId}")
    public ResponseEntity addSubjectToTeacher(@PathVariable String teacherId,@PathVariable String subjectId ){
           if(teacherService.addSubjectToTeacher(subjectService.getSubjects(),teacherId,subjectId )){
               return ResponseEntity.status(HttpStatus.OK).body("subject added to teacher");
           }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }


    @GetMapping("/getBySubject/{id}")
    public ResponseEntity getBySubject (@PathVariable String id ){

        if(teacherService.getBySubject(id)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
        }else return ResponseEntity.status(HttpStatus.OK).body(teacherService.getBySubject(id));

    }
    @PutMapping("/changeBook/{id}/{book}")
    public ResponseEntity changeBook(@PathVariable String id,@PathVariable String book){

        if(teacherService.changeBook(id,book)){
            return ResponseEntity.status(HttpStatus.OK).body("book changed");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found or the teacher dont teach subject to edit the book ");

    }
}
