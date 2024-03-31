/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.Student;

import java.util.List;
import za.ac.tut.entity.Module.Module;

/**
 *
 * @author taarb
 */
public class Student {
    private Integer id;
    private String name;
    private List<Module> modules;

    public Student(Integer id, String name, List<Module> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + modules;
    }
    
    
            
}
