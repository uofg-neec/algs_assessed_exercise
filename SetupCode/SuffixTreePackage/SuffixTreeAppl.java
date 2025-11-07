package SuffixTreePackage;

/**
 * Class with methods for carrying out applications of suffix trees
 * @author David Manlove
 */

public class SuffixTreeAppl {

	/** The suffix tree */
	private SuffixTree t;

	/**
	 * Default constructor.
	 */
	public SuffixTreeAppl () {
		t = null;
	}
	
	/**
	 * Constructor with parameter.
	 * 
	 * @param tree the suffix tree
	 */
	public SuffixTreeAppl (SuffixTree tree) {
		t = tree;
	}
	
	/**
	 * Search the suffix tree t representing string s for a target x.
	 * Stores -1 in Task1Info.pos if x is not a substring of s,
	 * otherwise stores p in Task1Info.pos such that x occurs in s
	 * starting at s[p] (p counts from 0)
	 * - assumes that characters of s and x occupy positions 0 onwards
	 * 
	 * @param x the target string to search for
	 * 
	 * @return a Task1Info object
	 */

	public Task1Info searchSuffixTree(byte[] x) {
		int lenString = x.length;
		Task1Info task1Info = new Task1Info();

		if (lenString == 0) {
			return task1Info;
		}

		SuffixTreeNode currentNode = t.getRoot();
		int searchIndex = 0;

		while (searchIndex < lenString) {
			SuffixTreeNode child = currentNode.getChild();
			while (child != null) {
				if (t.getString()[child.getLeftLabel()] == x[searchIndex]) {
					break;
				}
				child = child.getSibling();
			}

			if (child == null) {
				return task1Info;
			}

			int left = child.getLeftLabel();
			int right = child.getRightLabel();

			while (left <= right) {
				if (t.getString()[left] == (byte) '$') {
					return task1Info;
				}
				searchIndex++;
				left++;

			}
			currentNode = child;

		}

		int minSuffix = findMinSuffix(currentNode);
		task1Info.setPos(minSuffix);
		task1Info.setMatchNode(currentNode);
		return task1Info;
	}

	private int findMinSuffix(SuffixTreeNode node) {
		int min = Integer.MAX_VALUE;
		if (node.getChild() == null) {
			return node.getSuffix();
		}
		SuffixTreeNode child = node.getChild();
		while (child != null) {
			int childMin = findMinSuffix(child);
			if (childMin < min) {
				min = childMin;
			}
			child = child.getSibling();
		}
		return min;
	}



	/**
	 * Search suffix tree t representing string s for all occurrences of target x.
	 * Stores in Task2Info.positions a linked list of all such occurrences.
	 * Each occurrence is specified by a starting position index in s
	 * (as in searchSuffixTree above).  The linked list is empty if there
	 * are no occurrences of x in s.
	 * - assumes that characters of s and x occupy positions 0 onwards
	 * 
	 * @param x the target string to search for
	 * 
	 * @return a Task2Info object
	 */

public Task2Info allOccurrences(byte[] x) {
    Task2Info task2Info = new Task2Info();

    SuffixTreeNode currentNode = t.getRoot();
    int searchIndex = 0;

    while (searchIndex < x.length) {
        SuffixTreeNode child = currentNode.getChild();
        while (child != null) {
            if (t.getString()[child.getLeftLabel()] == x[searchIndex]) {
                break;
            }
            child = child.getSibling();
        }
        if (child == null) {
            return task2Info;
        }
        int left = child.getLeftLabel();
        int right = child.getRightLabel();
        while (left <= right ) {
            if (t.getString()[left] == (byte)'$') {
                return task2Info;
            }
            searchIndex++;
            left++;
        }
        currentNode = child;
    }

    collectAllSuffixes(currentNode, task2Info);

    return task2Info;
}

private void collectAllSuffixes(SuffixTreeNode node, Task2Info task2Info) {
	if (node.getChild() == null) {

		task2Info.getPositions().add(node.getSuffix());
		return;
	}
	SuffixTreeNode child = node.getChild();
	while (child != null) {
		collectAllSuffixes(child, task2Info);
		child = child.getSibling();
	}
}

	/**
	 * Traverses suffix tree t representing string s and stores ln, p1 and
	 * p2 in Task3Info.len, Task3Info.pos1 and Task3Info.pos2 respectively,
	 * so that s[p1..p1+ln-1] = s[p2..p2+ln-1], with ln maximal;
	 * i.e., finds two embeddings of a longest repeated substring of s
	 * - assumes that characters of s occupy positions 0 onwards
	 * so that p1 and p2 count from 0
	 * 
	 * @return a Task3Info object
	 */
	public Task3Info traverseForLrs () {

		Task3Info task3Info = new Task3Info();




		
		return null; // replace with your code!
	}

	// helper method for lrs traversal


	/**
	 * Traverse generalised suffix tree t representing strings s1 (of length
	 * s1Length), and s2, and store ln, p1 and p2 in Task4Info.len,
	 * Task4Info.pos1 and Task4Info.pos2 respectively, so that
	 * s1[p1..p1+ln-1] = s2[p2..p2+ln-1], with len maximal;
	 * i.e., finds embeddings in s1 and s2 of a longest common substring 
         * of s1 and s2
	 * - assumes that characters of s1 and s2 occupy positions 0 onwards
	 * so that p1 and p2 count from 0
	 * 
	 * @param s1Length the length of s1
	 * 
	 * @return a Task4Info object
	 */
	public Task4Info traverseForLcs (int s1Length) {
		
		return null; // replace with your code!
	}
}
