import java.util.Scanner;

public class LetterSorting
{
  public static String sortLetters(String text)
  {
	  text = text.toLowerCase();
	  String alphabet = "abcdefghijklmnopqrstuvwxyz";
	  String sort = "";
	  
	  for(int i = 0; i < alphabet.length(); i++)
	  {
		  for(int j = 0; j < text.length(); j++)
		  {
			  if(alphabet.charAt(i) == text.charAt(j))
			  {
				  sort += alphabet.charAt(i);
			  }
		  }
	  }
	  return sort;
  }
	
	
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    while (true)
    {
      System.out.printf("Enter some text, or q to quit: ");
      String text = in.nextLine();
      if (text.toLowerCase().equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      
      String result = sortLetters(text);
      System.out.printf("Result: %s.\n\n", result);
    }
  }
}