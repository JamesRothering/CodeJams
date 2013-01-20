import java.io.*;
public class PA
{
  

  public static void main(String[] argv)
  {
    try
    {
      // First load the Number of test cases, and the Credit, and price data
      BufferedReader aTestData = new BufferedReader(new FileReader("A-large-practice.in"));
      int aNumCases = Integer.parseInt(aTestData.readLine());
//      System.out.println("Number of Test Cases: " + aNumCases);
//need a for loop here
      for (int h = 0; h < aNumCases; h++)
      {
        int aCredit       = Integer.parseInt(aTestData.readLine());
//        System.out.println("Amount of Credit: " + aCredit);
        int aNumPrices    = Integer.parseInt(aTestData.readLine());
//        System.out.println("Number of Prices: " + aNumPrices);
        String[] sPrices1 = (aTestData.readLine()).split("\\s");
        int[] sPrices2 = new int[sPrices1.length];
        for (int i = 0; i < aNumPrices; i++)
        {
          sPrices2[i] = Integer.parseInt(sPrices1[i]);
//          System.out.println("price #" + i + " = " + sPrices2[i]);
        }//end-for

        //Now find the two prices that exactly match up to the credit
        for (int i = 0; i < aNumPrices; i++)
        {
          for (int j = i+1 ; j < aNumPrices; j++)
          {
//  System.out.println("i=" + i + " j=" + j + " sPrices2[i]=" +
//                     sPrices2[i] + "sPrices2[j]=" + sPrices2[j]);
            if (aCredit == sPrices2[i]+sPrices2[j])
            {
              //we must display the lower index FIRST, so
              //  we much check & possibly reverse the order
              if (i > j)
              {
                //answer must not be zero indexed, so we have to increment
                System.out.println("Case #" + (h+1) + ": " + (j+1) + " " + (i+1));
              }
              else
              {
                //answer must not be zero-indexed, so we have to increment
                System.out.println("Case #" + (h+1) + ": " + (i+1) + " " + (j+1));
              }//end-else
            }//end-if
          }//end-for-inner
        }//end-for-outer
      }//end-for-outermost
    }//end-try
    catch(Exception e)
    {
      e.printStackTrace();
    }//end-catch-block
  }//end-main
}//end-class PA

