public class GameProblem {

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n][m];
      
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            
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
