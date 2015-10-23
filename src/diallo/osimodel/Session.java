
public class Session {

	private String data;
	private Transport tran;
	private Presentation pres;
	private int sessionId;
	private int headerLength;
	
	public Session(String data){
		this.data = data;
		sessionId = 1;
	}

	// attach header and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setTransport(new Transport(this.data));
		tran.setSession(this);
		tran.sendDataTo(target);
	}

	// remove header and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception{
		String s = removeHeader(from.getHeaderLengthFromUpperLevel(from, 5));
		System.out.println("Destination " + this);
		setPresentation(new Presentation(s));
		pres.receiveDataFrom(from);
	}

	// attach header to current data
	private String attachHeader(String data){
		return createHeader() + data;
	}

	// create header for current level when sending data to lower level
	private String createHeader(){
		String s = String.valueOf(getSessionId());
		headerLength = s.length();
		return s;
	}
	
	private int getSessionId(){
		sessionId++;
		headerLength = String.valueOf(sessionId).length();
		return sessionId;
	}

	// get length of header
	public int getHeaderLength(){
		return headerLength;
	}

	// remove header when receiving data from lower level
	public String removeHeader(int length){
		return data.substring(length);
	}
	
	public void setPresentation(Presentation pres){
		this.pres = pres;
	}
	
	public Presentation getPresentation(){
		return pres;
	}
	
	public void setTransport(Transport tran){
		this.tran = tran;
	}
	
	public Transport getTransport(){
		return tran;
	}
	
	public String toString(){
		return "Session layer:\t" + data;
	}
	
}
