import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args)  {

        String file  = JOptionPane.showInputDialog("Путь файла и его название");
        ArrayList<String> list = new ArrayList<String>();
        try( BufferedReader reader = new BufferedReader(new FileReader(file))) {
          while (reader.ready()){
                list.add(reader.readLine());
            }
            Collections.shuffle(list);
            reader.close();
        } catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null,"Файл не найден!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        try (PrintWriter  writer = new PrintWriter(file)){

            for (int i = 0; i < list.size(); i++) {
                writer.println(list.get(i));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Файл не найден!");
        }
        }
}
