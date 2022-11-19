package com.ibik.academic.academicservices.Program_Study;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.academic.academicservices.program.Programs;

@Entity
@Table(name="program_study")
public class Program_Study implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50)
    @NotEmpty(message = "Name is required")
    private String name;

    private String description;

    @Column(length = 10, unique = true)
    @NotEmpty(message = "Code is required")
    private String code;

    //@NotEmpty(message = "Program id is required")
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs programs;

    //@NotEmpty(message = "Faculty is required")
    @OneToMany
    @JoinColumn(name="faculty_id")
    private Set<Program_Study> Departments;
    //private int faculty_id;

    // @OneToMany
    // @JoinColumn(name="department_id")
    // private Set<ProgramStudy> departments;
    //private int department_id;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

    public Program_Study() {
    }

    public Program_Study(int id, @NotEmpty(message = "Name is required") String name, String description,
            @NotEmpty(message = "Code is required") String code, int program_id, int faculty_id, int department_id,
            boolean is_active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public Set<Program_Study> getDepartments() {
        return Departments;
    }

    public void setDepartments(Set<Program_Study> departments) {
        Departments = departments;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

}