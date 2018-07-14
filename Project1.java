import java.util.Scanner;
import java.util.Arrays; //To use string split


class Project1 {

  public static void main(String args[]) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Please enter the initial sequence of values: ");
    String line = kb.nextLine();
    String[] lineArray = line.split(" "); //splits the sequence of values into an array
    int[] treeValues = new int[lineArray.length];
    for (int i = 0; i < lineArray.length; i++) {
      try {
        treeValues[i] = Integer.parseInt(lineArray[i]);
      }
      catch (Exception e) {
        System.out.println("Error - Sequence input not integers or of proper format, exiting program");
		System.exit(0);
      }
    }
    BST tree = new BST();
    for (int i = 0; i < treeValues.length; i++) {
      tree.insert(treeValues[i], tree.root, null);
    }
		
    System.out.println();
    System.out.println("Pre-order:  "); 
	tree.preOrder(tree.root);
	System.out.println();
    System.out.println("In-order: "); 
	tree.inOrder(tree.root);
	System.out.println();
    System.out.println("Post-order: "); 
	tree.postOrder(tree.root);
    String cmd = "z";
    while (cmd.charAt(0) != 'E') { //to repeat commands until user inputs 'E'
      System.out.println("Command? ");
      cmd = kb.nextLine().toUpperCase();
      System.out.println(cmd);
      lineArray = cmd.split(" "); //separates the string to have the integer different
			
      switch(cmd.charAt(0)) { //used to perform a function based on user char input. Any input not at the 0
        case 'I':
		  int insert = Integer.parseInt(lineArray[1]);
		  if (tree.contains(insert, tree.root))
		    System.out.println(insert + " already exists, ignore.");
		  else {
		    tree.insert(insert, tree.root, null);
		    System.out.println("In-order: "); 
			tree.inOrder(tree.root);
		  }
		  break;
		case 'D' :
          int delete = Integer.parseInt(lineArray[1]);
          if (tree.contains(delete, tree.root)) {
            tree.delete(delete, tree.root);
            System.out.println("In-order: ");
			tree.inOrder(tree.root);
          } 
		  else
            System.out.println(delete + " does not exist!");
          break;
        case 'P' :
          int predecessor = Integer.parseInt(lineArray[1]);
		  if (tree.contains(predecessor, tree.root) == false) {
		    System.out.println("predecessor does not exist");
		    break;
	      }
          if (tree.predecessor(predecessor, tree.root) == null) 
            System.out.println(predecessor + " does not have a predecessor.");
		  else
            System.out.println(tree.predecessor(predecessor, tree.root).getData());  
          break;
        case 'S' :
          int successor = Integer.parseInt(lineArray[1]);
		  if (tree.contains(successor, tree.root) == false) {
		    System.out.println("successor does not exist");
			break;
	      }
          if (tree.successor(successor, tree.root) == null) 
            System.out.println(successor + " does not have a successor.");
		  else
            System.out.println(tree.successor(successor, tree.root).getData());
		  break;
        case 'H' :
          System.out.println("I   Insert a value");
          System.out.println("D   Delete a value");
          System.out.println("P   Find predecessor");
          System.out.println("S   Find successor");
          System.out.println("H   Display this message");
          System.out.println("E   Exit the program");
          break;
        case 'E' :
          break;
        default :
          System.out.println("That is an unrecognisable command :");
        }
      System.out.println();
    }

    System.out.println("Thank you for using my program!");

  }
}