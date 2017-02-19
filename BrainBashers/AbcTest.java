/**
   Main method to test the methods of the AbcPuzzle class.  
   
*/ 
public class AbcTest  
{
   public static void main(String[] args) 
   {
      AbcPuzzle abc1 = new AbcPuzzle("abcpuzzle1.txt");
      abc1.display();
      if (abc1.toString().equals("VUSOPWTNRQXLMCAKYHDBJIGFE"))
         System.out.println("Problem 1 solved!!\n");
         
      AbcPuzzle abc2 = new AbcPuzzle("abcpuzzle2.txt");
      abc2.display();
      if (abc2.toString().equals("WVRQOXSUPNYTGHMACFLIBEDKJ"))
         System.out.println("Problem 2 solved!!");
   }
}