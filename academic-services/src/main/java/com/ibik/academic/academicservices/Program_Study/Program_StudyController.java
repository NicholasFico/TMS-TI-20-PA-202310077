package com.ibik.academic.academicservices.Program_Study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/program_Study")
public class Program_StudyController {
    
    @Autowired
    private Program_StudyServices program_StudyServices;

    @PostMapping()
    public Program_Study postPrograms(@RequestBody Program_Study program_Study) {
        return program_StudyServices.save(program_Study);
    }

    @GetMapping
    public Iterable<Program_Study> fetchProgram_Study(){
        return program_StudyServices.findAll();
    }

    @GetMapping("/{id}")
    public Program_Study fetchProgram_StudyById(@PathVariable("id") int id){
        return program_StudyServices.findOne(id);
    }

    @PutMapping
    public Program_Study updateProgram_Study(@RequestBody Program_Study program_Study){
        return program_StudyServices.save(program_Study);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram_StudyById(@PathVariable("id") int id){
        program_StudyServices.removeOne(id);
    }
}
