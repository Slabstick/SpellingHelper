import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Words {

  public static List<String> readWords(String fileName) {

    List<String> wordList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
      String line = reader.readLine();
      while (line != null) {
        wordList.add(line);
        line = reader.readLine();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return wordList;
  }

  public static void writeWords(List<String> wordList) {
    List<String> filteredList = new ArrayList<>();
    String fileName = "filteredWords.txt";
    File file = new File(fileName);
    createFile(fileName);


    for (String word : wordList) {
      if (isValidWord(word)) {
        filteredList.add(word.toUpperCase());
      }
    }

    try (FileWriter writer = new FileWriter(fileName)) {
      for (String filteredWord : filteredList) {
        writer.write(filteredWord);
        writer.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Wrote " + filteredList.size() + " words to file " + file.getAbsolutePath());


  }

  private static boolean isValidWord(String word) {
    if (word.length() < 4) {
      return false;
    }

    if (word.contains("-") || word.contains("'") || word.contains("/") || word.contains(".")
      || word.contains("s")) {
      return false;
    }

    if (word.matches(".*\\d+.*")){
      return false;
    }

    Character[] charObjectArray =
        word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

    Set<Character> charSet = new HashSet<>(Arrays.asList(charObjectArray));

    return charSet.size() <= 7;
  }

  private static void createFile(String fileName) {
    try {
      File file = new File(fileName);
      if (file.exists()) deleteFile(fileName);
      if (file.createNewFile()) {
        System.out.println("New File created: " + file.getAbsolutePath());
      } else {
        System.out.println("Couldn't create file " + file.getAbsolutePath());
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deleteFile(String fileName) {
      File file = new File(fileName);
      if (file.delete()) {
        System.out.println("Deleted " + file.getAbsolutePath());
      } else {
        System.out.println("couldn't delete " + file.getAbsolutePath());
      }
  }



}
