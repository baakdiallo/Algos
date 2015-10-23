
public class Physical {

	private String data;
	private Physical sender, receiver;
	private DataLink dl;
	
	public Physical(){
		
	}
	
	public Physical(String data){
		this.data = data;
	}

	// send data to target physical layer
	public void sendDataTo(Physical target){
		System.out.println("Source " + this);
		System.out.println();
		target.receiveDataFrom(this);
	}

	// receive data from source physical layer
	public void receiveDataFrom(Physical from){
		from.setReceiver(this);
		this.setSender(from);
		this.data = from.data;
		System.out.println();
		System.out.println("Destination " + this);
		setDataLink(new DataLink(from.data));
		try {
			dl.receiveDataFrom(from);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get length of header from a specific upper level
	public int getHeaderLengthFromUpperLevel(Physical from, int level) throws Exception{
		if(level < 3 || level > 7)
			throw new Exception("Impossible layer level.");
		int length = 0;
		switch(level){
		case 3:
			//System.out.println(from.getDataLink());
			length = from.dl.getNetwork().getHeaderLength();
			break;
		case 4:
			length = from.dl.getNetwork().getTransport().getHeaderLength();
			break;
		case 5:
			length = dl.getNetwork().getTransport().getSession().getHeaderLength();
			break;
		case 6:
			length = dl.getNetwork().getTransport().getSession().getPresentation().getHeaderLength();
			break;
		case 7:
			length = dl.getNetwork().getTransport().getSession().getPresentation().getApplication().getHeaderLength();
			break;
		}
		return length;
	}
	
	public void setDataLink(DataLink dl){
		this.dl = dl;
	}
	
	public DataLink getDataLink(){
		return dl;
	}
	
	private void setSender(Physical sender){
		this.sender = sender;
	}
	
	public Physical getSender(){
		return sender;
	}
	
	private void setReceiver(Physical receiver){
		this.receiver = receiver;
	}
	
	public Physical getReceiver(){
		return receiver;
	}
	
	public String toString(){
		return "Physical layer:\t" + data;
	}
	
}
