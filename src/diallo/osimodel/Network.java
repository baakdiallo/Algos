import java.util.Random;


public class Network {

	private String data;
	private DataLink dl;
	private Transport tran;
	private int headerLength;
	
	public Network(String data){
		this.data = data;
	}

	// attach header and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setDataLink(new DataLink(this.data));
		dl.setNetwork(this);
		dl.sendDataTo(target);
	}

	// remove header and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception{
		String s = removeHeader(from.getHeaderLengthFromUpperLevel(from, 3));
		System.out.println("Destination " + this);
		setTransport(new Transport(s));
		tran.receiveDataFrom(from);
	}

	// attach header to current data
	private String attachHeader(String data){
		return createHeader() + data;
	}

	// create header for current level when sending data to lower level
	private String createHeader(){
		return getSourceAndDestinationIPAddresses();
	}
	
	private String getSourceAndDestinationIPAddresses(){
		String src = generateIPAddress();
		String dest = "";
		do{
			dest = generateIPAddress();
		} while (src.equals(dest));
		String ips = src + dest;
		headerLength = ips.length();
		
		return ips;
	}
	
	private String generateIPAddress(){
		Random r = new Random();
		int counter = 0;
		String ip = "";
		while(counter < 4){
			ip += String.valueOf(r.nextInt(256)) + ".";
			counter++;
		}
		ip = ip.substring(0, ip.length() - 1);
		return ip;
	}

	// remove header when receiving data from lower level
	private String removeHeader(int length){
		return data.substring(length);
	}

	// get length of header
	public int getHeaderLength(){
		return headerLength;
	}
	
	public void setTransport(Transport tran){
		this.tran = tran;
	}
	
	public Transport getTransport(){
		return tran;
	}
	
	public void setDataLink(DataLink dl){
		this.dl = dl;
	}
	
	public DataLink getDataLink(){
		return dl;
	}
	
	public String toString(){
		return "Network layer:\t" + data;
	}
	
}
