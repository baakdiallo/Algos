
public class LinkedList{
	private List data;
	//default constructor 
	public LinkedList(){	
		this.data = null;	
	}
	public List getData(){
		return this.data;
	}
	public boolean isEmpty(){
		return (this.data == null);
	}
	public void addLast(List q){
		if (this.isEmpty()){
			this.data = q;
		}
		else{
			List p;
			p = this.data;
			while(p.getNext() != null){
				p = p.getNext();
			}
			p.setNext(q);
			
		}
	}
	public void addFirst(List q){
		q.setNext(this.data);
		this.data = q;
	}
	public void displayData(){
		List p = this.data;
		if(p != null){
			while(p.getNext() != null){
				System.out.print(p.getName()+"," + p.getCost() + "---->");
				p = p.getNext();
			}
			System.out.print(p.getName());
		}
		
	}
	public boolean searchData(List l,char data){
		if (l == null){
			return false;
		}
		else if(l.getName() == data){
			return true;
		}
		else{
			return searchData(l.getNext(),data);
		}
	}
}
