
public class List {
	private int data;
	private List next;
	List(){};//This is my default constructor. 
	//The next method is the constructor number two
	List(int data,List next){
		this.data = data;
		this.next = next;
	}
	//The next method is used to return the data of the memory space that is pointed by the list
	static int getTheDataOfTheList(List l){
		return l.data;
	}
	//The next method is used to return the next of the memory space that is pointed by the list
	static List getTheNextOfTheList(List l){
		return l.next;
	}
	//The next method is used to put a value into the integer part of the memory space that is specified 
	static void setDataIntoTheList(int data,List l){
		l.data = data;
	}
	//The next method is used to put a value into the list part of the memory space that is specified
	static void setNextIntoTheList(List next,List l){
		l.next = next;
	}
	//The next method is used to insert a data before the first list
	static List insertDataIntoTheFirstList(int data,List l){
		List p = new List(data,l);
		l = p;
		return l;
	}
	//The next method is used to insert a data after the last list
	static List insertDataIntoTheLastList(int data,List l){
		if(l == null){
			return new List(data,null);
		}
		else{
			l.next = insertDataIntoTheLastList(data,l.next);
		}
		return l;
	}
	//The next method is used to display the set of data of the list
	static void displayAllDataOfTheList(List l){
		if(l == null){System.out.println("");}
		else{
			System.out.print(l.data + " ");
			displayAllDataOfTheList(l.next);
		}
	}
	//The next method allows to get the last component of the sequence
	static List getTheLastElement(List l){
		List p = l;
		while(p.next != null){
			p = p.next;
		}
		return p;
	}
	//The next method allows to get the first component of the sequence
	static List getThefirstElement(List l){
		return l;
	}
	//The next method is used to search a List into the list by its value
	static List searchDataByVal(List l,int data){
		if(l == null){
			return null;
		}
		else if(l.data == data){
			return l;
		}
		else{
			return searchDataByVal(l.next,data);
		}
	}
	//The next method is used to search the data into the list by its position
	static List searchDataByPos(List l,int pos){
		if(l == null){
			return null;
		}
		else if(pos == 0){
			return l;
		}
		else{
			return searchDataByPos(l.next,pos - 1);
		}
	}
	//The next method is used to reverse the sequence for example when we have the sequence a-->b-->c. With this method we will get the sequence c-->b-->a 
	static List reverseTheList(List l){
		List p = l;
		l = null;
		while(p != null){
			l = insertDataIntoTheFirstList(p.data,l);
			p = p.next;
		}
		return l;
	}
	//The next method allows to sort all data that are present into the list
	static void sortTheList(List l){
		List p,q;
		p = l;
		while(p.next != null){
			q = p.next;
			while(q != null){
				if(p.data > q.data){
					List r = new List();//The list r is created by the default constructor.  
					r.data = p.data; 
					p.data = q.data;
					q.data = r.data;
				}
				q = q.next;
			}
			p = p.next;
		}
	}
	//The next method allows to get the maximum value of the list
	static int getTheMaximumOfTheList(List l){
		List p = l.next;
		int max = l.data;
		while(p != null){
			max = (max < p.data) ? p.data : max;
			p = p.next;
		}
		return max;
	}
	//The next method allows to get the minimum value of the list
	static int getTheMinimumOfTheList(List l){
		List p = l.next;
		int min = l.data;
		while(p != null){
			min = (min > p.data) ? p.data : min;
			p = p.next;
		}
		return min;
	}
	//The next method is used to remove a data from the list by its value
	static List removeDataByValFromTheList(int data,List l){
		if(l == null){
			System.out.println("Oups!!!  the list is empty");
		}
		else if(l.data == data){
			List p = l.next;
			return p;
		}
		else{
			List p,q;
			p = q = l;
			while(p != null && p.data != data){
				q = p;
				p = p.next;
			}
			if(p != null){
				q.next = p.next;
			}
		}
		return l;
	}
	//The next method is used to remove a data from the list by its position
	static List removeDataByPosFromTheList(int pos,List l){
		int cp = 0;
		if(l == null){
			System.out.println("Oups!!!  the list is empty");
		}
		else if(cp == pos){
			List p = l.next;
			return p;
		}
		else{
			List p,q;
			p = q = l;
			while(p != null && cp != pos){
				cp++;
				q = p;
				p = p.next;
			}
			if(p != null){
				q.next = p.next;
			}
		}
		return l;
	}
	//The next method allows to link two different list together without destroying the list type parameters
	static List append(List p,List q){
		List r = null;
		List t = null;
		while(p != null){
			r = insertDataIntoTheLastList(p.data,r);
			p = p.next;
		}
		t = r;
		while(t.next != null){
			t = t.next;
		}
		t.next = q;
		return r;
		
	}
	//The next method allows to link two different list together by destroying the first list type parameter
	static void nconc(List p,List q){
		List r = p;
		while(r.next != null){
			r = r.next;
		}
		r.next = q;
	}
}
