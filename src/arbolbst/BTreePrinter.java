/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 

 
public class BTreePrinter {
 
    public static <T extends Comparable<T>> void printNode(NodoBST<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);
 
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }
 
    private static <T extends Comparable<T>> void printNodeInternal(List<NodoBST<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;
 
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
 
        BTreePrinter.printWhitespaces(firstSpaces);
 
        List<NodoBST<T>> newNodes = new ArrayList<NodoBST<T>>();
        for (NodoBST<T> node : nodes) {
            if (node != null) {
                System.out.print(node.geDato());
                newNodes.add(node.getIzq());
                newNodes.add(node.getDer());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                
                System.out.print(" ");
                   }
 
            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        
        System.out.println("");
 
        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
 
                if (nodes.get(j).getIzq()!= null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);
 
                BTreePrinter.printWhitespaces(i + i - 1);
 
                if (nodes.get(j).getDer() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);
 
                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }
 
            //System.out.println(""); // etsba en blanci
            System.out.println("");
        }
 
        printNodeInternal(newNodes, level + 1, maxLevel);
    }
 
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
 
    private static <T extends Comparable<T>> int maxLevel(NodoBST<T> node) {
        if (node == null)
            return 0;
 
        return Math.max(BTreePrinter.maxLevel(node.getIzq()), BTreePrinter.maxLevel(node.getDer())) + 1;
    }
 
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
 
        return true;
    }
 
}

