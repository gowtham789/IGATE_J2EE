package com.igate.jdbc.pl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.igate.jdbc.bean.Employee;
import com.igate.jdbc.service.EmployeeService;

public class JdbcClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext bf = new ClassPathXmlApplicationContext("jdbc.xml");
		EmployeeService service = (EmployeeService) bf
				.getBean("employeeService");

		
		  //execute queryForInt 
			int count=service.getCount();
		  System.out.println("No of Employees in the table :"+count);
		  System.out.println("--------------------");
		 try
		 {
		  String name=service.getEmployeeName(101);
		 System.out.println("Name "+name);
		 }
		 catch (EmptyResultDataAccessException e) 
			{
				System.out.println("The Employee ID is invalid");
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			}
		 
		  System.out.println("--------------------");
		  //execute update (insert new record) int
		 try
		 {
		  int insert=service.insertRec(1305,"Kate",55555.55);
		  if(insert>0)
		  System.out.println("Insert Success"); 
		  else
		  System.out.println("Insert Failed");
	}catch (DuplicateKeyException e) 
			{
				System.out.println("Employee Already Exist");
			} catch (DataAccessException e) 
			{
				System.out.println(e.getMessage());
			}
		  System.out.println("--------------------");
		 
		  List list=service.getAll();
		  if(list!=null)
		  {
		  System.out.println("List of Records");
		  for(Object emp:list) { 
			  //Employee e=(Employee)emp;
		  System.out.println(emp); 
		  }
		  
		  }
		  System.out.println("--------------------");
		 /* List<Employee> eList=service.getEmployeeList();
		  if(eList!=null)
		  {
		  System.out.println("List of Employees"); for(Employee e:eList)
		  System.out.println(e.getEid()+" "+e.getEnm()+" "+e.getEsl());
		  }
		  */
		 
		  //execute update (modify) 
		  int update=service.updateRec(103, "Chand", 77777.77); if(update>0)
		  System.out.println("Update Success"); else
		  System.out.println("Update Failed");
		  System.out.println("--------------------");
		  
		 //execute QueryForList 
		  try
		  {
		  Employee employee=service.getEmpByEid(103);
		  System.out.println("Employee Info");
		  System.out.println("EID :"+employee.getEid());
		  System.out.println("ENM :"+employee.getEnm());
		  System.out.println("ESL :"+employee.getEsl());
		  }catch (EmptyResultDataAccessException e) 
			{
				System.out.println("The Employee ID is invalid");
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			}

		  System.out.println("--------------------");
		  
		List<Employee> eList = service.getEmployeeList();
		System.out.println("List of Employees");
		for (Employee e : eList)
			System.out.println(e.getEid() + " ||||" + e.getEnm() + " "
					+ e.getEsl());

	}
	
	

}
