package com.cg.emp.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.emp.dto.Employee;
import com.cg.emp.dto.LoginDto;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmpServiceImpl;
import com.cg.emp.service.IEmpService;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    ServletConfig config;
    IEmpService empService;
    public EmployeeController() 
    {
        super();
        System.out.println("employee controller constructor");
       
    }

	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		this.config=config;
		System.out.println("employee controller init");
	}

	
	public void destroy() 
	{
		System.out.println("employee controller destroy");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		empService=new EmpServiceImpl();
		
		if(action!=null)
		{
			
			//***********this action shows login page*******************
			if(action.equals("DisplayLoginPage"))
			{
				
				ServletContext ctx=getServletConfig().getServletContext();
				Integer hitCount=(Integer)ctx.getAttribute("HitCount");
				if(hitCount==null)
				{
					hitCount=new Integer(1);
					ctx.setAttribute("HitCount", hitCount);
				}
				else
				{
					int ct=hitCount.intValue();
					hitCount=new Integer(++ct);
					System.out.println("in else.."+hitCount);
					ctx.setAttribute("HitCount", hitCount);
				}
				RequestDispatcher rd=request.getRequestDispatcher("/pages/Login.jsp");
				rd.forward(request, response);
			}
			
			//this action is for displaying home page
			if(action.equals("DisplayHomePage"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/pages/home.jsp");
				rd.forward(request, response);
			}
			
			//******************ValidateUser******************
			
			if(action.equals("ValidateUser"))
			{
				String uid=request.getParameter("txtUname");
				String pwd=request.getParameter("txtPassword");
				LoginDto logindto=new LoginDto(uid,pwd);
				
				try 
				{
					if(empService.getCount(uid)==1)
					{
						if(empService.isValidUser(logindto))
						{
							HttpSession session=request.getSession();
							session.setAttribute("UN", logindto.getUname());
							RequestDispatcher rd=request.getRequestDispatcher
									("pages/EmpOperation.jsp");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/pages/Login.jsp");
							request.setAttribute("Msg", "please login again");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/pages/Login.jsp");
						
						request.setAttribute("Msg", "please login again");
						rd.forward(request, response);
					}
				} 
				catch (EmployeeException e)
				{
					//System.out.println("error here");
					e.printStackTrace();
				}
			}
		
		
		//*******************DisplayAddEmpPage*****************
		
		if(action.equals("DisplayAddEmpPage"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/pages/AddEmp.jsp");
			int generatedEmpId;
			
			try 
			{
				generatedEmpId = empService.generateEmpId();
				request.setAttribute("EmpId", generatedEmpId);
				rd.forward(request, response);
			}
			catch (EmployeeException e) 
			{
				e.printStackTrace();
			}
			
		}
		//****************addEmp******************
		
		if(action.equals("addEmp"))
		{
			int eid=Integer.parseInt(request.getParameter("txtEmpId"));
			String enm=request.getParameter("TxtEmpName");
			int sal=Integer.parseInt(request.getParameter("TxtEmpSal"));
			Employee empObj=new Employee(eid,enm,sal);
			int dataInserted = 0;
			try 
			{
				dataInserted=empService.insertEmp(empObj);
				if(dataInserted==1)
				{
					ArrayList<Employee> empList=empService.getAllEmp();
					request.setAttribute("EmpList", empList);
					RequestDispatcher rd=request.getRequestDispatcher("/pages/ListAllEmp.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.print("error in emp insertion");
				}
			}
			catch (EmployeeException e)
			{
				
				e.printStackTrace();
			}
			
		}
		
		//******************DisplayEditEmpPage**********************
		
		if(action.equals("DisplayEditEmpPage"))
		{
			int eid=Integer.parseInt(request.getParameter("empId"));
			Employee ee;
			try 
			{
				ee = empService.getEmpInfo(eid);
				request.setAttribute("EmpObj",ee);
				RequestDispatcher rd=request.getRequestDispatcher("/pages/EditEmp.jsp");
				rd.forward(request, response);
			} 
			catch (EmployeeException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		//****************EditEmpInfo***********************
		
		if(action.equals("EditEmpInfo"))
		{
			int eid=Integer.parseInt(request.getParameter("txtEid"));
			String nm=request.getParameter("txtEname");
			int sal=Integer.parseInt(request.getParameter("txtEsal"));
			
			Employee ee=new Employee(eid,nm,sal);
			int dataUpdated;
			try 
			{
				dataUpdated = empService.updateEmp(ee);
				if(dataUpdated==1)
				{

					ArrayList<Employee> empList=empService.getAllEmp();
					request.setAttribute("EmpList", empList);
					RequestDispatcher rd=request.getRequestDispatcher("/pages/ListAllEmp.jsp");
					rd.forward(request, response);
				}
			} 
			catch (EmployeeException e)
			{
				
				e.printStackTrace();
			}
			
		}
		
		
		//****************ListAllEmpPage***********************
		
		if(action.equals("ListAllEmpPage"))
		{
			ArrayList<Employee> empList;
			try 
			{
				empList = empService.getAllEmp();
				request.setAttribute("EmpList", empList);
				RequestDispatcher rd=request.getRequestDispatcher("/pages/ListAllEmp.jsp");
				rd.forward(request, response);
			} 
			catch (EmployeeException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		//*******************************
		if(action.equals("DisplayDeleteEmpPage"))
		{
			int eid=Integer.parseInt(request.getParameter("empId"));
			Employee ee;
			try 
			{
				ee = empService.getEmpInfo(eid);
				request.setAttribute("EmpObj",ee);
				RequestDispatcher rd=request.getRequestDispatcher("/pages/DeleteEmp.jsp");
				rd.forward(request, response);
			} 
			catch (EmployeeException e) 
			{
				e.printStackTrace();
			}
		}
		
		//******************DeleteEmpInfo****************
		if(action.equals("DeleteEmpInfo"))
		{
			int eid=Integer.parseInt(request.getParameter("txtEid"));
			String nm=request.getParameter("txtEname");
			int sal=Integer.parseInt(request.getParameter("txtEsal"));
			
			Employee ee=new Employee(eid,nm,sal);
			int dataDeleted;
			try 
			{
				dataDeleted = empService.deleteEmp(ee);
				if(dataDeleted==1)
				{

					ArrayList<Employee> empList=empService.getAllEmp();
					request.setAttribute("EmpList", empList);
					RequestDispatcher rd=request.getRequestDispatcher("/pages/ListAllEmp.jsp");
					rd.forward(request, response);
				}
			} 
			catch (EmployeeException e)
			{
				
				e.printStackTrace();
			}
		}
		
		}
		
		//***************************************
		else
		{
			out.print("no action defined");
		}
		
	}

}
