package Logging;
import java.io.*;
import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

public class XMLLayoutExample {
	
  static Logger logger =  Logger.getLogger("XMLLayoutExample.class");
  
  public static void main(String[] args) {
  try{
	  FileOutputStream filename=  new FileOutputStream("Writer.html");
	  WriterAppender writeappender = new WriterAppender(new HTMLLayout(),filename);
	  	logger.addAppender(writeappender);
	  			logger.info("Welcome");
	  			logger.info("to");
  				logger.info("Log4J");
  				logger.info("Writer Appender");
  				logger.info("Example");
  				logger.info("-----------");
  				logger.warn("Name not initialized");
  				logger.debug("Value of x initialized to 0");
  	}catch(Exception e){
  		System.out.println("Exception is ="+e.getMessage()); 
  	}
  }
} 