/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		PrintWriter out = null;
		StringTokenizer tr;
		int max=0;
		int min=1000000000;
		int average=0;
		int sum=0;
		int counter=0;
		try {
			in = new BufferedReader(new FileReader("scores.txt"));// in
			out = new PrintWriter(new FileOutputStream("grades.txt",true));// out;
                        HashMap<String,Integer> map = new HashMap<String,Integer>();
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
                        for(String key : map.keySet()){
                            if (min > map.get(key)) {
                                min = map.get(key);
                            }
                            if (max < map.get(key)) {
                                max = map.get(key);
                            }
                            average = (sum = sum + map.get(key)) / ++counter;                            
                        }
			out.println("Minimus is: "+min);
			out.println("Maximum is: "+max);
			out.println("Average is: "+average);
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
