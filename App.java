package Yang.MavenJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @author Yang
 *
 */
public class App 
{
	private HashMap<String, String> numMaps = null;
	private ArrayList<String> output = null;
	private void init(){
		numMaps = new HashMap<String,String>();
		numMaps.put("0","");
		numMaps.put("1","");
		numMaps.put("2","a,b,c");
		numMaps.put("3","d,e,f");
		numMaps.put("4","g,h,i");
		numMaps.put("5","j,k,l");
		numMaps.put("6","m,n,o");
		numMaps.put("7","p,q,r,s");
		numMaps.put("8","t,u,v");
		numMaps.put("9","w,x,y,z");
    }
	

	/**
	 * @param input
	 * @return
	 */
	public String process(String input){
	
		if(this.numMaps == null){
			this.init();
		}
		this.output=new ArrayList<String>();
		
		String inputStr = input.replaceAll(" ","");
	    String regNum = "^[0-9\\,]*$";
	    
	    if(!Pattern.matches(regNum, inputStr)){
	    	this.output.add("Only accept 0-9 and ','");
	    }else {
	    	List<String> possibleArrays = this.possibleArray(inputStr);
	    	combineArray("", possibleArrays);
	    }
	    return String.join(" ", this.output);
	};
	
	private List<String> possibleArray(String digit){
		
	    List<String>result = new ArrayList<String>();
	    
	    String[] digitList = digit.split(",");
	    for(int i=0; i<digitList.length; i++){
	    	
	       String numMap = numMaps.get(digitList[i]);
	       if(numMap !=null && numMap.length()>0){
	    	   boolean exist = result.contains(numMap);
	    	   if(!exist){
	    		   result.add(numMap);
	    	   }
	       }    
	    }
	    return result;
	};
	
	private void combineArray(String str, List<String> arraysLeft){
		
	    if(arraysLeft.isEmpty()){
	        return;
	    }
		List<String> arrayCurrent = arraysLeft.subList(0, 1);
	    List<String> arrayNext = arraysLeft.subList(1, arraysLeft.size());
	    String[] arrayCurrentStr =  arrayCurrent.get(0).split(",");

	    for(int i=0; i<arrayCurrentStr.length; i++){
	    	String strcurrent = str + arrayCurrentStr[i];
	    	
	    	if(arrayNext.size()>0){
	    		arrayNext.forEach(item->{
	    			this.combineArray(strcurrent, arrayNext);
	    		});
	        }else{
	        	this.output.add(strcurrent);
	        }
	    }
	};
	
    public static void main( String[] args )
    {
    	App myApp = new App();
    	System.out.println( myApp.process("1"));
    }
}
