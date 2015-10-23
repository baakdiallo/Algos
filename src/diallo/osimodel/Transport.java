import java.util.Random;

public class Transport {
	
	private String data;
	private Network net;
	private Session ses;
	private int headerLength;

	public Transport(String data){
		this.data = data;
	}

	// attach header and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setNetwork(new Network(this.data));
		net.setTransport(this);
		net.sendDataTo(target);
	}

	// remove header and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception{
		String s = removeHeader(from.getHeaderLengthFromUpperLevel(from, 4));
		System.out.println("Destination " + this);
		setSession(new Session(s));
		ses.receiveDataFrom(from);
	}

	// attach header to current data
	private String attachHeader(String data){
		return createHeader() + data;
	}

	// create header for current level when sending data to lower level
	private String createHeader(){
		return getSourceAndDestinationPorts();
	}
	
	private String getSourceAndDestinationPorts(){
		Random r = new Random();
		int src = r.nextInt(100);
		int dest = -1;
		do{
			dest = r.nextInt(100);
		} while(dest == src);
		String ports = String.valueOf(src) + String.valueOf(dest);
		headerLength = ports.length();
		
		return ports;
	}

	// get length of header
	public int getHeaderLength(){
		return headerLength;
	}

	// remove header when receiving data from lower level
	private String removeHeader(int length){
		return data.substring(length);
	}
	
	public void setNetwork(Network net){
		this.net = net;
	}
	
	public Network getNetwork(){
		return net;
	}
	
	public void setSession(Session ses){
		this.ses = ses;
	}
	
	public Session getSession(){
		return ses;
	}
	
	public String toString(){
		return "Transport layer:\t" + data;
	}
	
}
