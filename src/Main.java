import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
//    List<String> filteredList = Words.readWords("offWords.txt");
//    Words.writeWords(filteredList);

    List<String> possibleWords = SpellingBeeHelper.sbHelper('G', "ELOVTA");
    String listString = String.join("\n ", possibleWords);
    System.out.println(listString);
  }

}
