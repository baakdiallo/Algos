
public class Presentation {

	private String data;
	private Session ses;
	private Application app;
	private int headerLength;
	private String[] types = new String[26]; 

	public Presentation(String data){
		types = makeTypes();
		this.data = data;
	}

	// attach header and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setSession(new Session(this.data));
		ses.setPresentation(this);
		ses.sendDataTo(target);
	}

	// remove header and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception{
		String s = removeHeader(from.getHeaderLengthFromUpperLevel(from, 6));
		System.out.println("Destination " + this);
		setApplication(new Application(s));
		app.receiveDataFrom(from);
	}
	
	// attach header to current data
	private String attachHeader(String data){
		return createHeader(data) + data;
	}
	
	// create header for current level when sending data to lower level
	private String createHeader(String data){
		return getType(data);
	}
	
	private String[] makeTypes(){
		for(int i = 0; i < 26; i++){
			types[i] = "t" + String.valueOf((char)('A' + i));
		}
		return types;
	}
	
	private String getType(String data){
		char c = data.charAt(0);
		String s = types[((int) c) % types.length];
		headerLength = s.length();
		return s;
	}
	
	// get length of header
	public int getHeaderLength(){
		return headerLength;
	}
	
	// remove header when receiving data from lower level
	public String removeHeader(int length){
		return data.substring(length);
	}
	
	public void setApplication(Application app){
		this.app = app;
	}
	
	public Application getApplication(){
		return app;
	}
	
	public void setSession(Session ses){
		this.ses = ses;
	}

	public Session getSession() {
		return ses;
	}
	
	public String toString(){
		return "Presentation Layer:\t" + data;
	}
	
}
