import java.io.*;
import java.util.*;
/**
 * Discription : A simple program that solves the ABC Path Puzzle by using backtracking.This Program 
 *               simple read the file which contain the initial state for puzzle and assign these
 *               value and starts to solve the problem.
 * @author     : Nawaraj Subedi
 * @since      : Apr 7,2015
 */ 
public class AbcPuzzle
{
   // Data Field
   private char Matrix[][];
   private String aToz="BCDEFGHIJKLMNOPQRSTUVWXYZ";
   private char empty='\0';
   private int index=0;
   private int row=0,col=0;

  /**
   * A constructor for to initialize the double array and to  called a method for to built 
   * a matrix from the textfile which is passed as an argument in this consructor.
   * @param filename A String which contains the data and that is passed as argument in constructor.
   */
   public AbcPuzzle (String filename)
   {
      
      Matrix = new char[7][7];
      
      /**************************************
       Call the Method to built marrix ******
       *************************************/
      MatrixCreater (filename);
      
      /**************************************
       Call the method to solve the puzzle
       *************************************/
      Abc(aToz.charAt(index),index,row,col);
   }
  /**
   * A boolean method that takes character, and the position of recently add value as argument.
   * If the required condition match for a given value then it assign it in array and recursively 
   * occur and solve the problem in backtracking way.
   * @param alphabet A char value which is need to be assign in array
   * @param k  A int value , position of value.
   * @param i A int which represent the row of recently added char value.
   * @param j A int which represent the column of recently added char value.
   * @return true if the all the value are assigned in array in a correct way.
   */
   public boolean  Abc (char alphabet,int k,int i,int j)
   {
    /*******************************
          Base case for recursion
     ******************************/
      if (alphabet=='Z' )
      {
         return true;
      }
      else
      {
         if(Matrix[i-1][j]==empty)
         {
            if (promissing(alphabet,i-1,j))
            {
               Matrix[i-1][j]=alphabet;
               
            /***************************************
             Recursive Case and Return if success
            **************************************/
               if(Abc(aToz.charAt(k+1),k+1,i-1,j))
               {
                  return true;
               }
            /******************************************
            Unassigned value in if boolean return false
                       backtracking
            ******************************************/
               Matrix[i-1][j]=empty;
            }
         }
         if (Matrix[i+1][j]==empty)
         {
            if (promissing(alphabet,i+1,j))
            {
               Matrix[i+1][j]=alphabet;
               if(Abc(aToz.charAt(k+1),k+1,i+1,j))
               {
                  return true;
               }
               Matrix[i+1][j]=empty;
            }
         } 
         if(Matrix[i+1][j-1]==empty)
         {
            if (promissing(alphabet,i+1,j-1))
            {
               Matrix[i+1][j-1]=alphabet;
            
               if(Abc(aToz.charAt(k+1),k+1,i+1,j-1))
               {
                  return true;
               }
               Matrix[i+1][j-1]=empty;
            } 
         }
         if(Matrix[i+1][j+1]==empty)
         {
            if (promissing(alphabet,i+1,j+1))
            {
               Matrix[i+1][j+1]=alphabet;
               if(Abc(aToz.charAt(k+1),k+1,i+1,j+1))
               {
                  return true;
               }
               Matrix[i+1][j+1]=empty;
            }
         }
         if(Matrix[i][j+1]==empty)
         {
            if (promissing(alphabet,i,j+1))
            {
               Matrix[i][j+1]=alphabet;
               if(Abc(aToz.charAt(k+1),k+1,i,j+1))
               { 
                  return true;
               }
               Matrix[i][j+1]=empty;
            }
         }
         if(Matrix[i-1][j+1]==empty)
         {
            if (promissing(alphabet,i-1,j+1))
            {
               Matrix[i-1][j+1]=alphabet;
               if (Abc(aToz.charAt(k+1),k+1,i-1,j+1))
               {
                  return true;
               }
               Matrix[i-1][j+1]=empty;
            }
         }
         if(Matrix[i-1][j-1]==empty)
         {
            if (promissing(alphabet,i-1,j-1))
            {
               Matrix[i-1][j-1]=alphabet;
               if (Abc(aToz.charAt(k+1),k+1,i-1,j-1))
               {
                  return true;
               }
               Matrix[i-1][j-1]=empty;
            }
         }
         if(Matrix[i][j-1]==empty)
         {
            if (promissing(alphabet,i,j-1))
            {
               Matrix[i][j-1]=alphabet;
               if (Abc(aToz.charAt(k+1),k+1,i,j-1))
               {  
                  return true;
               }
               Matrix[i][j-1]=empty;
            }
         }
      }
      return false;
   }    
  /**
   * Returns a boolean which indicates whether it will be legal to assign char to the
   * given row or col location.
   * @return promised true if it was legal to assign in this place.
   */ 
   public boolean promissing (char checked,int x,int y)
   {
      boolean promised =false;
      /**************************************************
        Horizontal value checked for given place 
       *************************************************/
       
      if ((checked==Matrix[x][0])||(checked==Matrix[x][6]))
      {
         promised=true;
      }
   
      /**************************************************
       **** Vertical values checked for given place******
       *************************************************/
      if (((checked==Matrix[0][y]))||((checked==Matrix[6][y])))
      {
         promised=true;
      }
      
     /*************************************************
      **For to check diagonal main diagonal ***********
      *************************************************/
      
      if (x==y)
      {
         if ((checked==Matrix[0][0])||(checked==Matrix[6][6]))
         {
            promised=true;
         }
      }
      /************************************************
      ** For to check diagonal from right to left******
      ************************************************/
      int colIndex=5;
      for ( int rowIndex=1;rowIndex<6;rowIndex++)
      { 
         if ((rowIndex==x)&&(colIndex==y))
         {
            if ((checked==Matrix[0][6])||(checked==Matrix[6][0]))
            {
               promised=true;
            }
         }
         colIndex--;
                    
      }
      
      return promised;
   }
  /**
   * A void method that display the double char array in the form of matrix with
   * complete solution
   */
   public void display()
   {
      for (int row = 0; row <Matrix.length; row++) 
      {
         for (int col = 0; col <Matrix[row].length; col++) 
         {
            System.out.print("  "+ Matrix[row][col]);
         }
         System.out.println();
      }
   }
  /**
   * A method for to return the solution as a string which represent the
   * contents of the matrix in row-major order  
   * @return reQuired A string which contains the contens of the matrix in row-major order.
   */
   public String toString ()
   {
      String reQuired="";
      int rowLength= Matrix.length-2;
      int columnLength=Matrix[rowLength].length-2;
      for (int row = 1; row <=rowLength; row++) 
      {
         for (int col = 1; col <=columnLength; col++) 
         {
            reQuired+=Matrix[row][col];
         }
      }
      return reQuired;
   }
   /**
    * A void method to create a matrix from the file which is passed as an argument.
    * if something error in file it throw an exception else it will built the matrix
    * @param textfile A string which contains the specification about matrix to be bulding.
    */
   public void MatrixCreater ( String textfile)
   {
      try
      {
         File infile=new File (textfile);
         Scanner sc=new Scanner(infile);
         
         /***************************************************
          loop execute if more line is available for to read  
         ***************************************************/ 
         while(sc.hasNextLine())
         {
         /*************************************************
                  Read Next line from the file 
          ************************************************/
            String line =sc.nextLine();
            if(line.length()==7)
            { 
               for (int n=0;n<line.length();n++)
               { 
                  char a= line.charAt(n);
                  Matrix[row][n]=a;
               }
               row++;
            }
            if ((line.length()==2)||(line.length()==3))
            {
               if (line.length()==2)
               {               
                  Matrix[row][0]=line.charAt(0);
                  Matrix[row][6]=line.charAt(1);
                  row++;
               }
               else
               {
                  Scanner read=new Scanner(line);
                  row=Integer.parseInt(read.next());
                  col=Integer.parseInt(read.next());
                  Matrix[row][col]='A';
               }
            }  
         
         }
      }
                     
      catch(FileNotFoundException e)
      {
      //************************************
      //prints the stack trace to System.err
      //************************************
         e.printStackTrace();
      }
   
   }
}