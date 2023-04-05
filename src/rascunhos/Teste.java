package rascunhos;

import java.io.File;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**/
        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();
        File path = new File(strPath);

        /**/
        System.out.println();
        System.out.println("FOLDERS:");
        File[] folders = path.listFiles(File::isDirectory);
        for (File folder : folders){
            System.out.println(folder);
        }

        /**/
        System.out.println();
        System.out.println("FILES:");
        File[] files = path.listFiles(File::isFile);
        for (File file : files){
            System.out.println(file);
        }

        /**/
        boolean sucess = new File(strPath + "\\subdir").mkdir();
        if (sucess){
            System.out.println("Directory created sucessfully");
        }else{
            System.out.println("Directory isn't created sucessfully");
        }

    }
}
