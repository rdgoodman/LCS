import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AlignmentRunner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Please enter the name of the file containing the sequences. Note that such a file, 'Sequences.txt', is included in this code.");
		String fn = scanner.next();
		LCS lcs;

		try {
			URL url = LCS.class.getResource(fn);
			File seq = new File(url.getFile());
			lcs = new LCS(seq);
			lcs.findLCS();		
			System.out.println("Enter 'Y' if you would like to run the algorithm on 10 randomly generated sequences");
			
			if (scanner.next().equals("Y")){
				runOnRandomlyGenerated(lcs);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: Cannot find file.");
			e.printStackTrace();
		}
		
	}

	public static void runOnRandomlyGenerated(LCS lcs) {
		String aniridia = "LQRNRTSFTQEQIEALEKEFERTHYPDVFARERLAAKIDLPEARIQVWFSNRRAKWRREE";

		for (int i = 0; i < 10; i++) {
			char[] a = createAnagram(aniridia.toCharArray());
			String anagram1 = "";
			for (int j = 0; j < a.length; j++){
				anagram1 = anagram1 + a[j];
			}
			System.out.println("\n>>> String A: " + anagram1);
			
			char[] b = createAnagram(aniridia.toCharArray());
			String anagram2 = "";
			for (int j = 0; j < b.length; j++){
				anagram2 = anagram2 + b[j];
			}
			System.out.println(">>> String B: " + anagram2);
			
			lcs.setA(anagram1);
			lcs.setB(anagram2);
			
			lcs.findLCS();
		}

	}

	public static char[] createAnagram(char[] original) {
		Random rand = new Random();

		for (int i = 0; i < original.length; i++) {
			int ind = rand.nextInt(original.length);
			char temp = original[i];
			original[i] = original[ind];
			original[ind] = temp;
		}
		return original;
	}

}
