/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class LoginDAO {
     public static boolean checkLogin(String email, String password)
    {
         Connection cn = null;
        try
        {
            
         cn=DBUtils.MyConection.makeConnection();
         if(cn!=null)
         {
            String sql="select userID,password from tblUsers\n" +
                        "where userID=? and password=?";
             
             PreparedStatement pst=cn.prepareStatement(sql);
             pst.setString(1,email);
             pst.setString(2, password);
             ResultSet rs=pst.executeQuery();
            
             if(rs.next())
             {
                 return true;
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
             if(cn!=null)
                 cn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
