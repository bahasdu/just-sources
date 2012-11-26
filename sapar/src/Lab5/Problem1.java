/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        StringTokenizer tr;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            in = new BufferedReader(new FileReader("scores.txt"));
            out = new PrintWriter(new FileWriter("grades.txt"));

            String line = in.readLine();
            while (line != null) {
                tr = new StringTokenizer(line, " ");

                while (tr.hasMoreTokens()) {
                    String name = tr.nextToken() + " " + tr.nextToken();
                    int grade = Integer.parseInt(tr.nextToken());
                    map.put(name, grade);

                }
                line = in.readLine();
            }
            for (String name:map.keySet()) {
                int grade = map.get(name);
                if (grade >= 90 && grade <= 100) {
                    out.println(name + " - " + "A");
                } else if (grade >= 80 && grade <= 89) {
                    out.println(name + " - " + "B");
                } else if (grade >= 70 && grade <= 79) {
                    out.println(name + " - " + "C");
                } else if (grade >= 60 && grade <= 69) {
                    out.println(name + " - " + "D");
                } else if (grade >= 0 && grade <= 49) {
                    out.println(name + " - " + "F");
                }

            }

        } finally {
            try {
                in.close();
                out.close();
            } catch (FileNotFoundException fn) {
                System.out.println("File not found!");
            } catch (IOException cf) {
                System.out.println("Cannot read from file!");
            }
        }

    }
}
