package Logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FileAppenderProps {

Logger myLogger =  Logger.getLogger(Logging.FileAppenderProps.class.getName());
	Object x;

	public FileAppenderProps()
	{ 	
		PropertyConfigurator.configure("fileApp.properties");
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

		FileAppenderProps m = new FileAppenderProps();
			m.do_something(1,(float)1.2);

	}

}
