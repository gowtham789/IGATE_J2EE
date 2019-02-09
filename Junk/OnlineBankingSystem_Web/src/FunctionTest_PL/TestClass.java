package FunctionTest_PL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import service_EJB.OnlineBankingSystem;
import service_EJB.OnlineBankingSystemInterface;
import dao.DatabaseOperations;
import dao.DatabaseOperationsInterface;
import dto_JPA.Useraccount;
public class TestClass {
public static void main(String[] args) {
	OnlineBankingSystemInterface OBS=new OnlineBankingSystem();
	//OBS.RegisterUser(129, "aaa", "sample", "sample@gmail", "ss", "savings", "samp", "nothing", "nothing", "hello", 140,783783);
	//System.out.println(OBS.AuthenticateUser(138, "samp"));
	//System.out.println(OBS.ForgotPassword(123, "who is your true love", "kirti"));
	//System.out.println(OBS.GenerateStatement(123, 1));
	//System.out.println(new Date());	
	//System.out.println(OBS.GenerateStatement(123, new GregorianCalendar(2016, Calendar.FEBRUARY, 22).getTime(), new GregorianCalendar(2016, Calendar.FEBRUARY, 24).getTime()));
	//System.out.println(OBS.ViewCustomerInfo(123));
	//System.out.println(OBS.ViewAccountInfo(123));
//	OBS.UpdateCustomerInfo("Pune", 9080, "Sandy@ggg", 123);
//	System.out.println(OBS.ViewCustomerInfo(123));
//	System.out.println(OBS.RaiseServiceRequest(101, "aaa", "open",
//			new GregorianCalendar().getTime()));
	//System.out.println(OBS.viewallRequests(123));
	//System.out.println(OBS.addTransactionHistory(101, "Withdrwal",500.0f, "OMG"));
	//System.out.println(OBS.accountDebitSameBank(500.0f, 124,123));
	System.out.println("hiee");
	//System.out.println(OBS.viewallRequests(123));
	//System.out.println(OBS.viewSerivceDetails(10));
	
}
}
