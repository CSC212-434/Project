
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class SVG {
	
	
	public SVG() {
		
	}
	public boolean read(String fileName) {
		try {
			int NOL= 0;
			int RN = 0;
			File F = new File(fileName);
			FileReader FO = new FileReader(F);
			BufferedReader PF =new BufferedReader(FO);
			while((PF.readLine())!=null){
				NOL++;
			}
			System.out.println(NOL);
			String r = "<svg";
			boolean t = true;
			
			while(t && PF.readLine()!=null){
				if(PF.readLine()!="<circle"){	
				RN++;
					System.out.println(RN);
				}
				if(PF.readLine()==null){
					t=false;
				}
			}
			
			
			return true;
			
		} catch (Exception e) {
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
