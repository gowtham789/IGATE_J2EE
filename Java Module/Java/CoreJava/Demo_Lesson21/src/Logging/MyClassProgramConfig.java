package Logging;
import org.apache.log4j.*;

public class MyClassProgramConfig 
{

	static Logger myLogger =  Logger.getLogger("MyClassProgramConfig");
	Appender myAppender;
	SimpleLayout myLayout;
	Object x;

	public MyClassProgramConfig()
	{ 

		myLogger.setLevel(Level.INFO);
		myLayout = new SimpleLayout();
		myAppender = new ConsoleAppender(myLayout); 
		myLogger.addAppender(myAppender);

	}

	public void do_something( int a, float b)
	{
		myLogger.info("do_something are: " + a +" "+ b); 
		myLogger.debug("Operation performed successfully");
		if (x == null)
		{
		myLogger.error("Value of X is null");

		}
	}
	public static void main(String args[])
	{
		MyClassProgramConfig m = new MyClassProgramConfig();
		myLogger.info("Going 2 call a method");
			m.do_something(1,(float)1.2);
			myLogger.info("Successfully completed");
	}

}
