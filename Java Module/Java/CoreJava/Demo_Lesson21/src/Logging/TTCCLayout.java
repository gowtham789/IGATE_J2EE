package Logging;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;



/*Displays It consists of following in its output log event: 

time 
thread 
category (Level) 
nested diagnostic context information 
name (output message) 

public class TTCCLayout {
  static Logger logger = Logger.getLogger("TTCCLayout.class");
  
  public static void main(String[] args) {
  try
  {
	  Appender myAppender;    TTCCLayout myLayout;
	  FileAppender fileappender = new FileAppender(new TTCCLayout(),"TTCCoutput.txt");
	  myAppender = new ConsoleAppender(myLayout);   
  logger.addAppender(myAppender);
  logger.info("First Log");  
  logger.info("Second Log");  
  logger.info("Third Log");  
  logger.info("Fourth Log");  
  logger.info("See your TTCCoutput.txt");
  logger.info("Exiting from the Main method  ");
  }catch(Exception e){
  e.printStackTrace();
  }
  }
} */