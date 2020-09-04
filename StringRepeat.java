
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringRepeat {

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		
		String input= scanner.next();
		LinkedHashMap<Character, String> newStringHM = new LinkedHashMap<Character, String>(); 
		
		
		for (char c : input.toCharArray())
		{
			newStringHM.put(Character.toLowerCase(c), newStringHM.containsKey(Character.toLowerCase(c)) ? newStringHM.get(Character.toLowerCase(c)).concat(Character.toString(c)) : Character.toString(c));
		}
		
		
		List<Map.Entry<Character, String>> entries = new ArrayList<Map.Entry<Character, String>>( newStringHM.entrySet() );
		 
		Collections.sort(entries, new Comparator<Map.Entry<Character, String>>(){
		 
		    public int compare(Entry<Character, String> entry1, Entry<Character, String> entry2) {                
		        return entry1.getValue().length() - entry2.getValue().length();
		    }
		    
		});
		
		newStringHM.clear();
		
		for(Map.Entry<Character, String> entry : entries){
			newStringHM.put(entry.getKey(), entry.getValue());
		}
		 
		String newString="";
		boolean flag = true;
		
		for (Entry<Character, String> entry : newStringHM.entrySet()) 
		{
			
			if(flag && entry.getValue().length()==1)
			{
				System.out.println("first letter that is not repeated :"+entry.getValue());
				flag = false;
			}
			
			newString = newString.concat(entry.getValue());
		}
		
		if(flag)
		{
			System.out.println("no non-repeating letter found");
		}
		
		System.out.println("New String = "+newString);
	}
}
