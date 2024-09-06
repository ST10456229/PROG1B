/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Student {
 private int id;
 private String name;
 private String email;
 private String course;
 
 public Student(int id,String name,String email,String course){
     this.id = id;
     this.name = name;
     this.email = email;
     this.course = course;
 }
 public int getID(){
  return id;     
 }
 public void setID(int id){
 this.id = id;    
 }
 public String getName(){
 return name;    
 }
 public void setName(){
     this.name = name;
 }
 public String getEmail(){
     return email;
 }
 public void setEmail(){
     this.email = email;
 }
 public String getCourse(){
     return course;
 }
 public void setCourse(){
     this.course = course;
 }
 public String toString(){
 return "Student ID:"+id+",Name"+name+",Email"+email+",Course"+course;
 
 }

    int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
