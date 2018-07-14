public class BST {
  public Node root;
  
  public BST() {
    root = null;
  }
  //recursive methods for preorder, inorder, and postorder
  public void preOrder(Node n) {
    if (n != null) {
      System.out.print(n.getData() + " ");
	}
    if (n.getLeft() != null) {
      preOrder(n.getLeft());
    }
    if (n.getRight() != null) {
	  preOrder(n.getRight());
    }
  }
  public void inOrder(Node n) {
    if (n.getLeft() != null) {
      inOrder(n.getLeft());
	}
    if (n != null) {
      System.out.print(n.getData() + " ");
	}
    if (n.getRight() != null)
      inOrder(n.getRight());
  }
  public void postOrder(Node n) {
    if (n.getLeft() != null) {
	  postOrder(n.getLeft());
	}
	if (n.getRight() != null) {
	  postOrder(n.getRight());
	}
	if (n != null) {
	  System.out.print(n.getData() + " ");
	}
    
  }
  //utility method
  public boolean contains(int target, Node n) {
    if (n == null)
	  return false;
	if (n.getData() == target)
	  return true;
	if (n.getData() > target)
	  return contains(target, n.getLeft());
	else
	  return contains(target, n.getRight());
  }
  //insert method that recursively processes through the nodes to place at the end of the tree
  public Node insert(int element, Node n, Node p) {
    if (root == null) {
      root = new Node(element, null, null, null);
      return root;
    }
	if (n == null)
      return new Node(element, null, null, p);
	else if (element > n.getData())
	  n.setRight(insert(element, n.getRight(), n));
	else
	  n.setLeft(insert(element, n.getLeft(), n));
	return n;
  }
  //delete method that recursively searches for the target
  public Node delete(int element, Node n) {
    if (n == null)
	  return n;
	if (element > n.getData())
	  n.setRight(delete(element, n.getRight()));
	else if (element < n.getData())
	  n.setLeft(delete(element, n.getLeft()));
	//different cases for deleting the node
    else {
	  //if no left or right node exists
      if (n.left == null && n.right == null)
	    n = null;
	  //if no right node exists, the left node replaces the deleted node
      else if (n.getRight() == null)
        n = n.left;
	  //and vice versa
	  else if (n.getLeft() == null) 
        n = n.right;
	  //if left and right node exists, replace by the rightmost of the left node
      else {
        Node temp = n;
        n.setData(n.getLeft().getRightmost().getData());
        n.setLeft(n.getLeft().removeRightmost());
      }
    }
	return n;
  }

  // predecessor method searches for target node, and creates a temp node to return if there is a predecessor
  
  public Node predecessor(int target, Node n) {
	// case for non-existant tree
    if (root == null) {
	  return null;
	}
    if (n.getData() == target) {
	  //case of a left node existing for the target
      if (n.getLeft() != null) {
        return n.getLeft().getRightmost();
      } 
	  else {
        Node temp = n.parent;
		//case for finding the predecessor by looking through parent node(s)
        while (temp != null && n == temp.getLeft()) {
          n = temp;
          temp = temp.parent;
        }
        return temp;
      }
    } 
	//recursively search through the nodes based on greater/less than
	else if (n.getData() > target) {
      return predecessor(target, n.getLeft());
    } 
	else {
      return predecessor(target, n.getRight());
    }
  }

// mirrored version of predecessor

  public Node successor(int target, Node n) {
    if (root == null) return null;
    if (n.getData() == target) {
      if (n.getRight() != null) {
        return n.getRight().getLeftmost();
      } 
	  else {
        Node temp = n.parent;
        while (temp != null && n == temp.getRight()) {
          n = temp;
          temp = temp.parent;
        }

        if (temp == null) {
          return null;
        } 
		else {
          return temp;
        }
      }
    } 
	else if (n.getData() > target) {
      return successor(target, n.getLeft());
    } 
	else {
      return successor(target, n.getRight());
    }
  }
}
	