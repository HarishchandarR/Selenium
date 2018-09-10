package week1.class3;

public class Moto {

	//public static void main(String[] args) {
	String sms="Hi";
	public void SendMessage() {
		System.out.println(sms);

	}
	int mobilenum = 123456;
	public void MakeCalls(int number) {
		System.out.println(number);

	}
	private String motoService(String offer) {
		/*Moto ghi=new Moto();
			ghi.MotoService(offer);*/
		return offer;
		//System.out.println(offer);
	}
	public static void main(String[] args) {
		Moto m = new Moto();
		m.motoService("");
	}
	//}
}
