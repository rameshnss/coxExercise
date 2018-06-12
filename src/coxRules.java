/**
 * This class is to implement the following rules
 * 1. Each word in the input string is replaced with the following: the first letter of the word, the count of distinct letters between the first and last letter, 
 *   and the last letter of the word. For example, “Automotive parts" would be replaced by "A6e p3s".   
 * 2. A "word" is defined as a sequence of alphabetic characters, delimited by any non-alphabetic characters.   
 * 3. Any non-alphabetic character in the input string should appear in the output string in its original relative location.   
 */
import java.util.ArrayList;
import java.util.List;

public class coxRules {
	
	/**
	 * This method is to implement the rule 2 and 3
	 */	
	public List<String> ruleNonAlphaChars(String str){
		StringBuilder word = new StringBuilder();
		List<String> wordlist = new ArrayList<String>();
			if(!str.isEmpty()){			
				try{
						for(int i=0;i<str.length();i++){
						char c = str.charAt(i);
						Byte b = (byte)c;				
						if((b.byteValue()>=65 && b.byteValue()<=90) || (b.byteValue()>=97 && b.byteValue()<=122)){				
							word.append(str.charAt(i));					
							if((i==str.length())|| (i+1) == str.length()){
								wordlist.add(word.toString());
							}							
						}else{						
							if(word!=null){							
								wordlist.add(word.toString());
							}
							wordlist.add(String.valueOf(c));
							word = new StringBuilder();				
						}
					}				
				}
				catch(Exception e){
					System.out.println("Exception: "+e.getMessage());
				}			
			}		
			return wordlist;
		}
		
	/**
	 * This method is to implement the rule 1 (count the distinct chars and replace)
	 */	
	public String ruleReplaceDistinctCount(String input){
		
		String finalWord = "";
		if(input!=null && input.length()>1){
			String midPart = input.substring(1,input.length()-1);		
			String word[] = midPart.split("");
			for(int i=0;i<word.length;i++){		
				for(int j=i+1;j<word.length;j++){					
				    if(word[i].equalsIgnoreCase(word[j])){	
				    	word[j] = "";			    	
					}			
				}			
			}	
			String newWord = String.join("", word);		
			int distinctLength = newWord.length();	
			String firstLetter = input.substring(0, 1);
			String lastLetter = input.substring(input.length()-1, input.length());
			finalWord = firstLetter + distinctLength +lastLetter;			
		}else{
			finalWord = input;			
		}	
		return finalWord;
	}
}
