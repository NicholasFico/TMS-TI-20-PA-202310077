package com.ibik.academic.academicservices.Students;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.academic.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    
    @Autowired
    private StudentsServices studentsServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Students>> postStudents(@Valid @RequestBody Students students, Errors errors) {
        
        ResponseData<Students> responseData = new ResponseData<>();
        
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Students>value = new ArrayList<>();
        value.add(studentsServices.save(students));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Students>> fetchStudent() {
        ResponseData<Students> responseData = new ResponseData<>();
        try {
            Iterable<Students> values = studentsServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Students>> fetchStudentById(@PathVariable("id") int id) {
        ResponseData<Students> responseData = new ResponseData<>();

        try {
            Students values = studentsServices.findOne(id);
            List<Students> result = new ArrayList<>();
            result.add(values);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }


    @PutMapping
    public ResponseEntity<ResponseData<Students>> updateStudent(@Valid @RequestBody Students students, Errors errors) {
        ResponseData<Students> responseData = new ResponseData<>();

        if (students.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Students> value = new ArrayList<>();
            value.add(studentsServices.save(students));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);

        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Students>> deleteStudentsById(@PathVariable("id") int id) {
    ResponseData<Students> responseData = new ResponseData<>();

    try {
      studentsServices.removeOne(id);
      responseData.setResult(true);
      responseData.getMessage().add("Successfully Remove");

      return ResponseEntity.ok(responseData);

    } catch (Exception ex) {
      responseData.setResult(false);
      responseData.getMessage().add(ex.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

    }
  }
}
