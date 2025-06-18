import java.util.Arrays;
import java.util.StringTokenizer;

public class Tokenize {
  private static void tokenize(String string, String token) {
    String[] tokens = string.split(token);
    System.out.println(Arrays.toString(tokens));
  }

  private static void tokenizeByStringTokenizer(String string, String delimiter) {
    // returnDelims flag decides whether delimiter matches will be included.
    StringTokenizer st = new StringTokenizer(string, delimiter, false);
    System.out.println(st.countTokens());
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }

  private static void tokenizeWithLimitedSplits(String string, String token, int noOfSplits) {
    String[] tokens = string.split(token, noOfSplits);
    System.out.println(Arrays.toString(tokens));
  }

  public static void main(String[] args) {
    String x = "ab;cde;fg;h;ijk";
    Tokenize.tokenize(x, ";");

    // edge cases
    Tokenize.tokenize("", ",");
    Tokenize.tokenize("one,,two", ",");
    // Question: What will be the output of the above code?
    // Answer: The output will be 3 with tokens being ["one"], ["two"], and ["three"]. The regex [ ,;]+ matches any sequence of commas, spaces, or semicolons, collapsing them into a single delimiter.
    Tokenize.tokenize("one, two;, three", "[,; ]+");
    Tokenize.tokenize(",one,two,", ",");

    // using string tokenizer
    Tokenize.tokenizeByStringTokenizer("one,two,three", ",");

    // limiting delimiter splits
    Tokenize.tokenizeWithLimitedSplits("one,two,three,four", ",", 2);

    Tokenize.tokenize("one?two!three", "[?!]+");
  }
}