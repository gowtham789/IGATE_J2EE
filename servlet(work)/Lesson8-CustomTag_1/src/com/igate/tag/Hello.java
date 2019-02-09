package com.igate.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class Hello extends TagSupport {
	
	public int doStartTag()
	{
		System.out.println("In doStartTag()");
		return SKIP_BODY;
	}
	
	public int doEndTag()
	{
		System.out.println("In doEndTag()");
		return EVAL_PAGE;
	}

}
