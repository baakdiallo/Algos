
public class List {
	Receipt data;
	List next;
	List(Receipt data, List next){
		this.data = data;
		this.next = next;
	}
	static List insertDataInTheHead(Receipt data,List l){
		List p = new List(data,l);
		return p;
	}
	static List insertDataInTheTail(Receipt data,List l){
		List p = new List(data,null);
		if(l == null){
			return p;
		}
		else{
			List q = l;
			while(q.next != null){
				q = q.next;
			}
			q.next = p;
			return l;
		}
	}
	static List getTheHeadOfTheList(List l){
		return l;
	}
	static List getTheTailOfTheList(List l){
		List p = l;
		while(p.next != null){
			p = p.next;
		}
		return p;
	}
	static List removeTheHeadDataOfTheList(List l){
		l = l.next;
		return l;
	}
	static void removeTheTailDataOfTheList(List l){
		List p = l;
		while(p.next.next != null){
			p = p.next;
		}
		p.next = null;
	}
	static void displayOneCellOfTheList(List l){
		l.data.displayReceipt();
	}
	static void displayAllCellOfTheList(List l){
		if(l == null){
			System.out.println("");//Go to the next line 
		}
		else{
			displayOneCellOfTheList(l);
			displayAllCellOfTheList(l.next);
		}
	}
}
