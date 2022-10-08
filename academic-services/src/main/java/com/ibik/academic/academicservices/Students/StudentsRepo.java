package com.ibik.academic.academicservices.Students;

import org.springframework.data.repository.CrudRepository;

public interface StudentsRepo extends CrudRepository<Students, Integer>{
    //funtion query JPAQL atau Mysql QUERY
}
