
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		LinkedList r = new LinkedList();
		int tab[] = {12,56,89,75,91,34,23,10,99,11,27,83,77,12,45,76,37,81,80,17,59,27,33};
		int vab[] = {2,3,5,7,11,13,17,19,23,29,31,37,41};
		for(int i = 0; i < tab.length; i++ ){
			l.insertDataBeforeTheFirst(tab[i]);
		}
		for(int i = 0; i < vab.length; i++){
			r.insertDataAfterTheLast(vab[i]);
		}
		l.displayTheLinkedList();
		r.displayTheLinkedList();
		l.nconcLinkedList(r);
		l.displayTheLinkedList();
		l.sortTheLinkedList();
		l.displayTheLinkedList();
	}

}
