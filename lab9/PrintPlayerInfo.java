import java.io.PrintWriter;
import java.util.*;
import java.io.File;

public class PrintPlayerInfo
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
	
	 public static boolean sanity_check(String[][] data)
	 {
	   if (data == null)
	   {
	     System.out.printf("No data has been loaded.\n");
	     return false;
	   }
	      
	   // make sure the file is not empty.
	   if (data.length < 2)
	   {
	     return false;
	   }
	   return true;
	 }
	 
	
	public static void printPlayerInfo(String[][] data, String player)
	{
		if (sanity_check(data) == false)
	    {
	      return;
	    }
	    System.out.printf("\n");  
		for(int row = 0; row < data.length; row++)
		{
				String s1 = data[row][0];
				s1 = s1.toLowerCase();
				if(s1.indexOf(player) != -1)
				{
					int label = 0;
					for(int i = 0; i < data[row].length; i++)
					{
						if(label == data[0].length)
						{
							System.out.printf("\n\n");
							break;
						}
						System.out.printf("%21s: %s\n",data[0][i],data[row][i]);
						if(i == data[row].length - 1)
						{
							System.out.printf("\n\n");
						}
						label++;
					}
				}
		}
	}
	
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter the name of a file to read: ");
      String filename = in.next();
      String[][] data = readSpreadsheet(filename);
      System.out.printf("\nEnter part of a player's name (or q to quit): ");
      String player = in.next();
      if (player.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      printPlayerInfo(data, player);
    }
      
  }
}