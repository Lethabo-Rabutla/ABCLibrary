/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl.StudentManagerInterface;

import java.sql.SQLException;
import java.util.List;
import za.ac.tut.entity.Student.Student;

/**
 *
 * @author taarb
 */
public interface StudentManagerInterface {
    boolean add(Student student, String sql1, String sql2)throws SQLException;
    boolean delete(Integer id, String sql)throws SQLException;
    boolean update(Student student, String sql)throws SQLException;
    Student get(Integer id, String sql) throws SQLException;
    List<Student> getAll() throws SQLException;
}
