package Logging;
import org.apache.log4j.*;
import org.apache.log4j.helpers.Loader;
import java.net.*;

public class MyClass_Property
{

	static Logger myLogger =  Logger.getLogger(Logging.MyClass_Property.class.getName());
	Object x;

	public MyClass_Property()
	{ 
		PropertyConfigurator.configure("config-sample.properties");

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
		MyClass_Property m = new MyClass_Property();
			m.do_something(1,(float)1.2);
	}

}
