package hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/a.txt");

        Scanner sc = new Scanner(file);
        String s = "";
        while (sc.hasNextLine()) {
            s = s.concat(sc.nextLine());
            if (sc.hasNextLine()) {
                s = s.concat("\n");
            }
        }
        System.out.println(s);
        System.out.println(s.length());
        int mainlen = s.length();

        stringModify modify = new stringModify();

        s = modify.addPadding(s);
        System.out.println(s);
        System.out.println(s.length());

        String hash="";
        operator call=new operator();
        hash=call.SHA512(s,mainlen);

        System.out.println(hash);
    }
}


