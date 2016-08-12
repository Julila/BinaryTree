package com.company;

import java.util.Arrays;
public class BinaryTree {


  public   Node root;
    /* Function to get the count of leaf nodes in a binary tree*/
    public int getLeafCount(){
        return getLeafCount(root);
    }

    int getLeafCount(Node node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    public  int  count(Node root){
        countH(root);
        return c;
    }
    int c=0;
    private void countH(Node root)
    {
        if(root!=null)
        {
            if((root.left==null)&&(root.right==null))
            {
                c++;
            }
            count(root.left);
            count(root.right);
        }
    }

    public boolean contains(int data){
        Node temp = root ;
        while( temp != null){
            if( temp.data == data){
                return true;
            }
            if ( data< temp.data){
                temp = temp.left ;
            }
            else{
                temp = temp.right;
            }
        }
        return  false;
    }
    /**
     *
     * @param data
     *            Datensatz
     * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon
     *         vorhanden.
     */
    public boolean insert ( int data){
        if(root == null){
            root = new Node(data);
            return true;
        }
        Node temp = root;
        while(temp.data != data){
            if( data> temp.data) {
                if (temp.right == null) {
                temp.right = new Node(data);
                return true;
            } else {
                temp = temp.right;
            }
        }
        else if (temp.left == null) {
                temp.left = new Node(data);
                return true;
            } else {
                temp = temp.left;
            }
            }
            return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("The leaf count of binary tree is : "
                + tree.getLeafCount());

        System.out.println("Another solution : "
                +     tree.count(tree.root));    }

}
class Node{
    public   int data;
    public  Node left, right;
    public Node(int data){
        this.data = data;
        left= null;
        right= null;
    }
}
