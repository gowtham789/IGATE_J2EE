package Logging;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
public class simpandfile
{ 
	static Logger logger = Logger.getLogger(simpandfile.class); 
    public static void main(String args[])
  { 
  XMLLayout layout = new XMLLayout(); 
   ConsoleAppender appender = null; 
       try { 
        	  appender = new ConsoleAppender(layout); 
        	}   catch(Exception e) {} 
	   logger.addAppender(appender);
	  logger.setLevel((Level) Level.INFO); 
       logger.debug("Here is some DEBUG");
	   logger.info("Here is some INFO");
	   logger.warn("Here is some WARN");
	   logger.error("Here is some ERROR"); 
	   logger.fatal("Here is some FATAL"); } } 
