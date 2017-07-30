import java.util.*;

public class ListLargest
{
  public static ArrayList<Double> listLargest(ArrayList<Double> A, ArrayList<Double> B)
  {
	  if(A.size() != B.size())
	  {
		  return null;
	  }
	  ArrayList<Double> result = new ArrayList<Double>();
	  for(int i = 0; i < A.size(); i++)
	  {
		  if(A.get(i) > B.get(i))
		  {
			  result.add(A.get(i));
		  }
		  else
		  {
			  result.add(B.get(i));
		  }
	  }
	  return result;
  }
	
  public static void printDoubleList(String name, ArrayList<Double> a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.size(); i++)
    {
      System.out.printf("%7.1f", a.get(i));
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    ArrayList<Double> a = new ArrayList<Double>();
    a.add(3.2);
    a.add(2.1);  
    a.add(5.3);  
    a.add(8.0);  
    a.add(4.9);  
    a.add(5.7);  

    ArrayList<Double> b = new ArrayList<Double>();
    b.add(1.1);
    b.add(2.2);  
    b.add(3.3);  
    b.add(4.4);  
    b.add(5.5);  
    b.add(6.6);  
      
    ArrayList<Double> result = listLargest(a, b);
    printDoubleList("a", a);
    printDoubleList("b", b);
    printDoubleList("result", result);
  }
}