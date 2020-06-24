package com.encode;

import java.net.URL;

public class pathsconst {
	public String Driver()
	{
		ClassLoader classLoader = getClass().getClassLoader();
	    URL resource = classLoader.getResource("resources/chromedriver.exe");
	    String text = resource.getPath();
	    return text.replaceAll("/", "//").substring(2);
	}
	public String Report1()
	{
		   ClassLoader classLoader1 = getClass().getClassLoader();
		    URL resource1 = classLoader1.getResource("resources/record.html");
		    String text1 = resource1.getPath();
	   String reportfile=("file:///"+text1.substring(1));
	   return reportfile;
	}
	public String Report2()
	{
	   ClassLoader classLoader2 = getClass().getClassLoader();
	    URL resource2 = classLoader2.getResource("resources/record.html");
	    String text2 = resource2.getPath();
	    String templatePath2 =text2.replaceAll("/", "\\\\\\\\");
       String reportpath = templatePath2.substring(2);
	 return reportpath;
}
}
