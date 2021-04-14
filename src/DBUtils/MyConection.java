/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class MyConection {
     public static Connection makeConnection()
    {
        Connection cn=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String ulr="jdbc:sqlserver://localhost:1433;databaseName=EmployeeManagement";
            cn=DriverManager.getConnection(ulr,"sa","123456789");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return cn;
    }
}
