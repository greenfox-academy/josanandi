import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
    public static void main (String[] args) {
        // Create a function that takes 3 parameters: a path, a word and a number,
        // than it should write to a file.
        // The path parameter should be a string, that describes the location of the file.
        // The word parameter should be a string, that will be written to the file as lines
        // The number paramter should describe how many lines the file should have.
        // So if the word is "apple" and the number is 5, than it should write 5 lines
        // to the file and each line should be "apple"
        // The function should not raise any error if it could not write the file.
        WriteMultiplesLines("my-file.txt", "What a great day!", 5);

    }
    public static void WriteMultiplesLines(String path, String word, int lineNumber){
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i <lineNumber ; i++) {
            lines.add(word);
        }
        Path file =Paths.get(path);
        try {
            Files.write(file, lines);
        }
        catch(IOException e){
            ;
        }
     return;

    }

}
