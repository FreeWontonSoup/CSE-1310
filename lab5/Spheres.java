import java.util.Scanner;

public class Spheres
{
  // This function gets a double number from the user.
  // It ensures that the user enters a valid double number 
  // that is >= 0.  
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
    	 if(result < 0)
    	 {
    		 System.out.printf("%d is not positive.\n", result);
    		 System.exit(0);
    	 }
      }
      catch(Exception e)
      {
    	  System.out.printf("%s is not a valid double.\n", s);
    	  System.exit(0);
      }

      return result;
    }
  }
  
  public static double sphereVolume(double radius)
  {
	  double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
	  return volume;
  }
  
  
  public static void main(String[] args)
  {
    while(true)
    {
      double r = userDouble("Please enter a radius >= 0, or q to quit: ");
      
      double volume = sphereVolume(r);
      System.out.printf("Volume = %.2f.\n\n", volume);
    }
  }
}
