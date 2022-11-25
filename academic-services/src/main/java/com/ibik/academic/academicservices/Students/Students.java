package com.ibik.academic.academicservices.Students;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.academic.academicservices.Courses.Courses;
import com.ibik.academic.academicservices.Program_Study.Program_Study;
import com.ibik.academic.academicservices.program.Programs;

@Entity
@Table(name = "Students")
public class Students implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 15)
    @NotEmpty(message = "NPM is required")
    private String npm;

    @Column(length = 10)
    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @Column(length = 10)
    private String middlename;

    @NotEmpty(message = "Lastname is required")
    private String lastname;

    @Column
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Birthdate is required")
    private String birthdate;

    //@Min(value = 1, message = "Program is required")
    // private int program_id;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs programs;

    // @Min(value = 1, message = "Department is required")
    // private int department_id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Program_Study programStudy;

    @ManyToMany
    @JoinTable(
        name = "student_rel_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private Set<Courses> courses;

    public Students() {
    }

    public Students(int id, String npm, String firstname, String middlename, String lastname, Programs programs,
        Program_Study programStudy, Set<Courses> courses, String email, String birthdate) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.programs = programs;
        this.programStudy = programStudy;
        this.courses = courses;
        this.email = email;
        this.birthdate = birthdate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public Program_Study getProgramStudy() {
        return programStudy;
    }

    public void setProgramStudy(Program_Study programStudy) {
        this.programStudy = programStudy;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getBirthdate() {
      return birthdate;
    }

    public void setBirthdate(String birthdate) {
      this.birthdate = birthdate;
    }

    
}