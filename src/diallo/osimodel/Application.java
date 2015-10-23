
public class Application {
	
	private String data;
	private Presentation pres;
	private OSI osi;
	private int headerLength;
	
	public Application(String data){
		this.data = data;
	}
	
	// attach header and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setPresentation(new Presentation(this.data));
		pres.setApplication(this);
		pres.sendDataTo(target);
	}
	
	// remove header and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception{
		String s = removeHeader(from.getHeaderLengthFromUpperLevel(from, 7));
		System.out.println("Destination " + this);
		setOSI(new OSI(s));
		osi.receiveDataFrom(from);
	}
	
	// attach header to current data
	private String attachHeader(String data){
		return createHeader(data) + data;
	}
	
	// create header for current level when sending data to lower level
	private String createHeader(String data){
		String s = String.valueOf(data.length());
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
	
	public void setPresentation(Presentation pres){
		this.pres = pres;
	}
	
	public Presentation getPresentation(){
		return pres;
	}
	
	public void setOSI(OSI osi){
		this.osi = osi;
	}
	
	public OSI getOSI(){
		return osi;
	}
	
	public String toString(){
		return "Application layer:\t" + data;
	}

}
