import java.util.Random;

public class DataLink {

	private String data;
	private Physical phys;
	private Network net;
	
	public DataLink(String data){
		this.data = data;
	}

	// attach header and trailer and send data from lower level
	public void sendDataTo(Physical target){
		data = attachHeader(data);
		System.out.println("Source " + this);
		setPhysical(new Physical(this.data));
		phys.setDataLink(this);
		phys.sendDataTo(target);
	}

	// remove header and trailer and receive data from upper level
	public void receiveDataFrom(Physical from) throws Exception {
		String s = removeHeaderAndTrailer(data);
		System.out.println("Destination " + this);
		setNetwork(new Network(s));
		net.receiveDataFrom(from);
	}

	// attach header to current data
	private String attachHeader(String data){
		return createHeader() + data + createTrailer();
	}
	
	// create header for current level when sending data to lower level
	private String createHeader(){
		return getSourceAndDestinationMACAddresses();
	}
	
	private String getSourceAndDestinationMACAddresses(){
		char[] mac = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String src = getMACAddress(mac);
		String dest = "";
		do{
			dest = getMACAddress(mac);
		} while(src.equals(dest));
		return src + dest;
	}
	
	private String getMACAddress(char[] mac){
		int length = mac.length;
		Random r = new Random();
		int counter = 0;
		String s = "";
		while(counter < 6){
			s += String.valueOf(mac[r.nextInt(length)]) + String.valueOf(mac[r.nextInt(length)]) + ":";
			counter++;
		}
		s = s.substring(0, s.length() - 1);
		return s;
	}
	
	// create trailer for current level when sending data to lower level
	private String createTrailer(){
		return String.valueOf((char) ('A' + new Random().nextInt(26)));
	}

	// remove header and trailer when receiving data from lower level (Data Link)
	private String removeHeaderAndTrailer(String data){
		return data.substring(34, data.length() - 1);
	}
	
	public void setPhysical(Physical phys){
		this.phys = phys;
	}
	
	public Physical getPhysical(){
		return phys;
	}
	
	public void setNetwork(Network net){
		this.net = net;
	}
	
	public Network getNetwork(){
		return net;
	}
	
	public String toString(){
		return "Data Link layer:\t" + data;
	}
	
}
