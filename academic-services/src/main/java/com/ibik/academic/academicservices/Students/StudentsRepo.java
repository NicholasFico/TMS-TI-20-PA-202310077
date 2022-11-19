package com.ibik.academic.academicservices.Students;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentsRepo extends CrudRepository<Students, Integer>{
    @Query("SELECT a FROM Students a WHERE a.firstname LIKE %:name% OR a.middlename LIKE %:name% OR a.lastname LIKE %:name% OR a.npm like %:name%")
  public Iterable<Students> findStudentByName(@Param("name") String name);
}
