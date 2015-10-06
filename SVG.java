
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SVG {
	
	
	public SVG() {
		
	}
	public boolean read(String fileName) {
		String[] lines;
		int NOL=0;
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			Scanner in2 = new Scanner(new FileReader(fileName));
			try{
				while(true){
					if(in.nextLine()!=null){
						NOL++;
					}
				}
			} catch (NoSuchElementException e ){
				System.out.println(NOL);
			}
			lines = new String[NOL];
			try{
				while(true){
					for (int i = 0; i < lines.length; i++) {
						lines[i]=in2.nextLine();
					}
				}
			} catch (NoSuchElementException e ){
				for (int i = 0; i < lines.length; i++) {
					System.out.println(lines[i]);
				}
			}
			
			
			return true;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}	
	public void write(String fileName) {
		
		
	}	
	/*
	public String query(String command) {
		
		
		
	}	
	*/
}
