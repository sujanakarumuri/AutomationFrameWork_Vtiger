package GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This class contains all the java specific generic methods
	 * @author sujana
	 * @return 
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}
	/**
	 * This method will generate the system date, it will return this value 
	 * @return 
	 * @return 
	 * @return
	 */
	
	public String getSystemDate() // import java.util.Date;
	{
	    Date dd=new Date();
	    String d = dd.toString();
	    return d;
	}
	
	public String getSystemdateFormat()
	{
		Date date=new Date();
		String[] dd = date.toString().split(" ");
		String d = dd[2];
		String m = dd[1];
		String y = dd[5];
		String time = dd[3].replace(":","-");
		String currentdatetime=d+" "+m+" "+y+" "+time;
		return currentdatetime;
	}
	
	
	
}
