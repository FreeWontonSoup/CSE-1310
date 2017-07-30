import java.util.Scanner;

public class CountWords
{
  public static int countWords(String text)
  {
	  int count = 0;
	  if(text.charAt(0) == ' ')
	  {
		  count = 0;
	  }
	  else
	  {
		  count = 1;
	  }
	  
	  for(int i = 1; i < text.length(); i++)
	  {
		  if(text.charAt(i) != ' ' && text.charAt(i-1) == ' ')
		  {
			  count++;
		  }
	  }
	  return count;
  }
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    while (true)
    {
      System.out.printf("Enter some text, or q to quit: ");
      String text = in.nextLine();
      if (text.equals("q"))
      {
        System.out.printf("Exiting...\n");
        break;
      }
      int result = countWords(text);
      System.out.printf("Counted %d words.\n\n", result);
    }
  }
}