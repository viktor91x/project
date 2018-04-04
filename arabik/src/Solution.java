import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        String file = JOptionPane.showInputDialog("Путь файла и его название");
        ArrayList<String> list = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Файл не найден!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        ArrayList<String> list2 = new ArrayList<String>();

        try {
            Pattern pat = Pattern.compile("[ء-ي]");
            for (int i = 0; i < list.size(); i++) {
                Matcher m = pat.matcher(list.get(i));
                StringBuilder sb = new StringBuilder();
                while (m.find()) {
                    sb.append(list.get(i).substring(m.start(), m.end()));
                }
                list2.add(sb.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
            for (int i = 0; i <list2.size() ; i++) {
                writer.println(list2.get(i));
            }
            writer.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Файл не найден!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}