package variousConcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Readingtext {
	
	
	
	public List<String> Read() throws IOException {

		
		List<String>myList=new ArrayList<String>();
		String path="C:\\Users\\rohik\\NewEclipseSelenium\\crm\\Myexcel\\abc.txt";
		File f = new File(path);
		
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		
		String Line=null;
		
		while((Line =br.readLine()) != null){
			myList.add(Line);
		}
		/*
		 * System.out.println(myList.size()); for(int i=0;i<myList.size();i++) {
		 * System.out.println(myList.get(i)); }
		 */
		br.close();
		return myList;

	}

}
