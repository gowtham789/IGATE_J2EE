package Logging;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MyClass {
	Object x;
	Logger myLogger;
	public MyClass() {
	  myLogger = Logger.getLogger("MyClass");
		myLogger.setLevel(Level.INFO);
		// SimpleLayout myLayout = new SimpleLayout();
		HTMLLayout myLayout = new HTMLLayout();
		Appender myAppender = new ConsoleAppender(myLayout);
		myLogger.addAppender(myAppender);

	}

	public void do_something(int a, float b) {
		myLogger.info("Logged since INFO=INFO");
		myLogger.debug("Hai I am printing using Log 4J DEBUG < INFO");
		// if (x == null)
		// {
		myLogger.error("enabled & logged ,since ERROR > INFO"); // }
	}

	public static void main(String args[]) {
		new MyClass().do_something(1, (float) 1.2);
	}
}
