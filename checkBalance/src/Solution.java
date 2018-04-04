import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        String folder = JOptionPane.showInputDialog("Введите путь и название каталога с аккаунтами!");
        File mainFolder = new File(folder);
        File[] folders = mainFolder.listFiles();

        ArrayList<File> list = new ArrayList<File>();
        for (int i = 0; i <folders.length; i++) {
            File loginFolder = new File(folders[i].toString());
            File[] loginFolders = loginFolder.listFiles();
           int count = 0;
            for (int j = 0; j <loginFolders.length ; j++) {
                if (loginFolders[j].getName().equals("Контент") || loginFolders[j].getName().equals("Списки ЦА") || loginFolders[j].getName().equals("Хештеги")) {
                    count++;
                }
            }
            if(count==3&&loginFolders.length==3){
                String s = loginFolder.getName();
                if(!s.substring(0,3).equals("AAA"))
               list.add(new File(folders[i].toString()));
            }
        }
        String[] chekBalance = new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            File file = new File(list.get(i).toString()+"\\Списки ЦА");
            File[] files = file.listFiles();
            ArrayList<String> listString = new ArrayList<String>();
            int count = 0;
            for (int j = 0; j <files.length ; j++) {
               if(files[j].getName().length()>6){
                   String s = files[j].toString();
                   if(s.substring(s.length()-6,s.length()).equals("_Ф.txt")||s.substring(s.length()-6,s.length()).equals("_ф.txt")){
                       try {
                           BufferedReader reader = new BufferedReader(new FileReader(s));
                           while (reader.ready()){
                               reader.readLine();
                               count++;
                           }
                       } catch (FileNotFoundException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }

            }
            System.out.println(list.get(i).getName()+" - "+count);
        }

    }
}
