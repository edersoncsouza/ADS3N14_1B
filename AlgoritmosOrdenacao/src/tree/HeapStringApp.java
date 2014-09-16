package tree;
 
import java.util.Scanner;
 
/**
 * @author Sesh Venugopal. New Jersey. 2013
 */
public class HeapStringApp {
    
	Heap<String> hp = new Heap<String>();
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        /*
    	//Heap<String> hp = new Heap<String>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter next contact, 'done' to stop: ");
        String line = sc.next();
        while (!line.equals("done")) {
            hp.insert(line);
            System.out.println(hp);
            System.out.print("Enter next contact, 'done' to stop: ");
            line = sc.next();
        }
        
    	
        while (!hp.isEmpty()) {
            String max = hp.delete();
            System.out.println(max + " " + hp);
        }
        */
    }
    
    public void insertContact(){
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter next contact, 'done' to stop: ");
        String line = sc.next();
        while (!line.equals("done")) {
            hp.insert(line);
            System.out.println(hp);
            System.out.print("Enter next contact, 'done' to stop: ");
            line = sc.next();
        }
        sc.close();
    }
 
    public void deleteContact(){
    	while (!hp.isEmpty()) {
            String max = hp.delete();
            System.out.println(max + " " + hp);
        }
    }
}