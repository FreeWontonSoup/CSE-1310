public class ArrayFooR
{
  public static void printIntMatrix(String name, int[] a)
  {
    System.out.printf("%5s: ", name);
    for (int i = 0; i < a.length; i++)
    {
      System.out.printf("%7d", a[i]);
    }
    System.out.printf("\n");
  }
  
  public static void foo(int[] x, int[] y)
  {
    for (int i = 0; i < x.length; i++)
    {
      x[i] = 100 + x[i];
    }
  
    int[] q = {1, 2, 3};
    y = q;
  }
  
  public static void main(String[] args)
  {
    int[] a = {3, 2, 5};
    int[] b = a;
    int[] c = {3, 2, 5};
    int[] d = c;
      
    foo(b, d);
    printIntMatrix("a", a);
    printIntMatrix("c", c);
  }
}