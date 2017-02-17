/* Authors: Matt Bryan and Sam Rastovich
 * IDs: mpbryan and srastovi
 * Date: 2-15-17
 * Assignment: Project 3 Part 2 (GameProblem)  */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameProblem {
   private static final char EXIT = 'e';
   private static final char RIGHT = 'r';
   private static final char LEFT = 'l';
   private static final char DOWN = 'd';
   private static final char UP = 'u';

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n][m];
      char[][] R = new char[n][m];
      int[] maxRes;
      
      for (int i = n - 1; i >= 0; i--) {
         for (int j = m - 1; j >= 0; j--) {
            if (i == n - 1 && j == m - 1) {
               R[i][j] = EXIT;
               S[i][j] += A[i][j];
            }
            else if (j == m - 1) {
               maxRes = max(S[i + 1][j], 0);
               S[i][j] += (maxRes[0] + A[i][j]);
               if (maxRes[1] == 0) {
                  R[i][j] = DOWN;
               }
               else {
                  R[i][j] = EXIT;
               }
            }
            else if (i == n -1) {
               maxRes = max(S[i][j + 1], 0);
               S[i][j] += (maxRes[0] + A[i][j]);
               if (maxRes[1] == 0) {
                  R[i][j] = RIGHT;
               }
               else {
                  R[i][j] = EXIT;
               }
            }
            else {
               maxRes = max(S[i + 1][j], S[i][j + 1]);
               S[i][j] += (maxRes[0] + A[i][j]);
               if (maxRes[1] == 0) {
                  R[i][j] = DOWN;
               }
               else {
                  R[i][j] = RIGHT;
               }
            }
         }
      }

      printResult(S,R);
   }

   private static void printResult(int[][] S, char[][] R) {
      int max = S[0][0], curRow = 0, curCol = 0;
      for (int i = 0; i < S.length; i++) {
         for (int j = 0; j < S[0].length; j++) {
            if (S[i][j] > max) {
               max = S[i][j];
               curRow = i;
               curCol = j;
            }
         }
      }

      System.out.println("Best score: " + max);
      System.out.print("Best route: [" + (curRow + 1) + "," + (curCol + 1) + "] to ");

      while (R[curRow][curCol] != EXIT) {
         if (R[curRow][curCol] == RIGHT) {
            curCol++;
         }
         else {
            curRow++;
         }
         System.out.print("[" + (curRow + 1) + "," + (curCol + 1) + "] to ");
      }
      System.out.println("exit");
   }

   private static void printIntMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static void printCharMatrix(char[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }
   
   private static int[] max(int first, int second) {
      int[] res = new int[2];

      if (first > second) {
         res[0] = first;
         res[1] = 0;
      }
      else {
         res[0] = second;
         res[1] = 1;
      }

      return res;
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
      int m = in.nextInt();
      int[][] A = new int[n][m];
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            A[i][j] = in.nextInt();
         }
      }
      
      game(n, m, A);
   }
}
