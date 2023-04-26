package Utilities;

import java.util.Date;
import java.util.Stack;

public class timeStamp {
	public static String timeStampWithemail() {
		Date date =new Date();
		String dateEmail= date.toString().replace(" ", "_").replace(":", "_");
		return "punith"+dateEmail+"@gmail.com";
	}

}
