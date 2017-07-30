import java.util.Scanner;

public class PrintCoded
{
  public static void printCoded(String word, String sources, String targets)
  {
	  char c;
	  for(int i = 0; i < word.length(); i++)
	  {
		  for(int j = 0; j < sources.length(); j++)
		  {
			  if(word.charAt(i) == sources.charAt(j))
			  {
				  c = targets.charAt(j);
				  System.out.printf("%c", c);
			  }
			  else if((sources.indexOf(word.charAt(i)) == -1) && (j == sources.length()-1))
			  {
				  System.out.printf("%c", word.charAt(i));
			  }
		  }
	  }
  }
	
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    String sources = "abcdefghijklmnopqrstuvwxyz";
    String targets = "bcdefghijklmnopqrstuvwxyza";
    
    while (true)
    {
      System.out.printf("Enter some word, or q to quit: ");
      String word = in.next();
      if (word.equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      printCoded(word, sources, targets);
      System.out.printf("\n\n");
    }
  }
}