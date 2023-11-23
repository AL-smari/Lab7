package com.example.lab7lms.Controller;

import com.example.lab7lms.Model.Subject;
import com.example.lab7lms.Services.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/get")
    public ResponseEntity getSubject(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
    }

    @PostMapping("/add")
    public ResponseEntity addSubject(@Valid @RequestBody Subject subject, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        subjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.OK).body("Subject added");



    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSubject(@PathVariable String id,@Valid @RequestBody Subject subject ,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }else if (subjectService.updateSubject(id,subject)){
            return ResponseEntity.status(HttpStatus.OK).body("Subject updated");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSubject(@PathVariable String id){

        if(subjectService.deleteSubject(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Subject deleted");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");

    }

    @PutMapping("/changeNumber/{id}/{number}")
    public ResponseEntity changeNumberOfStudent(@PathVariable String id , @PathVariable int number){

        if(number>=25){
            if (subjectService.changeNumberOfStudent(id,number)){
                return ResponseEntity.status(HttpStatus.OK).body("number of Students updated");
            }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("the number of Students must be more than 25");



    }
}
