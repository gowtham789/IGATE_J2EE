
<!-- Writing user definied functions in JSP -->
<%! 

  public String sayHello(String name)
   {
    return "Hello "+name; 
   }

%>

<%=sayHello("IGATE")%>
