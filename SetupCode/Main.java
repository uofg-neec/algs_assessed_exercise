import java.util.*;
import SuffixTreePackage.*;

/**
 * Main class - for accessing suffix tree applications
 * @author David Manlove
 */

public class Main {

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String args[]) {
	        String errorMessage = "Required syntax:\n";
                errorMessage += "  java Main SearchOne <filename> <query string> for Task 1\n";
                errorMessage += "  java Main SearchAll <filename> <query string> for Task 2\n";
                errorMessage += "  java Main LRS <filename> for Task 3\n" ;
                errorMessage += "  java Main LCS <filename1> <filename2> for Task 4";

		if (args.length < 2)
			System.out.println(errorMessage);
		else {
			// get the command from the first argument
			String command = args[0];

			switch (command) {
			case "SearchOne":
			case "SearchAll": {
			        if (args.length < 3) {
				        System.out.println(errorMessage);
					break;
				}
				System.out.println("Search results should be displayed here");
				break;
			}
			case "LRS": {
				System.out.println("LRS results should be displayed here");
				break;
			}
			case "LCS": {
				if (args.length < 3) {
					System.out.println(errorMessage);
					break;
				}
				System.out.println("LCS results should be displayed here");
				break;
			}
			default: System.out.println(errorMessage);
			}
		}
	}
}