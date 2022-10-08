package com.ibik.academic.academicservices.Program_Study;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class Program_StudyServices {
    
    @Autowired
    private Program_StudyRepo program_StudyRepo;

    public Program_Study save(Program_Study program_Study){
        return program_StudyRepo.save(program_Study); //insert & update Query
    }

    public Iterable<Program_Study> findAll(){
        return program_StudyRepo.findAll(); //select * from programs
    }

    public Program_Study findOne(int id){
        return program_StudyRepo.findById(id).get();
        //select * from programs where id =1
    }

    public void removeOne(int id){
        program_StudyRepo.deleteById(id);
    }
    
}