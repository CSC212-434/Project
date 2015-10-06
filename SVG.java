
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SVG {
	
	private LinkedList<Object> linkedList;
	public SVG() {
	linkedList = new LinkedList<Object>();
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
			in.close();
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
			in2.close();
			
			
			
			for (int i = 5; i < lines.length-1; i++) {
			
			  if(lines[i].equals("<circle")){
				  String id = "";
					String cx = "";
					String cy = "";
					String r = "";
					String style = "";
				  System.out.println("circl---------------");
				int j = i;
				circle c;
				for (; i < j+6 ; i++) {
					
					    if(lines[i].contains("id=")){
					        for (int k = 4; k < lines[i].length()-1; k++) {
											id +=  (lines[i].charAt(k));
							}	
						}else if(lines[i].contains("cx=")){
							for (int k = 4; k < lines[i].length()-1; k++) {
											cx +=  (lines[i].charAt(k));
							}
						}else if(lines[i].contains("cy=")){
							for (int k = 4; k < lines[i].length()-1; k++) {
											cy +=  (lines[i].charAt(k));
							}
						}else if(lines[i].contains("r=")){
							for (int k = 3; k < lines[i].length()-1; k++) {
											r +=  (lines[i].charAt(k));
							}
						}else if(lines[i].contains("style=")){
							for (int k = 7; k < lines[i].length()-1; k++) {
											style +=  (lines[i].charAt(k));
							}
						}
						
						
					}
				c = new circle(cy, cx, r, id, style);
				linkedList.insert(c);
				
				}else if (lines[i].equals("<rect")){
					
					String id = "";
					String x = "";
					String y = "";
					String width = "";
					String height = "";
					String style = "";
					System.out.println("rect---------------");
					int j = i;
					rec r;
					for (; i < j+6 ; i++) {
						
						    if(lines[i].contains("id=")){
						        for (int k = 4; k < lines[i].length()-1; k++) {
												id +=  (lines[i].charAt(k));
								}	
							}else if(lines[i].contains("x=")){
								for (int k = 4; k < lines[i].length()-1; k++) {
												x +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("y=")){
								for (int k = 4; k < lines[i].length()-1; k++) {
												y +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("height=")){
								for (int k = 3; k < lines[i].length()-1; k++) {
									height +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("width=")){
								for (int k = 3; k < lines[i].length()-1; k++) {
									width +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("style=")){
								for (int k = 7; k < lines[i].length()-1; k++) {
												style +=  (lines[i].charAt(k));
								}
							}
							
							
						}
					r = new rec(y, x, height, width, width, style);
					linkedList.insert(r);
					
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
