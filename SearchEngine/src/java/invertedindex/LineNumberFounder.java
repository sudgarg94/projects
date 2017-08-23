/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * @author kkgarg
 */
public class LineNumberFounder {
    
    
//    public static int findLineNumber (String filePath,String fragment)throws Exception {
        public static void main (String[] args)throws Exception {
        String filePath="/Users/kkgarg/Desktop/Northeastern/Summer 2017/Resources/fileLocation/Resume.doc";
        String fragment="857";
        
//          FileReader fr = new FileReader(file);
//          BufferedReader br = new BufferedReader(fr);
//          String line;

        // Read the file and display it line by line.
        
        LineNumberReader lineReader = new LineNumberReader(new FileReader(filePath));
            int number = 0;
            String line;
            while ((line = lineReader.readLine()) != null)
            {
                if (line.contains(fragment))
                {
                    number = lineReader.getLineNumber();
                    System.out.println("number is " +number);
                }
            }
//            System.out.println("[" + numbers.substring(1) + "]");
//            return number;
       
    
    }
}
