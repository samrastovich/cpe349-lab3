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
      
      for (int i = n - 1; i >= 0; i--) {
         for (int j = m - 1; j >= 0; j--) {
            if (i == n - 1 && j == m - 1) {
               R[i][j] = EXIT;
               S[i][j] += A[i][j];
            }
            else if (j == m - 1) {
               S[i][j] += (max(S[i + 1][j], 0) + A[i][j]);
            }
            else if (i == n -1) {
               S[i][j] += (max(S[i][j + 1], 0) + A[i][j]);
            }
            else {
               
            }
         }
      }
   }
   
   private static int max(int first, int second) {
      if (first > second) {
         return first;
      }
      else {
         return second;
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
