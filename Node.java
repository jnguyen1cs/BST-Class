class Node {
  protected int data;
  protected Node left;
  protected Node right;
  protected Node parent;

  public Node(int initalData, Node initalLeft, Node initalRight, Node initalParent) {
    data = initalData;
    left = initalLeft;
    right = initalRight;
    parent = initalParent;
  }

  public int getData() {
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setData(int newData) {
    data = newData;
  }

  public void setLeft(Node newLeft) {
    left = newLeft;
  }

  public void setRight(Node newRight) {
    right = newRight;
  }

  public Node getLeftmost() {
    if (left != null) {
      return left.getLeftmost();
    } else {
      return this;
    }
  }

  public Node getRightmost() {
    if (right != null) {
      return right.getRightmost();
    } else {
      return this;
    }
  }

  public Node removeLeftmost() {
    if (left == null) {
      return right;
    } else {
      left = left.removeLeftmost();
      return this;
    }
  }

  public Node removeRightmost() {
    if (right == null) {
      return left;
    } else {
      right = right.removeRightmost();
      return this;
    }
  }

}
	