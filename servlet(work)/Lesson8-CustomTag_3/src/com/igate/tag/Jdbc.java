package com.igate.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Jdbc extends TagSupport {
	boolean loadingSuccess=false;
	JspWriter out;
	public int doStartTag()
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		out=pageContext.getOut();
		try {
			Class.forName(driver);
			loadingSuccess=true;
			out.print("<h3>"+driver+" Loaded </h3>");
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
