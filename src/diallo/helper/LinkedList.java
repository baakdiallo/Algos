package diallo.helper;

public class LinkedList {

	Node head;

	public LinkedList(Node head) {
		this.head = head;
	}

	public void addFirst(Node first) {
		if (this.isEmpty())
			head = first;
		else {
			Node temp = head;
			head = first;
			head.next = temp;
		}
	}

	public void addLast(Node last) {
		if (this.isEmpty())
			head = last;
		else {
			Node temp = head;
			while (head.next != null)
				head = head.next;
			head.next = last;
			head = temp;
		}
	}

	public void addAfterFirstOccurence(int data, Node n) {
		if (this.isEmpty())
			head = n;
		else {
			Node temp = head;
			boolean added = false;
			while (head != null) {
				if (head.data == data) {
					Node tempNode = head.next;
					head.next = n;
					n.next = tempNode;
					added = true;
					break;
				}
				head = head.next;
			}
			if (!added)
				head.next = n;
			head = temp;
		}
	}

	public void addBeforeFirstOccurence(int data, Node n) {
		if (this.isEmpty())
			head = n;
		else if (head.data == data) {
			Node temp = head;
			head = n;
			n.next = temp;
		} else {
			Node temp = head;
			boolean added = false;
			while (head.next != null) {
				if (head.next.data == data) {
					Node tempNode = head.next;
					head.next = n;
					n.next = tempNode;
					added = true;
					break;
				}
				head = head.next;
			}
			if (!added)
				head.next = n;
			head = temp;
		}
	}

	public Node getNodeAtIndex(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException("...");
		else if (index == 0)
			return head;
		else {
			int i = 0;
			Node temp = head;
			while (i < index && temp != null) {
				temp = temp.next;
				i++;
			}
			return temp != null ? temp : null;
		}
	}

	public int getDataAtIndex(int index) {
		Node n = getNodeAtIndex(index);
		return n.data;
	}

	public void removeNodeAtIndex(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException("...");
		if (this.isEmpty())
			return;
		if (index == 0)
			head = head.next;
		else {
			Node previous = getNodeAtIndex(index - 1);
			Node n = getNodeAtIndex(index);
			if (previous != null && n != null) {
				previous.next = n.next;
			}
		}
	}

	public int indexOf(Node n) {
		if (head == null)
			return -1;
		if (head.data == n.data)
			return 0;
		int counter = 0;
		Node temp = head;
		while (temp != null && temp.data != n.data) {
			temp = temp.next;
			counter++;
		}
		return temp == null ? -1 : counter;
	}

	public LinkedList reverseList() {
		if (this.isEmpty() || this.size() == 1)
			return this;
		Node temp = head;
		LinkedList reversed = new LinkedList(null);
		while (head != null) {
			Node tempHead = new Node(head.data, null);
			reversed.addFirst(tempHead);
			head = head.next;
		}
		head = temp;
		return reversed;
	}

	public boolean contains(int integer) {
		Node temp = head;
		while (head != null && head.data != integer)
			head = head.next;
		if (head != null) {
			head = temp;
			return true;
		} else {
			head = temp;
			return false;
		}
	}

	public int size() {
		if (this.isEmpty())
			return 0;

		int size = 0;
		Node temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public void printList(Node h) {
		String list = "";
		if (h == null) {
			System.out.println("(empty list)");
			return;
		}
		while (h != null) {
			list += h.data + " => ";
			h = h.next;
		}
		list = list.substring(0, list.length() - 4);
		System.out.println("Linked List: " + list);
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

}
