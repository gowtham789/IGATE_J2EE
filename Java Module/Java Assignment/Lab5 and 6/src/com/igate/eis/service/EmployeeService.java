package com.igate.eis.service;

import com.igate.eis.bean.Employee;

public class EmployeeService implements IEmpService{

	@Override
	public String calcInsScheme(Employee e1)
	{
		if((e1.getEmpSal()>5000 && e1.getEmpSal()<20000)&&(e1.getDesig().equals("systemassociate")))
		{
			e1.setInsScheme("SchemeC");
		}
		else if((e1.getEmpSal()>=20000&&e1.getEmpSal()<40000)&&(e1.getDesig().equals("programmer")))
		{	
			e1.setInsScheme("SchemeB");
		}
		else if((e1.getEmpSal()>=40000)&&(e1.getDesig().equals("manager")))
		{
			e1.setInsScheme("SchemeA");
		}
		else if((e1.getEmpSal()<5000)&&(e1.getDesig().equals("clerk")))
		{
			e1.setInsScheme("NoScheme");
		}
		else
		{
			System.out.println("Exception");
		}
		String ins1=e1.getInsScheme();
        return ins1;
     }
	 
  
}
