import java.util.Scanner;
import java.io.*;

public class FactoryProblem {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter your file name");
      String fileName = in.nextLine();

      try {
         in = new Scanner(new File(fileName));   
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
         int n = in.nextInt();
         int e1 = in.nextInt();
         int e2 = in.nextInt();
         int x1 = in.nextInt();
         int x2 = in.nextInt();
         int[] a1 = new int[n];
         for (int i = 0; i < n; i++) {
            a1[i] = in.nextInt();
         }

         int[] a2 = new int[n];
         for (int i = 0; i < n; i++) {
            a2[i] = in.nextInt();
         }

         int[] t1 = new int[n - 1];
         int[] t2 = new int[n - 1];
         for (int i = 0; i < n - 1; i++) {
            t1[i] = in.nextInt();
         }

         for (int i = 0; i < n - 1; i++) {
            t2[i] = in.nextInt();
         }
         //TO DO: FINISH THIS
   }
}
