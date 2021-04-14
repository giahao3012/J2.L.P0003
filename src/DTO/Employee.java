/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class Employee {
    String EmpID;
    String Fullname;
    String Phone;
    String Email;
    String Address;
    Date DateOfBirth;
    boolean isDelete;

    public Employee() {
    }
    public Employee(String EmpID) {
        this.EmpID = EmpID;
    }
    public Employee(String EmpID, String Fullname, String Phone, String Email, String Address, Date DateOfBirth, boolean isDelete) {
        this.EmpID = EmpID;
        this.Fullname = Fullname;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
        this.isDelete = isDelete;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String EmpID) {
        this.EmpID = EmpID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return EmpID+""+Fullname+""+Email+""+Address+""+DateOfBirth+""+isDelete; //To change body of generated methods, choose Tools | Templates.
    }
    
}
