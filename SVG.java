
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
					for (int i = 0; i < lines.length; i++) {
						lines[i]=in2.nextLine();
					}
				
			} catch (NoSuchElementException e ){
				
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
					for (; i < j+7 ; i++) {
						
						    if(lines[i].contains("id=")){
						        for (int k = 4; k < lines[i].length()-1; k++) {
												id +=  (lines[i].charAt(k));
								}	
							}else if(lines[i].contains("x=")){
								for (int k = 3; k < lines[i].length()-1; k++) {
												x +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("y=")){
								for (int k = 3; k < lines[i].length()-1; k++) {
												y +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("height=")){
								for (int k = 8; k < lines[i].length()-1; k++) {
									height +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("width=")){
								for (int k = 7; k < lines[i].length()-1; k++) {
									width +=  (lines[i].charAt(k));
								}
							}else if(lines[i].contains("style=")){
								for (int k = 7; k < lines[i].length()-1; k++) {
												style +=  (lines[i].charAt(k));
								}
							}
							
							
						}
					r = new rec(y, x, height, width, id, style);
					linkedList.insert(r);
					
				}
				
			}
			
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
		
	}	
	public void write(String fileName) {
		try{
		File f=new File("file.txt");
		FileReader FR = new FileReader(f);
		BufferedReader BFR = new BufferedReader(FR);
		
		String [] a = new String [6] ;
		int j=0;
		while(BFR.readLine ()!=null){
			a[j] = BFR.readLine () ;
			j++;
		}
		
		File fi= new File(fileName);
		FileOutputStream FOS = new FileOutputStream (fi);
		PrintWriter PW = new PrintWriter(FOS);
		
		for (int i = 0; i < 5; i++) {
			PW.write(a[i]);
			
		}
		String id = "id="
		while(){
			PW.Write(linkedList.retrieve());
		}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public String query(String command) {

		String[] com = command.split(" ");

		if (com[0].equals("AR") && isNumeric(com[1]) && isNumeric(com[2])
				&& isNumeric(com[3]) && isNumeric(com[4]) && isNumeric(com[5])) {
			if (!linkedList.empty()) {
			Object tem = linkedList.retrieve();
			linkedList.findFirst();
			while (!linkedList.last()) {
				if (linkedList.retrieve() instanceof rec) {
					if (((rec) linkedList.retrieve()).id.equals(com[1])) {
						return "Fail";
					}
				}
				linkedList.findNext();
			}
			// because last node
			if (linkedList.retrieve() instanceof rec) {
				if (((rec) linkedList.retrieve()).id.equals(com[1])) {
					return "Fail";
				}
			}
			rec r = new rec(com[3], com[2], com[4], com[5], com[1], com[6]);
			linkedList.findFirst();
			while (linkedList.retrieve() != tem) {
				linkedList.findNext();
			}
			linkedList.insert(r);
			return "Success";
			}
			return "Fail";

		} else if (com[0].equals("AC") && isNumeric(com[1])
				&& isNumeric(com[2]) && isNumeric(com[3]) && isNumeric(com[4])) {
			Object tem = linkedList.retrieve();
			linkedList.findFirst();
			while (!linkedList.last()) {
				if (linkedList.retrieve() instanceof circle) {
					if (((circle) linkedList.retrieve()).id.equals(com[1])) {
						return "Fail";
					}
				}
				linkedList.findNext();
			}
			// because last node
			if (linkedList.retrieve() instanceof circle) {
				if (((circle) linkedList.retrieve()).id.equals(com[1])) {
					return "Fail";
				}
			}
			circle c = new circle(com[3], com[2], com[4], com[1], com[5]);
			linkedList.findFirst();
			while (linkedList.retrieve() != tem) {
				linkedList.findNext();
			}
			linkedList.insert(c);
			return "Success";

		} else if (com[0].equals("FE")) {

			if (!linkedList.empty()) {
				linkedList.findFirst();
				while (!linkedList.last()) {
					if (linkedList.retrieve() instanceof rec) {
						if (((rec) linkedList.retrieve()).id.equals(com[1])) {
							return "Success";
						}
					} else if (linkedList.retrieve() instanceof circle) {
						if (((circle) linkedList.retrieve()).id.equals(com[1])) {
							return "Success";
						}
					}
					if (linkedList.retrieve() instanceof rec) {
						if (((rec) linkedList.retrieve()).id.equals(com[1])) {
							return "Success";
						}
					} else if (linkedList.retrieve() instanceof circle) {
						if (((circle) linkedList.retrieve()).id.equals(com[1])) {
							return "Success";
						}
					}
				}
			}
			
			return "Fail";

		} else if (com[0].equals("GE")) {

			if (!linkedList.empty()) {
				if (linkedList.retrieve() instanceof rec) {
					if (com[1].equals("id")) {
						return ((rec) linkedList.retrieve()).id;
					} else if (com[1].equals("x")) {
						return ((rec) linkedList.retrieve()).x;
					} else if (com[1].equals("y")) {
						return ((rec) linkedList.retrieve()).y;
					} else if (com[1].equals("height")) {
						return ((rec) linkedList.retrieve()).height;
					} else if (com[1].equals("width")) {
						return ((rec) linkedList.retrieve()).width;
					} else if (com[1].equals("style")) {
						return ((rec) linkedList.retrieve()).style;
					}
				} else if (linkedList.retrieve() instanceof circle) {
					if (com[1].equals("id")) {
						return ((circle) linkedList.retrieve()).id;
					} else if (com[1].equals("cx")) {
						return ((circle) linkedList.retrieve()).cx;
					} else if (com[1].equals("cy")) {
						return ((circle) linkedList.retrieve()).cy;
					} else if (com[1].equals("r")) {
						return ((circle) linkedList.retrieve()).r;
					} else if (com[1].equals("style")) {
						return ((circle) linkedList.retrieve()).style;
					}
				}
			}
			return "Fail";

		} else if (com[0].equals("SE")) {

			if (!linkedList.empty()) {
				if (linkedList.retrieve() instanceof rec) {
					if (com[1].equals("id")) {
						return "Fail";
					} else if (com[1].equals("x")) {
						((rec) linkedList.retrieve()).setX(com[2]);
						;
						return "Success";
					} else if (com[1].equals("y")) {
						((rec) linkedList.retrieve()).setY(com[2]);
						;
						return "Success";
					} else if (com[1].equals("height")) {
						((rec) linkedList.retrieve()).setHeight(com[2]);
						;
						return "Success";
					} else if (com[1].equals("width")) {
						((rec) linkedList.retrieve()).setWidth(com[2]);
						;
						return "Success";
					} else if (com[1].equals("style")) {
						((rec) linkedList.retrieve()).setStyle(com[2]);
						;
						return "Success";
					}
				} else if (linkedList.retrieve() instanceof circle) {
					if (com[1].equals("id")) {
						return "Fail";
					} else if (com[1].equals("cx")) {
						((circle) linkedList.retrieve()).setCx(com[2]);
						;
						return "Success";
					} else if (com[1].equals("cy")) {
						((circle) linkedList.retrieve()).setCy(com[2]);
						;
						return "Success";
					} else if (com[1].equals("r")) {
						((circle) linkedList.retrieve()).setR(com[2]);
						;
						return "Success";
					} else if (com[1].equals("style")) {
						((circle) linkedList.retrieve()).setStyle(com[2]);
						;
						return "Success";
					}
				}

			}
		}
		return "Fail";

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}











