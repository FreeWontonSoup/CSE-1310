public class PickLargest
{  
  public static double[] pickLargest(double[] A, double[] B)
  {
	  if(A.length != B.length)
	  {
		  return null;
	  }
	  double[] result = new double[A.length];
	  for(int i = 0; i < A.length; i++)
	  {
		  if(A[i] > B[i])
		  {
			  result[i] = A[i];
		  }
		  else{
			  result[i] = B[i];
		  }
	  }
	  return result;
  }
	
  public static void printDoubleArray(String name, double[] a)
  {
    System.out.printf("%7s: ", name);
    if (a == null)
    {
      System.out.printf("Null array!\n\n");
      return;
    }
    
    for (int i = 0; i < a.length; i++)
    {
      System.out.printf("%7.1f", a[i]);
    }
    System.out.printf("\n");
  }
  
  public static void main(String[] args)
  {
    double[] a = {3.2, 2.1, 5.3, 8.0, 4.9, 5.7};
    double[] b = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
      
    double[] result = pickLargest(a, b);
    printDoubleArray("a", a);
    printDoubleArray("b", b);
    printDoubleArray("result", result);
  }
}