package util;

import algorithm.search.Search;
import algorithm.search.bst.AVLTree;
import algorithm.search.bst.BSTSearchTree;
import java.util.List;
import structure.Elem;
import structure.graph.AMWGraph;
import structure.graph.DirectedGraph;
import structure.list.ArrayList;
import structure.list.LinkedList;
import structure.queue.CircleArrayQueue;
import structure.queue.LinkQueue;
import structure.stack.ArrayStack;
import structure.stack.LinkStack;
import structure.tree.BiNode;
import structure.tree.BiTree;
import structure.tree.HuffmanTree;

/**
 * @author zz
 * @date 2018/2/18
 */
public class TestFunction {

    public static final String TAG = "TestFunction";



    public static void testArrayList() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.insertAtLast(new Elem(1));
        arrayList.insertAtLast(new Elem(2));
        arrayList.insertAtLast(new Elem(3));
        arrayList.insertAtLast(new Elem(4));
        arrayList.insertAtLast(new Elem(5));

        arrayList.delete(0);
        arrayList.delete(0);
        arrayList.delete(0);
        arrayList.delete(0);
        arrayList.delete(0);
        arrayList.delete(0);



        //        arrayList.insert(new Elem(99), 6);
        //        arrayList.insert(new Elem(98), 2);

        LogUtil.d("testArrayList", arrayList.toString());
    }

    public static void testLinkList() {
        LinkedList linkedList = new LinkedList();
//        linkedList.insertAtFirst(new Elem(1));
        linkedList.insert(new Elem(5), 0);
        linkedList.insert(new Elem(4), 0);
        linkedList.insert(new Elem(3), 1);
        linkedList.insert(new Elem(2), 2);

        linkedList.delete(3);
//        linkedList.clear();


        LogUtil.d("Main", linkedList.toString());
    }

    public static void testArrayStack() {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(new Elem(1));
        arrayStack.push(new Elem(2));
        arrayStack.push(new Elem(3));
        arrayStack.push(new Elem(4));
        arrayStack.push(new Elem(5));
        arrayStack.push(new Elem(6));
        LogUtil.d("main", "  length = " + arrayStack.length());

        LogUtil.d("main", arrayStack.pop() + "  length = " + arrayStack.length());
        LogUtil.d("main", arrayStack.pop() + "  length = " + arrayStack.length());
        LogUtil.d("main", arrayStack.toString() + arrayStack.length());
    }

    public static void testLinkStack() {
        LinkStack linkStack = new LinkStack();
        linkStack.push(new Elem(1));
        linkStack.push(new Elem(2));
        linkStack.push(new Elem(3));
        linkStack.push(new Elem(4));
        linkStack.push(new Elem(5));
        linkStack.pop();
        linkStack.pop();
        linkStack.pop();
        linkStack.pop();
        LogUtil.d("main", "  length = " + linkStack.length());

        LogUtil.d("main", linkStack.pop() + "  length = " + linkStack.length());
        LogUtil.d("main", linkStack.pop() + "  length = " + linkStack.length());
        LogUtil.d("main", linkStack.toString() + linkStack.length());

    }

    public static void testCircleArrayQueue() {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(6);
        circleArrayQueue.enQueue(new Elem(1));
        circleArrayQueue.enQueue(new Elem(2));
        circleArrayQueue.enQueue(new Elem(3));
        circleArrayQueue.enQueue(new Elem(4));
        circleArrayQueue.enQueue(new Elem(5));
        circleArrayQueue.enQueue(new Elem(6));
        circleArrayQueue.enQueue(new Elem(7));

        LogUtil.d(TAG, " length = " + circleArrayQueue.length());

        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());
        LogUtil.d(TAG, " " + circleArrayQueue.deQueue().toString() + " length = " + circleArrayQueue.length());

    }

    public static void testLinkQueue() {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.enQueue(new Elem(1));
        linkQueue.enQueue(new Elem(2));
        linkQueue.enQueue(new Elem(3));
        linkQueue.enQueue(new Elem(4));
        linkQueue.enQueue(new Elem(5));
        linkQueue.enQueue(new Elem(6));

        LogUtil.d(TAG, " length = " + linkQueue.length());

        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());
        LogUtil.d(TAG, " " + linkQueue.deQueue().toString() + " length = " + linkQueue.length());

    }

    public static void testBiTree() {

        Elem[] elems = new Elem[] {
                new Elem("A"),
                new Elem("B"),
                new Elem("D"),
                new Elem("H"),
                new Elem("#"),
                new Elem("K"),
                new Elem("#"),
                new Elem("#"),
                new Elem("#"),
                new Elem("E"),
                new Elem("#"),
                new Elem("#"),
                new Elem("C"),
                new Elem("F"),
                new Elem("I"),
                new Elem("#"),
                new Elem("#"),
                new Elem("#"),
                new Elem("G"),
                new Elem("#"),
                new Elem("J"),
                new Elem("#"),
                new Elem("#"),

        };

        BiTree biTree = new BiTree();
        biTree.createBiTree(elems);

        biTree.preOrderTraverseNonRecursive();
        biTree.preOrderTraverse();

        biTree.inOrderTraverseNonRecursive();
        biTree.inOrderTraverse();

        biTree.postOrderTraverseNonRecursive();
        biTree.postOrderTraverse();
    }

    public static void testHuffmanTree() {
        BiNode[] biNodes = new BiNode[] {
                new BiNode('A', 3),
                new BiNode('B', 8),
                new BiNode('C', 4),
                new BiNode('D', 7),
                new BiNode('E', 8),
                new BiNode('F', 6),
                new BiNode('G', 2),
                new BiNode('H', 2),
                new BiNode('I', 2),

        };

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(biNodes);
        List<HuffmanTree.HuffmanCode> huffmanCodeList = huffmanTree.huffmanEncode();
        LogUtil.d(TAG, "huffmanCodeList = " + huffmanCodeList.toString());

        StringBuilder stringBuilder = new StringBuilder();
        for (HuffmanTree.HuffmanCode huffmanCode : huffmanCodeList) {
            stringBuilder.append(huffmanCode.code);
        }
        String code = stringBuilder.toString();
        LogUtil.d(TAG, "code = " + code + "  length = " + code.length());
        LogUtil.d(TAG, "decode = " + huffmanTree.huffmanDecode(code));

        //        String testCode = "011111100100101111011";
        //        LogUtil.d(TAG, "decode testCode = " + huffmanTree.huffmanDecode(testCode));
    }

    public static void testGraphTraverse() {
        AMWGraph amwGraph = new AMWGraph(9, false);
        String[] labels = new String[] {
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I"
        };
        for (String label : labels) {
            amwGraph.insertVertex(label);
        }
        amwGraph.insertEdge(0, 1);
        amwGraph.insertEdge(0, 5);
        amwGraph.insertEdge(1, 2);
        amwGraph.insertEdge(1, 6);
        amwGraph.insertEdge(1, 8);
        amwGraph.insertEdge(2, 3);
        amwGraph.insertEdge(3, 4);
        amwGraph.insertEdge(3, 6);
        amwGraph.insertEdge(3, 7);
        amwGraph.insertEdge(3, 8);
        amwGraph.insertEdge(4, 5);
        amwGraph.insertEdge(4, 7);
        amwGraph.insertEdge(5, 6);
        amwGraph.insertEdge(6, 7);

        //        amwGraph.DFSTraverse();
        //        amwGraph.deleteEdge(5,6);
        //        amwGraph.DFSTraverse();

        amwGraph.BFSTraverse();
    }

    public static void testMiniTreePrim() {
        AMWGraph amwGraph = new AMWGraph(9, false);
        String[] labels = new String[] {
                "V0",
                "V1",
                "V2",
                "V3",
                "V4",
                "V5",
                "V6",
                "V7",
                "V8"

        };
        for (String label : labels) {
            amwGraph.insertVertex(label);
        }
        amwGraph.insertEdge(0, 1, 10);
        amwGraph.insertEdge(0, 5, 11);
        amwGraph.insertEdge(1, 2, 18);
        amwGraph.insertEdge(1, 6, 16);
        amwGraph.insertEdge(1, 8, 12);
        amwGraph.insertEdge(2, 3, 22);
        amwGraph.insertEdge(2, 8, 8);
        amwGraph.insertEdge(3, 4, 20);
        amwGraph.insertEdge(3, 6, 24);
        amwGraph.insertEdge(3, 7, 16);
        amwGraph.insertEdge(3, 8, 21);
        amwGraph.insertEdge(4, 5, 26);
        amwGraph.insertEdge(4, 7, 7);
        amwGraph.insertEdge(5, 6, 17);
        amwGraph.insertEdge(6, 7, 19);

        amwGraph.miniSpanTreePrim();
    }

    public static void testMiniPath() {
        AMWGraph amwGraph = new AMWGraph(9, false);
        String[] labels = new String[] {
                "V0",
                "V1",
                "V2",
                "V3",
                "V4",
                "V5",
                "V6",
                "V7",
                "V8"

        };
        for (String label : labels) {
            amwGraph.insertVertex(label);
        }
        amwGraph.insertEdge(0, 1, 1);
        amwGraph.insertEdge(0, 2, 5);
        amwGraph.insertEdge(1, 2, 3);
        amwGraph.insertEdge(1, 3, 7);
        amwGraph.insertEdge(1, 4, 5);
        amwGraph.insertEdge(2, 4, 1);
        amwGraph.insertEdge(2, 5, 7);
        amwGraph.insertEdge(3, 4, 2);
        amwGraph.insertEdge(3, 6, 3);
        amwGraph.insertEdge(4, 5, 3);
        amwGraph.insertEdge(4, 6, 6);
        amwGraph.insertEdge(4, 7, 9);
        amwGraph.insertEdge(5, 7, 5);
        amwGraph.insertEdge(6, 7, 2);
        amwGraph.insertEdge(6, 8, 7);
        amwGraph.insertEdge(7, 8, 4);

        //        amwGraph.dijkstra(0);
        amwGraph.floyd();
    }

    public static void testTopoSort() {
        DirectedGraph directedGraph = new DirectedGraph("./files/directedGraph.txt");
        directedGraph.topoSort();
    }

    public static void testSearch() {
        int[] src = new int[1000];

        int start = 0;
        java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            start += Randoms.randomInt(1, 10);
            src[i] = start;
            arrayList.add(start);
        }
        Search.linearSearch(src, src[410]);
        Search.binarySearch(src, src[410]);
        Search.interpolation(src, src[410]);
        Search.fibonacciSearch(arrayList, src[410]);
    }

    public static void testBST() {

        int[] a = new int[] {
                62, 58, 88, 60, 47, 73, 99, 35, 51, 32, 36, 48, 93, 97, 28, 34
        };

        BSTSearchTree bstSearchTree = new BSTSearchTree();
        for (int i = 0; i < a.length; i++) {
            bstSearchTree.addNode(a[i]);
        }
        bstSearchTree.inOrderTraverse();
        bstSearchTree.deleteNode(62);
        bstSearchTree.inOrderTraverse();

        AVLTree avlTree = new AVLTree();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
    }
}
