public class MatrixSmallest
{
  public static double[][] matrixSmallest(double[][] A, double[][] B)
  {
	  int colsA = A[0].length;
	  int rowsA = A.length;
	  int colsB = B[0].length;
	  int rowsB = B.length;
	  
	  if(rowsA != rowsB || colsA != colsB)
	  {
		  return null;
	  }
	  
	  double[][] result = new double[A.length][A[0].length];
	  for(int i = 0; i < A.length; i++)
	  {
		  for(int j = 0; j < A[0].length; j++)
		  {
			  if(A[i][j] < B[i][j])
			  {
				  result[i][j] = A[i][j];
			  }
			  else
			  {
				  result[i][j] = B[i][j];
			  }
		  }
	  }
	  return result;
  }
	
  public static void printDoubleMatrix(String name, double[][] a)
  {
    if (a == null)
    {
      System.out.printf("%s: null\n", name);    
      return;
    }
    System.out.printf("%s:\n", name);    
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[i].length; j++)
      {
        System.out.printf("%7.1f", a[i][j]);
      }
      System.out.printf("\n");
    }
    System.out.printf("\n");
  }
  
  
  public static void main(String[] args)
  {
    double[][] a = { {3.2, 2.1, 5.3},
                     {8.0, 4.9, 5.7} };
    double[][] b = { {1.1, 2.2, 3.3}, 
                     {4.4, 5.5, 6.6} };
      
    double[][] result = matrixSmallest(a, b);
    printDoubleMatrix("a", a);
    printDoubleMatrix("b", b);
    printDoubleMatrix("result", result);
  }
}