import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class CountAlbums
{
  
  
  public static ArrayList<String> readFile(String filename)
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
      System.exit(0);
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
  
  public static int size(String filename)
  {
	  ArrayList<String> file = readFile(filename);
	  if(file.size() == 0)
	  {
		  System.out.printf("File provided is not valid\n");
		  System.exit(0);
	  }
	  ArrayList<String> bands = new ArrayList<String>();
	  for(int i = 0; i < file.size(); i++)
	  {
		  String band = file.get(i);
		  try
		  {
			  band = band.substring(0,band.indexOf("-")-1);
		  }
		  catch(Exception e)
		  {
			  System.out.printf("File provided is not valid");
			  System.exit(0);
		  }
		  for(int col = 0; col < file.size(); col++)
		  {
			  try
			  {
				  if(bands.get(col).equals(band))
				  {
					  break;
				  }
			  }
			  catch(Exception e)
			  {
				  bands.add(band);
				  break;
			  }
			  /*if(col == file.size()-1 && !(bands.get(col).equals(band)))
			  {
				  bands.add(band);
			  }*/
			  
		  }
	  }
	  return bands.size();
  }
  
  public static void processFile(String filename)
  {
	  int limit = size(filename);
	  //String ArrayList file is an ArrayList with each line in the file as a spot
	  //2D String array counter has two rows, the amount of columns is = to the size of the file ArrayList
	  //The first loop loops through the second row and replaces the nulls with 0s in every spot so they can be incremented later
	  ArrayList<String> file = readFile(filename);
	  String[][] counter = new String[2][limit];
	  ArrayList<String> bands = new ArrayList<String>();
	  for(int col = 0; col < counter[1].length; col++)
	  {
		  counter[1][col] = Integer.toString(0);
	  }
	  
	  //this first loops through the file ArrayList which contains all the band names with their albums
	  //it cuts off every line so the only thing that is left is the band name
	  //then it loops through the counter 2D matrix and tries to find the band in that 2D array
	  //if it finds the band name in the 1st row, it increments the count in row 2 in the same column by one
	  //if it doesn't find the band, it adds the band to the 2D matrix in the 1st row at the i'th column
	  //then it adds 1 to the count in the same column
	  for(int i = 0; i < file.size(); i++)
	  {
		  String band = file.get(i);
		  try
		  {
			  band = band.substring(0,band.indexOf("-")-1);
		  }
		  catch(Exception e)
		  {
			  System.out.printf("This file has incorrect format on at least one line\n");
			  System.exit(0);
		  }
		  
		  for(int col = 0; col < counter[0].length; col++)
		  {
			  try
			  {
				  if(counter[0][col].equals(band))
				  {
					  int count = Integer.parseInt(counter[1][col]);
					  count++;
					  counter[1][col] = Integer.toString(count);
					  break;
				  }  
			  }
			  catch(Exception e)
			  {
				  counter[0][col] = band;
				  int count = Integer.parseInt(counter[1][col]);
				  count++;
				  counter[1][col] = Integer.toString(count);
				  break;
			  }
			  
		  } 
	  }
	  
	  //2D String matrix sorted is created with the 2 rows; the size of the file ArrayList is the amount of columns
	  String[][] sorted = new String[2][limit];
	  
	  for(int i = 0; i < counter[0].length; i++)
	  {
		  int max = 0;
		  for(int col = 0; col < counter[0].length; col++)
		  {
			 /* if(counter[0][col] == null)
			  {
				  continue;
			  }*/
			  int num = Integer.parseInt(counter[1][col]);
			  if(num > max)
			  {
				  max = num;
			  }
		  }
		  for(int col = 0; col < counter[1].length; col++)
		  {
			  if(Integer.parseInt(counter[1][col]) == max)
			  {
				  sorted[0][i] = counter[0][col];	//band
				  sorted[1][i] = counter[1][col];	//counts
				  counter[1][col] = Integer.toString(0);
				  break;
			  }
		  }
	  }
	  
	  for(int list = 0; list < bands.size(); list++)
	  {
		  System.out.printf("%s\n",bands.get(list));
	  }
	  
	  for(int col = 0; col < sorted[0].length; col++)
	  {
		 /* if(sorted[0][col] == null)
		  {
			  continue;
		  }*/
		  System.out.printf("%s : %s\n",sorted[0][col],sorted[1][col]);
	  }
	  
  }
  
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    while (true)
    {
      System.out.printf("Please enter the name of the input file, or q to quit: ");
      String input_name = in.nextLine();
      if (input_name.equals("q"))
      {
        break;
      }

      processFile(input_name);
      System.out.printf("\n");
    }
    
    System.out.printf("Exiting...\n");
  }
}