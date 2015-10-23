
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		OSI osi = new OSI();
		
		String message1 = "Saliou";
		String message2 = "Message2";
		String message3 = "Nakawar";
		
		Physical target = new Physical();
		
		//osi.sendDataTo(message1, target);
		//osi.sendDataTo(message2, target);
		osi.sendDataTo(message3, target);
		
	}

}
