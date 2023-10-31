package NotUsed_Classes;

import java.util.Collections;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test{

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.mountsinai.org/");
		
		System.out.println( driver.getTitle() );

		driver.manage().window().maximize();
		
		
	}
	
}


//		int rownum = 5;
//
//		for (int i = 1; i <= rownum; i++) {
//
//			// for(int j=0;j<=rownum-i;j++)
//			//
//			// System.out.print(" ");
//
//			for (int k = 0; k < i; k++)
//				System.out.print("*");
//
//			System.out.print("\n");
//
//			System.out.print("\n");
//		}

		
//		String s= "my name is supriya";
//		
//				for(int i=0;i<s.length();i++)
//					if(s.charAt(i)!=' ')
//				System.out.println("Count of "+s.charAt(i)+" is : "+countChar(s,s.charAt(i)));
//		
//	}
//	
//	public static int countChar(String s , char x){
//		int count=0;
//		
//		for(int i=0;i<s.length();i++)
//		{
//			if(s.charAt(i)==x)
//			{
//				count++;
//			}
//		}
//		
//		return count;
	//}
//		String s1="My name is supriya";
//		String capitalizeWord ="";
//		String w="supriya";
//		String first=w.substring(0,1);  
//        String afterfirst=w.substring(1);  
//        capitalizeWord+=first.toUpperCase()+afterfirst; 
//
//System.out.println(capitalizeWord);

//
//for(String x:s1.split("i",0)){  
//System.out.println(x);  
//}  
		
//		for(int i=s1.length()-1;i>=0;i--)
//		{
//			System.out.print(s1.charAt(i));
//		}
//		
//		int count=0;
//		
//		for(int i=0;i<s1.length();i++){
//			
//			if(!(s1.charAt(i)==' '))
//			{
//				count++;
//			}
//		}
//		System.out.print(count);
		
		
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe" );
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.get("https://www.mountsinai.org/");
		
		
		// Creating an object of List<String>
//	      List<String> arrlist = new ArrayList<String>(); 
	        
	      // Adding elements to arrlist
//	      arrlist.add("geeks");
//	      arrlist.add("for");
//	      arrlist.add("geeks");
	        
	      // Printing the elements of arrlist
	      // before operations
	     // System.out.println("Elements of arrlist before the operations:");
	     // System.out.println(arrlist);
	        
	    //  System.out.println("Elements of arrlist after the operations:");
	        
	      // Adding all the specified elements
	      // to the specified collection
	    //  Collections.addAll(arrlist, "web", "site");
	        
	      // Printing the arrlist after
	      // performing addAll() method
	    //  System.out.println(arrlist);
	        
	      // Sorting all the elements of the  
	      // specified collection according to 
	      // default sorting order
	     // Collections.sort(arrlist);
	          
	      // Printing the arrlist after
	      // performing sort() method
	     // System.out.println(arrlist);
		
//	}
//
//}



