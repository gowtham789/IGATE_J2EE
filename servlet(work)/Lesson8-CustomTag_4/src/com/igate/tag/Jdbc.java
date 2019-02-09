package com.igate.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Jdbc extends TagSupport {
	JspWriter out;
	private String driver;
	boolean loadingSuccess=false;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int doStartTag()
	{
		out=pageContext.getOut();
		try {
			Class.forName(getDriver());
			out.print("<h3>"+driver+" Loaded </h3>");
			loadingSuccess=true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndTag()
	{
		if(loadingSuccess)
		    return EVAL_PAGE;
		else
			return SKIP_PAGE;
	}

}
