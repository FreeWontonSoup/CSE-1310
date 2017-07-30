public class ArrayMerge
{
  public static String[] arrayMerge(String[] A, String[] B)
  {
	  String[] result = new String[A.length + B.length];
	  int track = 0;
	  for(int i = 0; i < A.length; i++)
	  {
		  result[i] = A[i];
		  track++;
	  }
	  for(int i = 0; i < B.length; i++)
	  {
		  result[track] = B[i];
		  track++;
	  }
	  return result;
  }
	
  public static void printStringArray(String name, String[] a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.length; i++)
    {
      System.out.printf("%12s", a[i]);
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    String[] a = {"Chicago", "New York", "Dallas"};
    String[] b = {"Berlin", "London", "Paris", "Rome"};
      
    String[] result = arrayMerge(a, b);
    printStringArray("a", a);
    printStringArray("b", b);
    printStringArray("result", result);
  }
}