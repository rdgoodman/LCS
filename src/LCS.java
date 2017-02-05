import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LCS {
	
	String A;
	String B;
	
	public LCS(File inputSequences){
		parseFiles(inputSequences);
	}
	
	public int[][] findLCS(){
		int n = A.length();
		int m = B.length();
		// length matrix
		int[][] subseq = new int[n][m];
		// direction matrix
		int[][] dirs = new int[n][m];
		
		for (int i = 0; i < n; i++){
			subseq[i][0] = 0;
		}
		for (int j = 0; j < m; j++){
			subseq[0][j] = 0;
		}
		// and here's where the magic happens
		for (int i = 1; i < n; i++){
			for (int j = 1; j < m; j++){
				int above = subseq[i-1][j];
				int left = subseq[i][j-1];
				int diagonal = -Integer.MAX_VALUE;
				if (A.charAt(i) == (B.charAt(j))){
					diagonal = subseq[i-1][j-1] + 1;
				}
				subseq[i][j] = Math.max(Math.max(above, left), diagonal);
				if (subseq[i][j] == above){
					dirs[i][j] = 1; // "up"
				} else if (subseq[i][j] == left){
					dirs[i][j] = 2; // "left"
				} else if (subseq[i][j] == diagonal){
					dirs[i][j] = 3; // "diagonal"
				}
			}
		}
		
		int[][] matrix = dirs;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("");
		}
		
		// TODO: maybe return result of printing?
		System.out.println();
		printLCS(dirs, n-1, m-1, "");
		System.out.println();
		return subseq;
	}
	
	public void printLCS(int[][] dirs, int i, int j, String lcs){
		if (i == 0 || j == 0){
			System.out.println("length: " + lcs.length());
			System.out.println("LCS: " + lcs);
			return;
		}
		
		if (dirs[i][j] == 3) {
			printLCS(dirs, i-1, j-1, Character.toString(A.charAt(i)) + lcs);
			// System.out.print(A.charAt(i));
		} else {
			if (dirs[i][j] == 1){
				printLCS(dirs, i-1, j, lcs);
			} else {
				printLCS(dirs, i, j-1, lcs);
			}
		}
	}

	
	public void parseFiles(File inputSequences) {
		try {
			Scanner scanner = new Scanner(inputSequences);
			while (scanner.hasNextLine()){
				String l = scanner.nextLine();
				if (l.startsWith(">") || l.startsWith(";") || l.equals(" ")){
					// it's a comment or a blank line, do nothing					
				} else {
					// sequence, and we're assuming it's all on one line and there are only two sequences
					if (A == null){
						A = l;
					} else {
						B = l;
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	public String getA() {
		return A;
	}


	public String getB() {
		return B;
	}

}
