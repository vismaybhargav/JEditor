package jeditor.util;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class FileUtils {
    public static String readTextAsLines(File file) {
        StringBuilder text = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(STR."File not Found\{e.getMessage()}");
        }

        return text.toString();
    }

    public static int getLineCount(File file) {
        // get the number of lines in a file, this is more generic for LF and CRLF
        int count = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            count = -1;
        }
        return count;
    }

    public static int getLineCount(String str) {
        // limit set to -1 to ensure lines with only \n are counted
        return str.split("\n", -1).length;
    }

    public static void saveFile(File file, String textToSave) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(textToSave);
            showAlert("Saved Successfully", "File saved successfully");
        } catch (IOException e) {
            System.out.println(STR."Unintended error occured: \{e.getMessage()}");
        }
    }

    // shows an alert dialog used for saving files
    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
