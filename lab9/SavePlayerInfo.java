import java.io.PrintWriter;
import java.util.*;
import java.io.File;

public class SavePlayerInfo
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
	    // System.out.printf("No data has been loaded.\n");
	     return false;
	   }
	      
	   // make sure the file is not empty.
	   if (data.length < 2)
	   {
	     return false;
	   }
	   return true;
	 }
	 
	
	public static void savePlayerInfo(String[][] data, String player, String output_name)
	{
	    PrintWriter out = null;

		try
	    {
	      out = new PrintWriter(output_name);
	    }
	    catch (Exception e)
	    {
	      System.out.printf("Error in opening file for writing\n", output_name);
	      System.exit(0);
	    }
		
		if (sanity_check(data) == false)
	    {
			out.printf("No data has been loaded.\n");
			out.close();
	      return;
	    }
	    //out.printf("\n");  
		for(int row = 0; row < data.length; row++)
		{
				String s1 = data[row][0];
				s1 = s1.toLowerCase();
				if(s1.indexOf(player.toLowerCase()) != -1)
				{
					int label = 0;
					for(int i = 0; i < data[row].length; i++)
					{
						if(label == data[0].length)
						{
							out.printf("\n");
							break;
						}
						out.printf("%21s: %s\n",data[0][i],data[row][i]);
						if(i == data[row].length - 1)
						{
							out.printf("\n");
						}
						label++;
					}
				}
		}
		out.close();
	}
	
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter the name of a file to read: ");
      String input_name = in.next();
      System.out.printf("\nEnter the name of the output file: ");
      String output_name = in.next();
      String[][] data = readSpreadsheet(input_name);
      System.out.printf("\nEnter part of a player's name (or q to quit): ");
      String player = in.next();
      if (player.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      savePlayerInfo(data, player, output_name);
    }
  }
}