import java.util.Scanner;
import java.io.*;

public class FactoryProblem {
   public static int findTime(int n, int e1, int e2, int x1, int x2, int[] a1, int[] a2, int[] t1, int[] t2) {
      //Should return the fastest time to exit the assembly lines
      int[][] times = int[2][n];
      int[][] paths = int[2][n];

      times[0][0] = e1 + a1[0];
      times[1][0] = e2 + a2[0];

      for (int i = 1; i < n; i++) {
         times[0][i] = min(times[0][i - 1] + a1[i], times[1][i - 1] + t1[i] + a2[i]);
         times[1][i] = min(times[1][i - 1] + a2]i], times[0][i - 1] + t2[i] + a1[i]);
      }
   }

   private static int min(int a, int b) {
      return (a < b ? a : b);
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter your file name");
      String fileName = in.nextLine();

      try {
         in = new Scanner(new File(fileName));   
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.out.println("File does not exist");
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
