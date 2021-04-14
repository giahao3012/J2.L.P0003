/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class EmpDAO {
     public static ArrayList<Employee> getEmployee()
    {
        ArrayList<Employee> result=new ArrayList<>();
        Connection cn=null;
        try
        {
            cn=DBUtils.MyConection.makeConnection();
            if(cn!=null)
            {
                String sql="select * from tblEmployee\n" +
                            "where isDelete=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setBoolean(1,false);
                ResultSet rs =pst.executeQuery();
                while(rs.next())
                {
                   Employee e=new Employee(rs.getString("empID"), 
                                           rs.getString("Fullname"), 
                                           rs.getString("Phone"), 
                                           rs.getString("Email"), 
                                           rs.getString("Address")
                                         , rs.getDate("DateOfBirth"), 
                                           rs.getBoolean("isDelete"));
                   result.add(e);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            try
            {
                if(cn!=null) cn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
      public static Employee getEmpbyEmpID(String empID)
   {
       Employee e=new Employee();
        Connection cn=null;
        try
        {
            cn=DBUtils.MyConection.makeConnection();
            if(cn!=null)
            {
                String sql="select * from tblEmployee\n" +
                            "where empID=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, empID);
                ResultSet rs =pst.executeQuery();
                while(rs.next())
                {
                     e=new Employee(rs.getString("empID"), 
                                           rs.getString("Fullname"), 
                                           rs.getString("Phone"), 
                                           rs.getString("Email"), 
                                           rs.getString("Address")
                                         , rs.getDate("DateOfBirth"), 
                                           rs.getBoolean("isDelete"));
                }
            }
        }catch(SQLException ee)
        {
            ee.printStackTrace();
        }
        return e;
   }
       public static ArrayList<Employee> getEmpID()
   {
       ArrayList<Employee> list=new ArrayList<>();
        Connection cn=null;
        try
        {
            cn=DBUtils.MyConection.makeConnection();
            if(cn!=null)
            {
                String sql="select empID from tblEmployee";
                PreparedStatement pst=cn.prepareStatement(sql);
                ResultSet rs =pst.executeQuery();
                while(rs.next())
                {
                     Employee e=new Employee(rs.getString("empID"));
                     list.add(e);
                }
            }
        }catch(SQLException ee)
        {
            ee.printStackTrace();
        }
        return list;
   }
      public static int createEmployee(Employee e) throws SQLException
    {
        Connection cn=DBUtils.MyConection.makeConnection();
        int result=0;
        if(cn!=null)
        {
            String sql="insert tblEmployee values(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, e.getEmpID());
            pst.setString(2, e.getFullname());
            pst.setString(3, e.getPhone());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getAddress());
            pst.setDate(6, e.getDateOfBirth());
            pst.setBoolean(7, e.isIsDelete());
            result=pst.executeUpdate();
        }
        return result;
    }
    public static int updateSupplier(Employee e) throws SQLException
    {
         Connection cn=DBUtils.MyConection.makeConnection();
        int result=0;
        if(cn!=null)
        {
            String sql="update tblEmployee set\n" +
                                "Fullname=?,\n" +
                                "Phone=?,\n" +
                                "Email=?,\n" +
                                "Address=?,\n" +
                                "DateOfBirth=?\n" +
                                "where empID=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(6, e.getEmpID());
            pst.setString(1, e.getFullname());
            pst.setString(2, e.getPhone());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getAddress());
            pst.setDate(5, e.getDateOfBirth());
            result=pst.executeUpdate();
        }
        return result;
    }
    public static int deleteEmployee(String empID) throws Exception
    {
        Connection cn=DBUtils.MyConection.makeConnection();
        int result=0;
        if(cn!=null)
        {
            String sql1="update tblEmployee set isDelete=1\n" +
                        "where empID=?";
            PreparedStatement pst=cn.prepareStatement(sql1);
            pst.setString(1, empID);
            result=pst.executeUpdate();
        }
        return result;
    }
}
