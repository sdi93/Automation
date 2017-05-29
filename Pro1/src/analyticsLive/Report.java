package analyticsLive;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Report {
	public static ExtentReports report;
	public static ExtentTest logger;
	
	public static String initialSNAPLOC ;
	public static String SNAPLOC ;
	public static File dir1;
	public static String date =null;
	
	public static void reportINitialise(String repName){
		date = date();
		initialSNAPLOC = "/GitCodeQA/Pro1/report/"+repName+date;
		dir1 = new File(initialSNAPLOC);
		String absodir=dir1.getAbsolutePath();
		File dir2 =new File(absodir);
		SNAPLOC = absodir+"/";
		dir2.mkdir();
		report=new ExtentReports(SNAPLOC+repName+".html",true);
	}
	
	public static String  date()
	{
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	    LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
		return datee;
	}

}
