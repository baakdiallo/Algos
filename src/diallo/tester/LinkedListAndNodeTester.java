package diallo.tester;

import diallo.helper.LinkedList;
import diallo.helper.Node;

public class LinkedListAndNodeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a = new Node(1, null);
		Node b = new Node(2, a);
		Node c = new Node(3, b);
		LinkedList list = new LinkedList(c);
		System.out.println(list.getHead()); // 3 = c.data
		list.printList(c); // 3=>2=>1
		list.removeNodeAtIndex(1);
		list.printList(c); // 3=>1
		Node d = b.getNext(); // a
		System.out.println(d); // 1
		d.setData(4);
		System.out.println(d); // 4
		list.printList(c); // 3=>4
		System.out.println(list.getHead()); // 3 = c.data
		list.addLast(new Node(100, null));
		list.printList(list.getHead()); // 3=>4=>100
		list.addFirst(new Node(-5, null));
		list.printList(list.getHead()); // -5=>3=>4=>100
		Node e = new Node(7, null);
		list.addAfterFirstOccurence(100, e); // -5=>3=>4=>100=>7
		list.printList(list.getHead());
		Node f = new Node(3, null);
		list.addBeforeFirstOccurence(100, f); // -5=>3=>4=>3=>100=>7
		list.printList(list.getHead());
		Node g = new Node(12, null);
		list.addAfterFirstOccurence(3, g); // -5=>3=>12=>4=>3=>100=>7
		list.printList(list.getHead());
		list.setHead(g);
		list.printList(list.getHead()); // 12=>4=>3=>100=>7
		LinkedList tsil = list.reverseList();
		tsil.printList(tsil.getHead()); // 7=>100=>3=>4=>12
		System.out.println(list.getHead()); // 712
		System.out.println(tsil.getHead()); // 7
		System.out.println(tsil.getDataAtIndex(3)); // 4

	}

}
