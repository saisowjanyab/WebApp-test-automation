package com.encodereport;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import com.encode.pathsconst;


public class Reporter {
	
	private static ArrayList <Result> details =new ArrayList<Result>();
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private final static String templatePath ="resources/ReportTemplate.html";
   
	   
	    //System.out.println(chromeDriver.get());
	   
  
	public static void report(String actualValue,String expectedValue,String testname,String ex) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result(testname+ " Pass","Actual value '" + actualValue + "' matches expected value");
			details.add(r);
		} else {
			Result r = new Result(testname+ " Fail","Exception'" + ex+ "' caught '");
			details.add(r);
		}
	}
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	public static void writeResults() {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
			}
			
			pathsconst temp= new pathsconst();
			String reportPath = temp.Report2();
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
}