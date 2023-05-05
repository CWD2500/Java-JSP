package com.Christiane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class StudentDao {

	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Drive");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjsp","studentjsp" ,"student");
		return con;
		
	}
	
//	insert Data Base 	(Student)
	public static  int save(Student s) 
	{
		int status = 0;
		try {
			Connection con =StudentDao.getConnection();
			String sql = "insert  into studentjsp(name, email , password, counrty , gender)values(?,?,?,?)";
			PreparedStatement statement =  con.prepareStatement(sql);
			statement.setString(1, s.getName());
			statement.setString(2 , s.getEmail());
			statement.setString(3, s.getPassword());
			statement.setString(4 , s.getCountry());
			statement.setString(5, s.getGender());
			
			status = statement.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			return status;
		}
		return status;
			
		
	}
	
//	 Update Data Base (Student)
	
	public static int update(Student s) 
	{
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			String sql = "update studentjsp set name=? , email=? , password = ? , country=? gender=? ,   where=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1 , s.getName());
			statement.setString(2  , s.getEmail());
			statement.setString(3 , s.getPassword());
			statement.setString(4, s.getCountry());
			statement.setString(5, s.getGender());
			statement.setInt(6, s.getId());
			
			status = statement.executeUpdate();
			
		} catch (Exception e) {
			return status;
		}
		return status;
	}
	
	
//	 Delete Data  Base (Student)
	public static int delete(Student s) {
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			String sql = "delete from studentjsp where id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, s.getId());
			
			status  = statement.executeUpdate();
			
		} catch (Exception e) {
			return status;
		}
		return status;
	
	}
	
	
//	Read Data Base (Student)
	public static List<Student> readStudent()
	{
		List<Student> myList = new ArrayList<Student>();
		try 
		{
			Connection con = StudentDao.getConnection();
			String sql = "select  * from studentjsp  where id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result =statement.executeQuery();
			// result set :  ميشان قراء البيانات والحصول عليها 
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt("id")); // Note 
				student.setName(result.getString("name"));
				student.setEmail(result.getString("email"));
				student.setPassword(result.getString("password"));
				student.setCountry(result.getString("country"));
				student.setGender(result.getString("gender"));
				myList.add(student);
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			return myList;
		}
		return myList;
	}
	
}
