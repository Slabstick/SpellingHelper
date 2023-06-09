import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
//    List<String> filteredList = Words.readWords("offWords.txt");
//    Words.writeWords(filteredList);

    long startTime = System.currentTimeMillis();
    List<String> possibleWords = SpellingBeeHelper.sbHelper('i', "rtlaom");
    long endTime = System.currentTimeMillis();
    String listString = String.join("\n ", possibleWords);
    System.out.println(listString);
    System.out.println("List created in " + (endTime - startTime) + "ms.");


  }

}
