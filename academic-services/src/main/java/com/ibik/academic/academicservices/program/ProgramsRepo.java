package com.ibik.academic.academicservices.program;

import org.springframework.data.repository.CrudRepository;

public interface ProgramsRepo extends CrudRepository<Programs, Integer>{
    //funtion query JPAQL atau Mysql QUERY
}
