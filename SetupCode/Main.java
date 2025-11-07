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
			String filename = args[1];
			FileInput fileInput = new FileInput(filename);
			byte[] text = fileInput.readFile();


			String str = args[2];
			byte[] string = str.getBytes();

			SuffixTree suffixTree = new SuffixTree(text);
			SuffixTreeAppl suffixTreeAppl = new SuffixTreeAppl(suffixTree);


			switch (command) {

			case "SearchOne": {
				if (args.length < 3) {
					System.out.println(errorMessage);
				break;
				}

				Task1Info task1Info = suffixTreeAppl.searchSuffixTree(string);

				if (task1Info.getMatchNode() == null) {
					System.out.println("Search string \"" + str + "\" not found in " + filename);
				}
				else {
					System.out.println("Search string \"" +  str + "\" occurs at position " + task1Info.getPos() + " of " + filename);
				}
				break;
			}

			case "SearchAll": {
				if (args.length < 3) {
					System.out.println(errorMessage);
				break;
				}

				// Task2Info task2Info = suffixTreeAppl.allOccurrences(string);
				// LinkedList<Integer> positions = task2Info.getPositions();


				// if (positions.isEmpty()) {
				// 	System.out.println("The string \"" + str + "\" does not occur in " + filename);
				// }
				// else {
				// 	System.out.println("The string \"" + str + "\" occurs in " + filename + " at positions:");
				// 	for (Integer position : positions) {
				// 		System.out.println(position);
				// 	}
				// 	System.out.println("The total number of occurrences is " + positions.size());
				// }
				// break;
			}

			case "LRS": {
				// Task3Info task3Info = suffixTreeAppl.traverseForLrs();
				// int len = task3Info.getLen();
				// int pos1 = task3Info.getPos1();
				// int pos2 = task3Info.getPos2();

				// System.out.println("An LRS in " + filename + " is \"");

				// for (int i = pos1; i < pos1 + len; i++) {
				// 	System.out.print((char) text[i]);
				// }
				// System.out.print(" \"");

				// System.out.println("Its length is " + task3Info.getLen());
				// System.out.println("Starting position of one occurrence is " + pos1);
				// System.out.println("Starting position of another occurrence is " + pos2);

				// break;
			}

			case "LCS": {
				if (args.length < 3) {
					System.out.println(errorMessage);
					break;
				}
				
				// Task4Info task4Info = suffixTreeAppl.traverseForLcs(text.length);
				// int lenLCS = task4Info.getLen();
				// int pos1 = task4Info.getPos1();
				// int pos2 = task4Info.getPos2();

				// System.out.println("An LCS of " + filename +  " and " + str + " is \"");
				
				// for (int i = pos1; i < pos1 + lenLCS; i++) {
				// 	System.out.print((char) text[i]);
				// }
				// System.out.print("\"");

				// System.out.println("Its length is " + lenLCS);
				// System.out.println("Starting position in " + filename + " is " + pos1);
				// System.out.println("Starting position in " + str + " is " + pos2);

				break;
			}

			default: System.out.println(errorMessage);

			}
		}
	}
}