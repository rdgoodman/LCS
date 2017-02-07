import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class LCSTest {

//	@Test
//	public void test() {
//		URL path = LCS.class.getResource("Sequences.txt");
//		File seq = new File(path.getFile());
//		LCS lcs = new LCS(seq);
//		lcs.parseFiles(seq);
//		
//		assertEquals("LQRNRTSFTQEQIEALEKEFERTHYPDVFARERLAAKIDLPEARIQVWFSNRRAKWRREE", lcs.getA());
//		assertEquals("LQRNRTSFTNDQIDSLEKEFERTHYPDVFARERLAGKIGLPEARIQVWFSNRRAKWRREE", lcs.getB());
//		
//		System.out.println("A's length: " + lcs.getA().length());
//		System.out.println("B's length: " + lcs.getB().length());
//		
//		int[][] matrix = lcs.findLCS();
//		for (int i = 0; i < matrix.length; i++){
//			for (int j = 0; j < matrix[i].length; j++){
//				System.out.print(matrix[i][j] + "  ");
//			}
//			System.out.println("");
//		}
//	}
	
	@Test
	public void testSmaller(){
		URL path = LCS.class.getResource("ToyExample.txt");
		File seq = new File(path.getFile());
		LCS lcs = new LCS(seq);
		
		lcs.findLCS();
	}

}
