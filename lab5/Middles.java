import java.util.Scanner;

public class Middles
{  
  // This function gets a double number from the user.
  // It ensures that the user enters a valid double number.  
  public static double userDouble(String message)
  {
    Scanner in = new Scanner(System.in);
    double result = 0;
    while (true)
    {
      System.out.printf(message);
      String s = in.next();
      if (s.toLowerCase().equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      
      try
      {
    	  result = Double.parseDouble(s); 
      }
      catch(Exception e)
      {
    	  System.out.printf("%s is not a valid double.\n", s);
    	  System.exit(0);
      }
        
      return result;
    }
   
  }
  
  public static double pickMiddle(double first, double second, double third)
  {
	  if((first >= second && first <= third) || (first >= third && first <= second))
	  {
		  return first;
	  }
	  else if((second >= first && second <= third) || (second <= first && second >= third))
	  {
		  return second;
	  }
	  else
	  {
		  return third;
	  }
	  
  }
  
  
  public static void main(String[] args)
  {
    while (true)
    {
      double first = userDouble("please enter the first number, or q to quit: ");
      double second = userDouble("please enter the second number, or q to quit: ");
      double third = userDouble("please enter the third number, or q to quit: ");
      double middle = pickMiddle(first, second, third);
      System.out.printf("the middle value is %.1f\n\n", middle);
    }
  }
}