package Logging;
import org.apache.log4j.*;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;
import java.net.*;

public class MyClass_XML
{

	static Logger myLogger =  Logger.getLogger(Logging.MyClass_XML.class.getName());
	Object x;

	public MyClass_XML()
	{ 
		//URL url = Loader.getResource("config-sample.xml");
		DOMConfigurator.configure("resources/config-sample.xml");
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
		MyClass_XML m = new MyClass_XML();
			m.do_something(1,(float)1.2);
	}

}
