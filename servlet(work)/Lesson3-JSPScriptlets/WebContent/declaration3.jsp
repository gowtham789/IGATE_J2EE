
<!-- Overriding init method in  JSP -->
<%! 
   
  String instanceVariable;

  public void init()
   {
    instanceVariable="in init() method<br/>"; 
   }

%>

<%   instanceVariable+="in service() method<br/>"; %>

<%=instanceVariable%>
