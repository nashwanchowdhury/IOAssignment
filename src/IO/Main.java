package IO;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilePath1 = "src/IO/input1.txt";
        String inputFilePath2 = "src/IO/input2.txt";
        String outputFilePath = "src/IO/common.txt";

        PrintWriter printer = new PrintWriter(("src/IO/merged.txt"));

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath1));

        String line = reader.readLine();

        while (line != null)
        {
            printer.println(line);
            line = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(inputFilePath2));

        line = reader.readLine();

        while (line != null)
        {
            printer.println(line);
            line = reader.readLine();
        }

        printer.flush();

        reader.close();
        printer.close();

        String inputFilePath3 = "src/IO/merged.txt";

        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        reader = new BufferedReader(new FileReader(inputFilePath1));

            while ((line = reader.readLine()) != null) {
                first.add(line);
            }

        reader = new BufferedReader(new FileReader(inputFilePath2));

        while ((line = reader.readLine()) != null) {
            second.add(line);
        }

        first.retainAll(second);

        try {
            File outputFile = new File(outputFilePath);

            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists. Will be updated with new content.");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (String sortedLine : first) {
                writer.write(sortedLine);
                writer.newLine();
            }
            writer.close();
            System.out.println("Data written to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }

















    }
}