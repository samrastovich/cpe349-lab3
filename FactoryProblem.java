/* Authors: Matt Bryan and Sam Rastovich
 * IDs: mpbryan & srastovi
 * Date: 2-13-17
 * Assignment name: Project 3 - part 1*/

import java.util.Scanner;
import java.io.*;

public class FactoryProblem {
   public static void findTime(int n, int e1, int e2, int x1, int x2, int[] a1, int[] a2, int[] t1, int[] t2) {
      //Should return the fastest time to exit the assembly lines
      int[][] times = new int[2][n];
      int[][] paths = new int[2][n];
      int[] printPath = new int[n];
      int exitPath, exitTime, printLine;

      //Entry onto assembly lines
      times[0][0] = e1 + a1[0];
      times[1][0] = e2 + a2[0];

      //Finding the shortest path
      for (int i = 1; i < n; i++) {
         times[0][i] = min(times[0][i - 1] + a1[i], times[1][i - 1] + t2[i - 1] + a1[i], paths, 0, i);
         times[1][i] = min(times[0][i - 1] + t1[i - 1] + a2[i], times[1][i - 1] + a2[i], paths, 1, i);
      }

      //Finding the exit path and time
      if (times[0][n - 1] + x1 < times[1][n - 1] + x2) {
         exitTime = times[0][n - 1] + x1;
         exitPath = 1;
      }
      else {
         exitTime = times[1][n - 1] + x2;
         exitPath = 2;
      }

      //Going backwards through paths to find optimal route

      if (exitPath == 1) {
         printLine = 0;
         printPath[5] = 1;
      }
      else {
         printLine = 1;
         printPath[5] = 2;
      }
      for (int i = 5; i > 0; i--) {
         if (paths[printLine][i] == 1) {
            printLine = 0;
            printPath[i - 1] = 1;
         }
         else {
            printLine = 1;
            printPath[i - 1] = 2;
         }
      }

      System.out.println("\nFastest time is: " + exitTime + "\n");
      System.out.println("The optimal route is:");
      for (int i = 0; i < printPath.length; i++) {
         System.out.println("Station " + (i + 1) + ", line " + printPath[i]);
      }
   }

   private static void printTable(int[][] table) {
      for (int i = 0; i < 2; i++) {
         for (int j = 0; j < table[0].length; j++) {
            System.out.print(table[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static int min(int line1, int line2, int[][] paths, int lineNum, int station) {
      if (line1 < line2) {
         paths[lineNum][station] = 1;
         return line1;
      }
      else {
         paths[lineNum][station] = 2;
         return line2;
      }
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

         findTime(n, e1, e2, x1, x2, a1, a2, t1, t2);
   }
}
