import java.util.ArrayList;
import java.util.List;


public class coxExercise {

	public static void main(String[] args) {		
		coxExercise test = new coxExercise();
		if(args.length >0){
			try{
				for(String sInput: args){
					String output = test.finalString(sInput);
					System.out.println("Output String : "+output);
				}
			}catch(Exception e){
				System.out.println("Argument" + args[0] + " :" + e.getMessage());
			}
		}		
	}
	
	/**
	 * This method is to implement method to generate the final output using coxRules class
	 */	
	
	public String finalString(String input){
		List<String> wordlist = new ArrayList<String>();		
		coxRules rules = new coxRules();
		wordlist = rules.ruleNonAlphaChars(input);
		String finalString = "";
		if(!wordlist.isEmpty()){			
			for (String string : wordlist) {		
				string = rules.ruleReplaceDistinctCount(string);				
				finalString = finalString + string;
			}
		}		
		return finalString; 
	}
	

}
