import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class phonebook
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
	
	public static boolean sanity_check(String[][] data)
	 {
	   if (data == null)
	   {
	     System.out.printf("No data has been loaded.\n");
	     return false;
	   }
	      
	   // make sure the file is not empty.
	  /* if (data.length < 2)
	   {
	     return false;
	   }*/
	   return true;
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
	
	public static String[][] readPhonebook()
	{
		String[][] book = readSpreadsheet("phonebook.txt");
		return book;
	}
	
	public static void savePhonebook(String[][] data, String new_name, String new_number)
	{
		PrintWriter out = null;
		
		try
	    {
	      out = new PrintWriter("phonebook.txt");
	    }
	    catch (Exception e)
	    {
	      System.out.printf("Error in opening file for writing\n", "phonebook.txt");
	      System.exit(0);
	    }
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(col == 0)
				{
					out.printf("%s,", data[row][col]);
				}
				else if(col == 1)
				{
					out.printf("%s\n", data[row][col]);
				}
			}
		}
		out.printf("%s,%s\n",new_name,new_number);
		out.close();
	}
	
	public static void printSpreadsheet(String[][] data)
	{
		if(sanity_check(data) == false)
		{
			System.exit(0);
		}
		
		System.out.printf("\n");
		int count = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(col == 0)
				{
					System.out.printf("%4d:%20s,",count,data[row][col]);
					count++;
				}
				else if(col == 1)
				{
					System.out.printf(" %s\n",data[row][col]);
				}
			}
		}
	}
	
	public static void searchData(String[][] data)
	{
		Scanner in = new Scanner(System.in);
		System.out.printf("\nEnter part of the name: ");
		String name = in.nextLine().toLowerCase();
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(col == 0)
				{
					if(data[row][col].toLowerCase().indexOf(name) != -1)
					{
						System.out.printf("%20s: %s\n",data[row][col],data[row][col+1]);
					}
				}
			}
		}
	}
	
  public static String[][] inputNewEntry(String[][] data)
  {
    Scanner in = new Scanner(System.in);
    
    System.out.printf("\nEnter a name: ");
    String name = in.nextLine();
    System.out.printf("\nEnter a number: ");
    String number = in.nextLine();
    savePhonebook(data, name, number);
    data = readPhonebook();
    return data;
  }  
  
  
  public static String[][] processOption(String[][] data, String option)
  {
    if (option.equals("1"))
    {
      printSpreadsheet(data);
    }
    else if (option.equals("2"))
    {
      data = inputNewEntry(data);
    }
    else if (option.equals("3"))
    {
      searchData(data);
    }
    else if (option.equals("q"))
    {
      System.out.printf("Exiting...\n");
      System.exit(0);
    }
    else
    {
      System.out.printf("Unrecognized option %s.\n", option);
    }
    
    return data;
  }
  
  public static String askOption()
  {
    Scanner in = new Scanner(System.in);
    
    System.out.printf("\n1: Print phonebook.\n");
    System.out.printf("2: Input a new entry.\n");
    System.out.printf("3: Search by name.\n");
    System.out.printf("q: Quit program.\n");
    System.out.printf("Please enter an option: ");
    String option = in.next();
    return option;
  }

  
  public static void main(String[] args)
  {
    String[][] data = readPhonebook();
    printSpreadsheet(data);

    while(true)
    {
      String option = askOption();
      data = processOption(data, option);
    }
  }
  
}