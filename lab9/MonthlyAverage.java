import java.util.*;
import java.io.File;

public class MonthlyAverage
{
	public static ArrayList<String> read_file(String filename)
	  {
	    File temp = new File(filename);
	    Scanner input_file;
	    try
	    {
	    	input_file = new Scanner(temp);
	    }
	    catch(Exception e)
	    {
	    	System.out.printf("Failed to open file %s\n", filename);
	    	return null;
	    }
	    
	    ArrayList<String> result = new ArrayList<String>();
	    while(input_file.hasNextLine())
	    {
	    	String line = input_file.nextLine();
	    	result.add(line);
	    }
	    
	    input_file.close();
	    return result;
	  } 
	
	public static String[][] readSpreadsheet(String filename)
	{
		ArrayList<String> lines = read_file(filename);
		   if (lines == null)
		   {
		     return null;
		   }
		   

		   // The row below creates an array of length "rows", that stores
		   // objects of type String[]. Those objects are initialized to null.
		   String[][] result = new String[lines.size()][];
		   
		   for (int i = 0; i < lines.size(); i++)
		   {
		     String line = lines.get(i);
		     result[i] = line.split(",");     
		   }
		   
		   return result;
	}
	
	public static double monthlyAverage(String filename, int column, int month)
	{
		String monthString = Integer.toString(month);
		String[][] sheet = readSpreadsheet(filename);
		String date = "";
		int count = 0;
		double total = 0;
		double average = 0;
		
		for(int row = 1; row < sheet.length; row++)
		{
			for(int col = 0; col < sheet[row].length; col++)
			{
				if(sheet[row][0].indexOf(monthString) == 4)
				{
					total += Double.parseDouble(sheet[row][column]);
					count++;
				}
				else
				{
					break;
				}
			}
		}
		if(count == 0)
		{
			return -1;
		}
		average = total / count;
		return average;
	}
	
	public static String columnName(String filename, int column)
	{
		String[][] sheet = readSpreadsheet(filename);
		String col = "";
		
		try
		{
			col = sheet[0][column];
		}
		catch(Exception e)
		{
			return null;
		}
		return col;
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
      
      return result;
    }
  }  
  
  
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("Enter a filename (or q to quit): ");
      String filename = in.next();
      if (filename.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      int column = userInteger("Enter a column: ");
      String name = columnName(filename, column);
      if (name == null)
      {
        System.out.printf("Failed to extract a valid column name for column %d of %s\n\n",
                          column, filename);
        continue;
      }
      int month = userInteger("Enter a month: ");
      
      double average = monthlyAverage(filename, column, month);
      if (average == -1.00)
      {
        System.out.printf("In file %s, there is no data for %s for month %d.\n\n",
                          filename, name, month);
      }
      else
      {
        System.out.printf("In file %s, the average %s for month %d is %.2f.\n\n",
                          filename, name, month, average);
      }
    }
  }
}