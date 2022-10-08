package com.ibik.academic.academicservices.program;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ProgramsServices {
    
    @Autowired
    private ProgramsRepo programsRepo;

    public Programs save(Programs programs){
        return programsRepo.save(programs); //insert & update Query
    }

    public Iterable<Programs> findAll(){
        return programsRepo.findAll(); //select * from programs
    }

    public Programs findOne(int id){
        return programsRepo.findById(id).get();
        //select * from programs where id =1
    }

    public void removeOne(int id){
        programsRepo.deleteById(id);
    }
    
}


