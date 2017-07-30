import java.util.*;

public class ListFooR
{
  public static void printStringList(ArrayList<String> a)
  {
    for (int i = 0; i < a.size(); i++)
    {
      System.out.printf("%10s", a.get(i));
    }
    System.out.printf("\n");
  }
  
  public static void foo(ArrayList<String> x, ArrayList<String> y)
  {
    for (int i = 0; i < x.size(); i++)
    {
      String current = x.get(i);
      if (current.equals("tx"))
      {
        x.set(i, "Texas");
      }
    }

    y.add("hello");
    y.add("world");
    
    y = new ArrayList<String>();
    y.add("goodbye");
  }
  
  public static void main(String[] args)
  {
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = a;
    ArrayList<String> c = new ArrayList<String>();
    ArrayList<String> d = c;

    a.add("fort");
    a.add("worth");
    a.add("tx");
    
    c.add("june");
    c.add("july");
    c.add("august");

    foo(b, d);
    printStringList(a);
    printStringList(c);
  }
}