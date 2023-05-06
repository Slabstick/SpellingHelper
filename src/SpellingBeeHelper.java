import java.util.ArrayList;
import java.util.List;

public class SpellingBeeHelper {



  public static List<String> sbHelper(char middleLetter, String outerLetters) throws Exception{
    if (outerLetters.length() != 6) {
      throw new Exception("Parameters don't match right size!");
    }

    String fileName = "filteredWords.txt";
    List<String> wordList = Words.readWords(fileName);
    List<String> filteredList = new ArrayList<>();

    for (String word : wordList) {
      if (isValidWord(word, middleLetter, outerLetters)) {
        filteredList.add(word);
      }
    }

    return filteredList;


  }

  private static boolean isValidWord (String word, char middleLetter, String outerLetters) {
    if (!word.contains(String.valueOf(middleLetter))) {
      return false;
    }

    outerLetters += middleLetter;
    char[] wordLettersArray = word.toCharArray();
    for (char letter : wordLettersArray) {
      if (outerLetters.contains(String.valueOf(letter))) {
        continue;
      }
      return false;
    }
    return true;
  }

}
