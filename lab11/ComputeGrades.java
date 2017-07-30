
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class ComputeGrades
{
	public static void processGrades(String input_name, String csv_name, String pretty_name)
	{
		csv(input_name, csv_name);
		pretty(csv_name, pretty_name);
	}
	
	public static void pretty(String csv_name, String pretty_name)
	{
		PrintWriter out = null;

		try
	    {
	      out = new PrintWriter(pretty_name);
	    }
	    catch (Exception e)
	    {
	      System.out.printf("Error in opening %s for writing\n", pretty_name);
	      System.exit(0);
	    }
		String[][] matrix = readSpreadsheet(csv_name);
		
		sanity_check(matrix);
		
		String n = "name";
		out.printf("%20s: exam score, hw score, min score, grade\n",n);
		for(int row = 1; row < matrix.length; row++)
		{
			String name = matrix[row][0];
			String exam_scoreS = matrix[row][1];
			double exam_score = Double.parseDouble(exam_scoreS);
			String hw_scoreS = matrix[row][2];
			double hw_score = Double.parseDouble(hw_scoreS);
			String min_scoreS = matrix[row][3];
			double min_score = Double.parseDouble(min_scoreS);
			String grade = matrix[row][4];
			
			out.printf("%20s: %10.2f, %8.2f, %9.2f, %s\r\n", name, exam_score, hw_score, min_score, grade);
		}
		out.close();
	}
	
	public static void csv(String input_name, String csv_name)
	{
		PrintWriter out = null;

		try
	    {
	      out = new PrintWriter(csv_name);
	    }
	    catch (Exception e)
	    {
	      System.out.printf("Error in opening %s for writing\n", csv_name);
	      System.exit(0);
	    }
		String[][] matrix = readSpreadsheet(input_name);
		
		sanity_check(matrix);
		
		out.printf("name,exam_score,hw_score,min_score,grade\n");
		for(int row = 1; row < matrix.length; row++)
		{
			int total = 0;
			int count = 0;
			String firstName = matrix[row][0];
			out.printf("%s ", firstName);
			String lastName = matrix[row][1];
			out.printf("%s,", lastName);
			for(int cols = 2; cols < 5; cols++)
			{
				String numS = matrix[row][cols];
				try
				{
					int num = Integer.parseInt(numS);
					total += num;
					count++;
				}
				catch(Exception e)
				{
					System.out.printf("Non-number found: %s. row = %d, col = %d\n",numS,row,cols);
					System.out.printf("Sanity check failed.\n\n");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			double examAvg = (double)total / (double)count;
			//String examAvgS = Double.toString(examAvg);
			out.printf("%.6f,", examAvg);
			int totalHW = 0;
			int countHW = 0;
			for(int col = 5; col < matrix[row].length; col++)
			{
				String numS = matrix[row][col];
				try
				{
					int num = Integer.parseInt(numS);
					totalHW += num;
					countHW++;
				}
				catch(Exception e)
				{
					System.out.printf("Non-number found: %s. row = %d, col = %d\n",numS,row,col);
					System.out.printf("Sanity check failed.\n\n");
					System.out.printf("Exiting...");
					System.exit(0);
				}
			}
			double hwAvg = (double)totalHW / (double)countHW;
			//String hwAvgS = Double.toString(hwAvg);
			out.printf("%.6f,", hwAvg);
			if(hwAvg < examAvg)
			{
				out.printf("%.6f,", hwAvg);
				if(hwAvg > 89)
				{
					out.printf("A\n");
				}
				else if(hwAvg > 79)
				{
					out.printf("B\n");
				}
				else if(hwAvg > 69)
				{
					out.printf("C\n");
				}
				else if(hwAvg > 59)
				{
					out.printf("D\n");
				}
				else
				{
					out.printf("F\n");
				}
			}
			else
			{
				out.printf("%.6f,",examAvg);
				if(examAvg > 89)
				{
					out.printf("A\n");
				}
				else if(examAvg > 79)
				{
					out.printf("B\n");
				}
				else if(examAvg > 69)
				{
					out.printf("C\n");
				}
				else if(examAvg > 59)
				{
					out.printf("D\n");
				}
				else
				{
					out.printf("F\n");
				}
			}
		}
		out.close();
	}
	
	public static void sanity_check(String[][] data)
	 {
	   if (data == null)
	   {
	     System.out.printf("Sanity check: null data\n");
	     System.out.printf("Sanity check failed.\n\n");
	     System.out.printf("Exiting...");
	     System.exit(0);
	   }
	      
	   // make sure the file is not empty.
	   if (data.length < 2)
	   {
	     System.out.printf("Sanity check: %d rows\n",data.length);
	     System.out.printf("Sanity check failed.\n\n");
	     System.out.printf("Exiting...");
	     System.exit(0);
	   }
	 }
	
  public static String[][] readSpreadsheet(String filename)
  {
    ArrayList<String> lines = readFile(filename);
    if (lines == null)
    {
      return null;
    }

    int rows = lines.size();
    String[][] result = new String[rows][];

    for (int i = 0; i < rows; i++)
    {
      String line = lines.get(i);
      String[] values = line.split(",");
      result[i] = values;
    }

    return result;
  }

  public static ArrayList<String> readFile(String filename)
  {
    File temp = new File(filename);
    Scanner input_file;

    try
    {
      input_file = new Scanner(temp);
    } catch (Exception e)
    {
      System.out.printf("Failed to open file %s\n",
              filename);
      return null;
    }

    ArrayList<String> result = new ArrayList<String>();
    while (input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      result.add(line);
    }

    input_file.close();
    return result;
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.printf("Please enter the name of the input file: ");
    String input_name = in.next();
    System.out.printf("Please enter the name of the output CSV file: ");
    String csv_name = in.next();
    System.out.printf("Please enter the name of the output pretty-print file: ");
    String pretty_name = in.next();

    processGrades(input_name, csv_name, pretty_name);
    System.out.printf("\nExiting...\n");
  }
}