import java.util.*;
import java.io.File;

public class ColumnSum
{
	public static ArrayList<String> read_file(String filename)
	  {
	    File temp = new File(filename);
	    Scanner input_file;
	    try
	    {
	      input_file = new Scanner(temp);
	    }
	    catch (Exception e)
	    {
	      System.out.printf("Failed to open file %s\n",
	                        filename);
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
	
	public static double columnSum(String filename, int column)
	{	
		if(read_file(filename) == null)
		{
			return 0.0;
		}
		
		String[][] sheet = readSpreadsheet(filename);
		double total = 0;
		
		for(int row = 1; row < sheet.length; row++)
		{
			String spot = "";
			try
			{
				spot = sheet[row][column];
			}
			catch(Exception e)
			{
				continue;
			}
			
			try
			{
				total += Double.parseDouble(spot);
			}
			catch(Exception e)
			{
				continue;
			}
		}
		return total;
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
      
      double sum = columnSum(filename, column);
      System.out.printf("In file %s, column %d has sum %.2f\n\n",
                        filename, column, sum);
    }
  }
}