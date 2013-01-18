import java.util.Arrays;
public class Perm
{
  public static void main(String[] argv)
  {
    int[] aTest      = new int[] {1,2,3};

//problem test case:
//    int[] aTestResult = insert(aTest, 99, 7);
//but this case pushes the intent of the method. It should just be prohibited as a parm and issue an error

    int[][] aTestResults = getPermutations(aTest);
    
    printArray(aTestResults);
  }//end-main

  static int[][] getPermutations(int[] aArray)
  { //recursive method
    int[][] aReturn = new int[factorial(aArray.length)][aArray.length];
    int[]   aShorterArray = new int[aArray.length-1];
    if (2 == aArray.length)
    {//base case
     // first initialize the 2-D return array with copies of the original array
System.out.println("in the base case now");
      for (int i=0; i<aArray.length;i++)
      {
        aReturn[i] = Arrays.copyOf(aArray,aArray.length);
      }//end-for
      //then permute the array values
      for (int i =1; i< 2; i++)
        swap(aReturn, 1,0, 1,1);
//here be a return
      return aReturn;
    }//end-then
    else //the recursive cases
    {
      //if the array is 3, we loop three times copying the 2-D array thrice
      //  i is our outer factorial amount (i.e., "3" in a 3! situation
      //  j, however, keeps track of the full 6 elements we have to init
System.out.println("in the recursive cases now");
      for (int i =0, j=0; j < factorial(aArray.length); j++,i++)
      {
        if (i >= aArray.length-1) i=0; //reset this for the next batch of copies  
System.out.println("got here, j=" + j + " " + aReturn[j].length);
        aReturn[j] = Arrays.copyOf(aArray,aArray.length);
      }//end-for
      //now we need to move things around to make the permutations
      //now we need to return the value
        //so we truncate the first value of the array
        //  and recursively call the function 
        aShorterArray = Arrays.copyOf(aArray,aArray.length-1);
//    }//end-else

      printArray(aShorterArray);
      return getPermutations(aShorterArray);
      }//end-else
//return aReturn;

  }//end-permute

  static int[] insert(int[] aArray, int aElement, int aPosition)
  {
    int[] aNewArray = new int[aArray.length + 1];
    if (0 == aPosition)
    {
      aNewArray[0] = aElement;
      for (int i = 0; i < aArray.length; i++)
      {                                                 
        aNewArray[i+1] = aArray[i];
      }//end-for
    }//end-then
    else
    {
      int i; //we need to use i after the loop
      for (i = 0; i < aPosition; i++)
      {
System.out.println("aNewArray[" + i +"]=" + aNewArray[i] +
                   " aArray[" + i + "]=" + aArray[i]);
        aNewArray[i] = aArray[i];
      }//end-for
      //then put in the insertion element
      int j = i; //we'll use j to track where we are in aNewArray;
                 //  remember, i got incremented in the above loop causing the
                 //  loop condition to fail, so it now equals aPosition
      assert (j == aPosition);
System.out.println("aElement=" + aElement + " j=" + j + " aPosition=" + aPosition);
      aNewArray[j]= aElement;
      //finally, we carry on copying the remainder of the array
      //  but we can't wipe out the j element we just wrote so we increment
      j++;
      for (/*i&j already set*/ ;
           i < aArray.length;
           i++,j++)
      {
        aNewArray[j] = aArray[i];
      }//end-for
    }//end-else
    return aNewArray;
  }//end-method insert

  static int factorial(int aNum)
  {
    if (1 == aNum) return aNum;
    else
      return ( (aNum)*(factorial(aNum-1)) );
  }//end-method factorial

  static void printArray(int[] aArray)
  {
    for (int i = 0 ; i < aArray.length; i++)
    {
      System.out.print(aArray[i] + " ");
    }//end-for
    System.out.println();
  }//end-method printArray
  static void printArray(int[][] aArrayOfArrays)
  {
    for (int i = 0; i < aArrayOfArrays.length; i++)
    {
      printArray(aArrayOfArrays[i]);
    }//end-for
  }//end-method printArray
  static void swap (int[][] a2DArray, int aX1,int aY1, int aX2, int aY2)
  {
    int aTempElement1  = a2DArray[aX1][aY1];
    a2DArray[aX1][aY1] = a2DArray[aX2][aY2];
    a2DArray[aX2][aY2] = aTempElement1;
  }//end-method swap
}//end-class Perm

