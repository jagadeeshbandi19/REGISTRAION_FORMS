package REGISTRAION_FORMS.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import REGISTRAION_FORMS.model.Employee;

public class Employeedeo {
public int registereEmployee(Employee employee)throws ClassNotFoundException{
	String INSERT_USERS_SQL="INSERT INTO employee"+
"(id,frist_name,last_name,username,password,address,contact) VALUES"+
			"(?,?,?,?,?,?,?);";
	int result =0;
	Class.forName("com.mysql.jdbc.Driver");
	try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(1, employee.getFristname());
		preparedStatement.setString(1, employee.getLasttname());
		preparedStatement.setString(1, employee.getUsername());
		preparedStatement.setString(1, employee.getPassword());
		preparedStatement.setString(1, employee.getAddress());
		preparedStatement.setString(1, employee.getContact());
		System.err.println(preparedStatement);
		result=preparedStatement.executeUpdate();
		
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return result;
}
}
