
public class OSI {
	
	private String data, name;
	private Application app;
	private boolean isReceived;

	public OSI(){
		isReceived = false;
	}
	
	public OSI(String data){
		this.data = data;
		app = new Application(data);
		isReceived = false;
	}
	
	public OSI(Application app){
		this.app = app;
	}
	
	public void sendDataTo(String data, Physical target) throws Exception{
		
		// size of message should be less than 1024B
		if(data.getBytes().length > 1024)
			throw new Exception("Your input is too large...");
		
		// initialize application layer
		app = new Application(data);
		
		// set message data
		setData(data);
		setName("Sending");
		
		// start transmission
		beginTransmission();
		
		// send data from lower level
		app.sendDataTo(target);
	}
	
	// receive data and acknowledge reception
	public void receiveDataFrom(Physical from){
		setName("Received");
		isReceived = true;
		acknowledgeReception();
	}
	
	// check whether or not message is received
	public boolean isReceived(){
		return isReceived;
	}
	
	private void beginTransmission(){
		System.out.println("=================================================");
		System.out.println(this);
		System.out.println("=========");
		System.out.println();
	}
	
	private void acknowledgeReception(){
		System.out.println();
		System.out.println("=========");
		System.out.println(this);
		System.out.println("=================================================");
	}
	
	public void setApplication(Application app){
		this.app = app;
	}
	
	public Application getApplication(){
		return app;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	private void setData(String data){
		this.data = data;
	}
	
	public String toString(){
		return name + ":\t" + data;
	}
}
