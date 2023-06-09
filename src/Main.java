import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
//    List<String> filteredList = Words.readWords("offWords.txt");
//    Words.writeWords(filteredList);

    List<String> possibleWords = SpellingBeeHelper.sbHelper('i', "rtlaom");
    String listString = String.join("\n ", possibleWords);
    System.out.println(listString);

  }

}
