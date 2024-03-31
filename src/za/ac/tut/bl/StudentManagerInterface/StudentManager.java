/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl.StudentManagerInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import za.ac.tut.entity.Module.Module;
import za.ac.tut.entity.Student.Student;

/**
 *
 * @author taarb
 */
public class StudentManager implements StudentManagerInterface{
    private Connection connection;

    public StudentManager(String URL, String username, String password) throws SQLException{
        connection = DriverManager.getConnection(URL,username,password);
    }
    

    @Override
    public boolean add(Student student, String sql1, String sql2) throws SQLException {

        PreparedStatement ps1 = connection.prepareStatement(sql1);
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        
        ps1.setInt(1, student.getId());      
        ps1.setString(1, student.getName());      
        ps1.executeQuery();
        ps1.close();
        
        List<Module> modules = student.getModules();
        
        for (Module module : modules) {
            ps2.setInt(1, module.getId());
            ps2.setString(2, module.getName());
            ps2.setString(3, module.getCode());
            ps2.setInt(4, student.getId());
            ps2.executeUpdate();
            ps2.close();
            
        }
        return true;
    }

    @Override
    public boolean delete(Integer id, String sql) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        
        return true;

    }

    @Override
    public boolean update(Student student, String sql) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getId());
        ps.executeUpdate();
        ps.close();
        
        return true;
    }

    @Override
    public Student get(Integer id, String sql) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
