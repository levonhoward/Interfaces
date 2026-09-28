import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    static void main()
    {
        ShortWordFilter filter = new ShortWordFilter();
        ArrayList<Object> words = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        // Read file
        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.println("Reading the file: " + file.getFileName());

                while(reader.ready())
                {
                    String line = reader.readLine();

                    // Print the file for comparison
                    System.out.println(line);

                    String[] wordList = line.split(" ");

                    for (String word : wordList)
                    {
                        // Removes punctuation from words
                        word = word.replace(".", "");
                        word = word.replace(",", "");
                        word = word.replace("!", "");
                        word = word.replace("?", "");
                        word = word.replace(";", "");
                        word = word.replace(":", "");
                        word = word.replace("“", "");
                        word = word.replace("”", "");
                        word = word.replace("’", "");
                        word = word.replace("-", "");


                        // Adds non-empty Strings that pass the filter to the array list
                        if (!word.isEmpty() && filter.accept(word))
                        {
                            words.add(word);
                        }
                    }
                }
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Print the contents of words
        System.out.println("\nThe following words were 4 or fewer letters long in the selected file:\n");
        for (int i = 0; i < (words.size() - 1); i++)
        {
            System.out.print(words.get(i) + ", ");

            // Prints a new line every 10 words for readability
            if ((i + 1) % 10 == 0)
            {
                System.out.print("\n");
            }
        }
        System.out.println(words.getLast());
    }
}
