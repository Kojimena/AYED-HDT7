
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

        BinaryTree<String> binaryTree = new BinaryTree<String>();
        BinaryTree<String> binaryTreeedit = new BinaryTree<String>();
        ArrayList<String> list = new ArrayList<String>();


        @Test
        void testInsertar() {
            binaryTree.addValue("merci");
            binaryTree.addValue("je");
            binaryTree.addValue("chien");
            binaryTree.addValue("tâche");
            binaryTree.addValue("village");
            binaryTree.addValue("oui");

            list.add("chien");
            list.add("je");
            list.add("merci");
            list.add("oui");
            list.add("tâche");
            list.add("village");

            assertEquals(list, binaryTree.inOrder(binaryTree.getRoot()));
        }


        @Test
        void testBuscar() {
            binaryTree.addValue("House");
            binaryTree.addValue("Dog");
            binaryTree.addValue("Homework");
            binaryTree.addValue("Woman");
            binaryTree.addValue("Town");
            binaryTree.addValue("Yes");

            assertEquals(binaryTree.containsNode("House"),true);
        }

    @Test
    void testdelete() {
        binaryTree.addValue("House");
        binaryTree.addValue("Dog");
        binaryTree.addValue("Homework");
        binaryTree.addValue("Woman");
        binaryTree.addValue("Town");
        binaryTree.addValue("Yes");
        binaryTree.delete("Dog");
        binaryTreeedit.addValue("House");
        binaryTreeedit.addValue("Homework");
        binaryTreeedit.addValue("Woman");
        binaryTreeedit.addValue("Town");
        binaryTreeedit.addValue("Yes");

        assertEquals(binaryTree.inOrder(binaryTree.getRoot()), binaryTreeedit.inOrder(binaryTree.getRoot()));
    }

}