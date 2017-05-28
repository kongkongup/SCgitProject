package UTIL;

public class BlankCheck{
	
	public boolean Check(String str) {
		boolean result = false;		
	    for(int i = 0 ; i < str.length() ; i++) {
	        if(str.charAt(i) == ' '){
	            result = true;
	            break;
	        }	        	
	    }
	    return result;
	}
	
}
