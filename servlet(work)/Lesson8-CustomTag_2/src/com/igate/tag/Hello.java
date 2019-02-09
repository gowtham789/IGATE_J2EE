package com.igate.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Hello extends TagSupport {
	
	JspWriter out;
	
	public int doStartTag()
	{
		out=pageContext.getOut();
		try {
			
			 out.print("<h3>This output is from TagHandler</h3>");
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In doStartTag()");
		return SKIP_BODY;
	}
	
	public int doEndTag()
	{
		System.out.println("In doEndTag()");
		return EVAL_PAGE;
	}

}
