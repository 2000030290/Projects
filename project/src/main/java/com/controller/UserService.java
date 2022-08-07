package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.User;
import com.model.UserRemote;

@ManagedBean(name="user",eager=true)
public class UserService {
	
	  String name;
	  int age;
	  String mobileno;
	  String address;
	  String password;
	  String gemail;
	  String gpassword;
	  public String getGemail() {
		return gemail;
	}

	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public String getGpassword() {
		return gpassword;
	}

	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}
	char gender;
	  String email; 
	  String response;
	  List<User> list;
	  @EJB (lookup = "java:global/project/UserModel!com.model.UserRemote")
	  UserRemote UR;
	  
		public void delete()
		{
			try
			{
				response = UR.deleteData(name);
			}catch(Exception e)
			{
				response = e.getMessage();
			}
		}
		
		public void update()
		{
			try
			{
				User E =new User();
				E.setName(name);
				E.setAge(age);
				E.setMobileno(mobileno);
				E.setAddress(address);
				E.setPassword(password);
				E.setEmail(email);
				E.setGender(gender);
				
				response = UR.updateData(name, E);
				
			}catch(Exception e)
			{
				response = e.getMessage();
			}
		}
		
		public void find()
		{
			try
			{
				User E = UR.findData(name);
				
				name = E.getName();
				age=E.getAge();
				mobileno=E.getMobileno();
				address=E.getAddress();
				password=E.getPassword();
				email=E.getEmail();
				gender=E.getGender();
				gpassword=E.getPassword();
				gemail=E.getName();
				
			}catch(Exception e)
			{
				response = e.getMessage();
			}
		}
		public String verify() {
	        find();
	        if(name.equals(gemail)&&password.equals(gpassword)) {
	        	response="same in database";
	            return "customermain";
	        }
	        else {
	            return "But your Login Failed";
	        }
	    }
		
		public void insert()
		{
			try 
			{
				User E =new User();
				E.setName(name);
				E.setAge(age);
				E.setMobileno(mobileno);
				E.setAddress(address);
				E.setPassword(password);
				E.setEmail(email);
				E.setGender(gender);
				System.out.println(name+" "+mobileno+" "+address+" "+email+" "+password+" "+gender+" ");
				response = UR.insertData(E);
			} catch (Exception e) 
			{
				response = e.getMessage();
			}
		}
		
	  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<User> getList() {
		try 
		{
			list = UR.readAll();
		} catch (Exception e) 
		{
			response = e.getMessage();
		}
		return list;
		
	}
	public void setList(List<User> list) {
		this.list = list;
	}

}
