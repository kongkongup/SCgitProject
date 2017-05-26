import java.awt.Font;
import java.io.File;
import java.io.InputStream;


public class CSFont   
{ 
    private static final String CABIN = "./pic/ArcaMajora3-Bold.otf";   // Relative path to 'Cabin' font 
     
    
     
    private  Font loadFont(String path) { 
 
        try { 
        	File fontFile = new File(this.getClass().getResource(path).toURI()); 
            return Font.createFont(Font.TRUETYPE_FONT, fontFile); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
 
        return null; 
    }
    
    public static void main(String[] args) {
    	CSFont sc= new CSFont();
		System.out.println(sc.loadFont(CABIN));
	}
}