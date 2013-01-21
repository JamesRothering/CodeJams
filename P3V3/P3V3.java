import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class P3V3
{
  private static List<Child> sChild = new ArrayList<Child>();

  public static synchronized void addChild(Child aNewChild)
  {
    sChild.add(aNewChild);
    System.out.println("added a new Child to track");
  }//end-method addChild

  public synchronized static List<Child> getChildren()
  {
    List<Child> aRetList = new ArrayList<Child>();
    for (Child aChild: P3V3.sChild)
    {
      aRetList.add(aChild);
    }//end-for
    return aRetList;
  }//end-method getChildren

  public static void main(String[] argv)
  {
    System.out.println("adding children");
    Child aChild = new Child(new int[]{1,2,3},new int[]{4,5,6});
System.out.println("about to enter the for loop");
System.out.println("length=" + P3V3.sChild.size());
//    for (Child aChild2: P3V3.sChild)
    for (Child aChild2: P3V3.getChildren() )
    {
System.out.println("in the for loop, about to mutate");
      aChild2.mutate();
      aChild2.print();
    }//end-for
//   ((Child) aChild.mutate()).print();
  }//end-main
}//end-class P3V3

class Child
{
  int[] aArray1;
  int[] aArray2;

  Child()
  {
    P3V3.addChild(this);
    System.out.println("in the child constructor, about to addChild");
  }//end-constructor

  Child(int[] aArray1, int[] aArray2)
  {
    this();
    this.aArray1 = aArray1;
    this.aArray2 = aArray2;
  }//end-constructor

  public void mutate()
  {
//     System.out.println(System.time);
    System.out.println("entered Mutate");
     Random aRandom = new Random(654321);
     int    aFirst  = aRandom.nextInt(this.aArray1.length);
     int    aSecond = aRandom.nextInt(this.aArray1.length);
     int    aThird  = aRandom.nextInt(this.aArray2.length);
     int    aFourth = aRandom.nextInt(this.aArray2.length);
     swap(aArray1,aFirst,aSecond);
     swap(aArray2,aThird,aFourth);
     P3V3.addChild(this);
  }//end-method mutate

  public void swap(int[] aArray, int aOne, int aTwo)
  {
System.out.println("aArray[aOne]=" + aArray[aOne]);
System.out.println("aArray[aTwo]=" + aArray[aTwo]);
    int aSave        = aArray[aOne];
        aArray[aOne] = aArray[aTwo];
        aArray[aTwo] = aSave;
  }//end-method swap

  public void print()
  {
    for (int i = 0; i < this.aArray1.length; i++)
    {
      System.out.print(this.aArray1[i] + " ");
    }//end-for
    System.out.println();
    for (int i = 0; i < this.aArray2.length; i++)
    {
      System.out.print(this.aArray2[i] + " " );
    }//end-for
    System.out.println();
  }//end-print
}//end-class Child
