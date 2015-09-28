package diallo.fun;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStackArray tsa = new ThreeStackArray();
		tsa.pushFirst(5);
		tsa.pushThird(7);
		System.out.println(tsa);
		System.out.println(tsa.sizeFirst());
		tsa.pushFirst(-4);
		System.out.println(tsa);
		System.out.println(tsa.sizeFirst());
		System.out.println(tsa.popFirst());
		System.out.println(tsa);
		System.out.println(tsa.sizeFirst());
		tsa.pushFirst(1);
		tsa.pushFirst(2);
		tsa.pushFirst(3);
		tsa.pushFirst(4);
		tsa.pushFirst(5);
		tsa.pushFirst(6);
		System.out.println(tsa);
	}

}
