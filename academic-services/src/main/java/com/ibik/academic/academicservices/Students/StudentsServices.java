package com.ibik.academic.academicservices.Students;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StudentsServices {
    
    @Autowired
    private StudentsRepo studentsRepo;

    public Students save(Students students){
        return studentsRepo.save(students); //insert & update Query
    }

    public Iterable<Students> findAll(){
        return studentsRepo.findAll(); //select * from programs
    }

    public Students findOne(int id){
        return studentsRepo.findById(id).get();
        //select * from programs where id =1
    }

    public void removeOne(int id){
        studentsRepo.deleteById(id);
    }
    
}
