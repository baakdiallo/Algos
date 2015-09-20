
public class List {
	private Recording currentRecording;
	private List nextRecording;
	List(Recording currentRecording,List nextRecording){
		this.currentRecording = currentRecording;
		this.nextRecording = nextRecording;
	}
	static Recording getTheCurrentRecordingOfTheList(List l){
		return l.currentRecording;
	}
	static List getTheNextRecordingOfTheList(List l){
		return l.nextRecording;
	}
	static void setTheCurrentRecordingOfTheList(Recording currentRecording,List l){
		l.currentRecording = currentRecording;
	}
	static void setTheNextRecordingOfTheList(List nextRecording,List l){
		l.nextRecording = nextRecording;
	}
	static List insertListBeforeTheFirst(List l1,Recording currentRecording){
		List l2 = new List(currentRecording,null);
		return new List(l2.currentRecording,l1);
	}
	static List insertListAfterTheLast(List l1,Recording currentRecording){
		List l2 = new List(currentRecording,null);
		if(l1 == null){
			return l2;
		}
		else{
			List p = l1;
			while(p.nextRecording != null){
				p = p.nextRecording;
			}
			p.nextRecording = l2;
			return l1;
		}
	}
	static void displayTheList(List l){
		List p = l;
		while(p != null){
			p.currentRecording.displayTheRecording();
			p = p.nextRecording;
		}
	}
	static List searchListByTheRecordingCode(List l,int code){
		List p = l;
		boolean found = false;
		while(p != null && !found){
			if(p.currentRecording.getCodeOfTheRecording() == code){
				found = true;
			}
			else{
				p = p.nextRecording;
			}
		}
		return p;
	}
	static void defineDepositTypeTransaction(List l){
		l.currentRecording.setTypeOfTheRecording(Transaction.deposit);;
	}
	static void defineWithdrawalTypeTransaction(List l){
		l.currentRecording.setTypeOfTheRecording(Transaction.withdrawal);
	}
	static void operationOverTheBalance(List l,int balance){
		l.currentRecording.OperationIntoTheRecording(balance);
	}
}
