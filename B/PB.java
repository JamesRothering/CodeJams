import java.util.ArrayList;      
import java.io.FileReader;
import java.io.BufferedReader; 
public class PB
{
  public static void main(String[] argv)
  {
    String aFile = "B-large-practice.in";
    try
    {
      BufferedReader aTestFile = new BufferedReader(new FileReader(aFile));
      int aNumLines = Integer.parseInt(aTestFile.readLine());
//      System.out.println("# of lines of test data:" + aNumLines);
      for (int i = 0; i < aNumLines; i++)
      {
        System.out.print("Case #" + (i+1) + ": ");
        String[] sWord = aTestFile.readLine().split("\\s+");
        for (int j = (sWord.length-1); j >= 0; j--)
        {
          System.out.print(sWord[j] + " ");  
        }//end-for-inner
        System.out.println();
      }//end-for-outer
    }//end-try
    catch(Exception e)
    {
      e.printStackTrace();
    }//end-catch-block
  }//end-main
}//end-class PB

