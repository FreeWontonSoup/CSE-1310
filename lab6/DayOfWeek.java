import java.util.Scanner;

public class DayOfWeek
{
  public static int daysPassed(int year, int month, int day)
  {
	  int totaldays = 0;
	  for(int i = 1000; i < year; i++)
	  {
		  totaldays += yearDays(i);
	  }
	  
	  for(int i = 1; i < month; i++)
	  {
		  totaldays += monthDays(year, i);
	  }
	  
	  totaldays += day;
	  
	  return totaldays;
  }
  
  public static String dayOfWeek(int year, int month, int day)
  {
	  if(daysPassed(year, month, day) % 7 == 0)
	  {
		  return "Tuesday";
	  }
	  else if(daysPassed(year, month, day) % 7 == 1)
	  {
		  return "Wednesday";
	  }
	  else if(daysPassed(year, month, day) % 7 == 2)
	  {
		  return "Thursday";
	  }
	  else if(daysPassed(year, month, day) % 7 == 3)
	  {
		  return "Friday";
	  }
	  else if(daysPassed(year, month, day) % 7 == 4)
	  {
		  return "Saturday";
	  }
	  else if(daysPassed(year, month, day) % 7 == 5)
	  {
		  return "Sunday";
	  }
	  else
	  {
		  return "Monday";
	  }
  }
  
  public static int yearDays(int year)
  {
	  if (year % 100 == 0)
	    {
	        if (year % 400 == 0)
	        {
	            return 366;
	        }
	        else
	        {
	            return 365;
	        }
	    }
	    else
	    {
	        if (year % 4 == 0)
	        {
	            return 366;
	        }
	        else
	        {
	            return 365;
	        }
	    }
  }
  
  public static int monthDays(int year, int month)
  {
	  int retdays = 0;
	  int jan = 31;
	  int march = 31;
	  int april = 30;
	  int may = 31;
	  int june = 30;
	  int july = 31;
	  int aug = 31;
	  int sept = 30;
	  int oct = 31;
	  int nov = 30;
	  int dec = 31;
	  
	  if(yearDays(year) == 366 && month == 2)
	  {
		  return 29;
	  }
	  else
	  {
		  switch (month) 
		  {
          case 1:  retdays = jan;
                   break;
          case 2:  retdays = 28;
          		   break;
          case 3:  retdays = march;
                   break;
          case 4:  retdays = april;
                   break;
          case 5:  retdays = may;
                   break;
          case 6:  retdays = june;
                   break;
          case 7:  retdays = july;
                   break;
          case 8:  retdays = aug;
                   break;
          case 9:  retdays = sept;
                   break;
          case 10: retdays = oct;
                   break;
          case 11: retdays = nov;
                   break;
          case 12: retdays = dec;
                   break;
		  }
	  }
	  return retdays;
  }
  
  public static int userInteger(String message)
  {
    Scanner in = new Scanner(System.in);
    int result;
    while (true)
    {
      System.out.printf(message);
      String s = in.next();
      if (s.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      
      try
      {
        result = Integer.parseInt(s);
      } 
      catch (Exception e)
      {
        System.out.printf("%s is not a valid number, try again.\n\n", s);
        continue;
      }
      
      if (result <= 0)
      {
        System.out.printf("%s is <= 0, try again.\n\n", s);
        continue;
      }
      return result;
    }
  }
  
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    while (true)
    {
      int year = userInteger("Enter a year (must be >= 1000): ");      
      if (year < 1000)
      {
        System.out.printf("Invalid year.\n\n");
        continue;
      }

      int month = userInteger("Enter a month(must be between 1 and 12): ");
      if (month > 12)
      {
        System.out.printf("Invalid month.\n\n");
        continue;
      }
      
      int day = userInteger("Enter a day: ");
      
      int result = daysPassed(year, month, day);
      System.out.printf("%d days have passed from 12/31/999 to %d/%d/%d.\n", 
                        result, month, day, year);
      
      String day_name = dayOfWeek(year, month, day);
      System.out.printf("%d/%d/%d is a %s.\n\n", month, day, year, day_name);
    }
  }
}