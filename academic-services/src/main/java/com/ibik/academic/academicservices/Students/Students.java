package com.ibik.academic.academicservices.Students;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.academic.academicservices.Courses.Courses;
import com.ibik.academic.academicservices.Program_Study.Program_Study;
import com.ibik.academic.academicservices.program.Programs;

@Entity
@Table(name="students")
public class Students implements Serializable {

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

  @Column(length = 10)
  @NotEmpty(message = "Lastname is required")
  private String lastname;

  @ManyToMany
    @JoinTable(
        name = "student_rel_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
  private Set<Courses> courses;

  @ManyToOne
  @JoinColumn(name = "program_id")
  private Programs program_id;

  @OneToMany
  @JoinColumn(name = "program_study_id")
  private Set<Program_Study> program_study;

  // @Min(value = 1, message = "Program is required")
  // private int program_id;

  // @Min(value = 1, message = "Departement is required")
  // private int departement_id;

  public Students() {
  }

  public Students(int id, @NotEmpty(message = "NPM is required") String npm,
            @NotEmpty(message = "Firstname is required") String firstname, String middlename,
            @NotEmpty(message = "Lastname is required") String lastname,
            @NotEmpty(message = "Program is required") int program_id,
            @NotEmpty(message = "Department is required") int department_id) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
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

  public Set<Courses> getCourses() {
    return courses;
  }

  public void setCourses(Set<Courses> courses) {
    this.courses = courses;
  }

  public Programs getProgram_id() {
    return program_id;
  }

  public void setProgram_id(Programs program_id) {
    this.program_id = program_id;
  }

  public Set<Program_Study> getProgram_study() {
    return program_study;
  }

  public void setProgram_study(Set<Program_Study> program_study) {
    this.program_study = program_study;
  }

  
  
}