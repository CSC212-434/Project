
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SVG {
	
	
	public SVG() {
		
	}
	public boolean read(String fileName) {
		
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			System.out.println(in.nextLine());
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}	
	public void write(String fileName) {
		
		
	}	
	/*
	public String query(String command) {
		
		
		
	}	
	*/
}
