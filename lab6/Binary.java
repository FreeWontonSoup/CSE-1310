import java.util.Scanner;

public class Binary
{
  public static int binaryToDecimal(String text)
  {
    // handle minus sign at the front.
    int sign = 1;
    if (text.charAt(0) == '-')
    {
      sign = -1;
      text = text.substring(1);
    }
    int result = 0;
    String digits = "01";
    for (int i = 0; i < text.length(); i++)
    {
      String c = text.substring(i, i+1);
      int digit = digits.indexOf(c);
      if (digit == -1)
      {
        System.out.printf("Error: invalid binary number %s, exiting...\n", text);
        System.exit(0);
      }
      int power = (int) (Math.pow(2, text.length() - i - 1));
      result = result + digit * power;
    }
    
    // if the first character of text was a minus, then negate the result.
    result = sign * result;
    return result;
  }
  
  public static String decimalToBinary(int number)
  {
    // handle case where number is negative
    String start = "";
    if (number < 0)
    {
      start = "-";
      number = -number;
    }
    
    String result = "";
    while(true)
    {
      int remainder = number % 2;
      String digit = Integer.toString(remainder);
      result = digit + result;
      number = number / 2;
      if (number == 0)
      {
        break;
      }
    }
    
    // if number is negative, put a minus sign in front of the result.
    result = start + result;
    return result;
  }


  public static boolean checkValid(String text)
  {
    // should have nonzero length
    if (text.length() == 0)
    {
      return false;
    }
    // should only have characters 0, 1, +, -.
    int counter = 0; // will count occurrences of + and - characters
    for (int i = 0; i < text.length(); i++)
    {
      char c = text.charAt(i);
      if ("01+-".indexOf(c) < 0)
      {
        return false;
      }      
      if ("+-".indexOf(c) >= 0)
      {
        counter++;
      }
    }
      
    // should only have one occurrence of a + or - character
    if (counter != 1)
    {
      return false;
    }
    
    // the operator (+ or - character) should not be at the beginning
    // or end of the string
    char start = text.charAt(0);
    char end = text.charAt(text.length() - 1);
    if ("01".indexOf(start) < 0)
    {
      return false;
    }
    if ("01".indexOf(end) < 0)
    {
      return false;
    }
              
    return true;
  }

  
  public static int findOperatorPosition(String text)
  {
	  String operator = "-+";
	  for(int i = 0; i < text.length(); i++)
	  {
		  if(operator.indexOf(text.charAt(i)) != -1)
		  {
			  return i;
		  }
	  }
	return 0;
  }
  
  public static char findOperatorSymbol(String text)
  {
	return text.charAt(findOperatorPosition(text));
  }
  
  public static String getFirstNumber(String text)
  {
	  return text.substring(0, findOperatorPosition(text));
  }
  
  public static String getSecondNumber(String text)
  {
	  return text.substring(findOperatorPosition(text)+1);
  }
  
  public static String computeBinaryOperation(String text)
  {
	
	  
    String s1 = getFirstNumber(text);
    String s2 = getSecondNumber(text);
    int num1 = binaryToDecimal(s1);
    int num2 = binaryToDecimal(s2);
    int result = 0;
    
    if(findOperatorSymbol(text) == '-')
    {
    	result = num1 - num2;
    }
    else
    {
    	result = num1 + num2;
    }
    String binary = decimalToBinary(result);
    return binary;
  }
  
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    
    while (true)
    {
      System.out.printf("Please enter your input, or q to quit: ");
      String text = in.nextLine();      
      if (text.toLowerCase().equals("q"))
      {
        break;
      }
      if (checkValid(text) == false)
      {
        System.out.printf("Error: invalid input, please try again.\n\n");
        continue;
      }
      
      int position = findOperatorPosition(text);
      char symbol = findOperatorSymbol(text);
      String first = getFirstNumber(text);
      String second = getSecondNumber(text);
      String result = computeBinaryOperation(text);
      System.out.printf("operator position = %d\n", position);
      System.out.printf("operation = %c\n", symbol);
      System.out.printf("the first number is %s\n", first);
      System.out.printf("the second number is %s\n", second);
      System.out.printf("result = %s\n\n", result);
    }
    System.out.println("Exiting...");
  }
}