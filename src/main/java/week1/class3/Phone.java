package week1.class3;

public class Phone {

	public static void main(String[] args) throws Exception {
		
		MobilePhone ghi = new MobilePhone();
		ghi.SendSMS(9000812341l,"Good Morning! Happy Sunday!");
		ghi.SendSMS(9000812342l,"Good Morning! Happy Sunday!");
		ghi.SendSMS(9000812343l,"Good Morning! Happy Sunday!");
		ghi.SendSMS(9000812344l,"Good Morning! Happy Sunday!");
		ghi.SendSMS(9000812345l,"Good Morning! Happy Sunday!");
ghi.CallContact(9000812341l);
ghi.CallContact(9000812342l);
ghi.CallContact(9000812343l);
ghi.CallContact(9000812344l);


	}

}
