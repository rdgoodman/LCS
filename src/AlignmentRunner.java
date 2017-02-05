import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class AlignmentRunner {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the name of the file containing the sequences. Note that such a file, 'Sequences.txt', is included in this code.");
		String fn = scanner.next();
		LCS lcs;

		try {
			URL url = LCS.class.getResource(fn);
			File seq = new File(url.getFile());
			lcs = new LCS(seq);
		} catch (Exception e){
			System.out.println("ERROR: Cannot find file."); 
			e.printStackTrace();
		}
	}

}
