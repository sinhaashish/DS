import static javafx.scene.input.KeyCode.X;

public class LongestCommonSubsequence {

  public static void main(String args[]) {
    System.out.println(" Ashish");
    String X = "ABCBDAB";
    String Y = "BDCABA";
    String answer= LCSLength(X, Y);
    System.out.println(answer);
  }


  public static String LCSLength(String X, String Y) {
    int Table[][] = new int[X.length() + 1][Y.length() + 1];

    for (int i = 0; i < X.length(); i++) {
      for (int j = 0; j < Y.length(); j++) {
        if (X.charAt(i) == Y.charAt(j)) {
          Table[i + 1][j + 1] = Table[i][j] + 1;
        } else {
          Table[i + 1][j + 1] = Math.max(Table[i + 1][j], Table[i][j + 1]);
        }
      }
    }


    for (int i = 0; i < X.length(); i++) {
      for (int j = 0; j < Y.length(); j++) {
        System.out.print(Table[i][j]);
      }
      System.out.println();
    }

    StringBuffer lcs = new StringBuffer();
    for(int x= X.length(), y= Y.length();  x!=0 && y!=0 ;){
      if (Table[x][y]== Table[x-1][y]){
        x--;
      } else if (Table[x][y]== Table[x][y-1]){
        y--;
      } else{
        if (X.charAt((x-1))==Y.charAt(y-1)){
          lcs.append(X.charAt(x-1));
          x--;
          y--;
        }
      }

    }
    return lcs.reverse().toString();

  }


}