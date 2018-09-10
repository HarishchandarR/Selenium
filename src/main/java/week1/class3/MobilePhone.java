package week1.class3;

public class MobilePhone {
private int currentbalance;
public MobilePhone() {
this.currentbalance=9;
}
	public void SendSMS(long mobilenumber, String sms) throws Exception {
		if (this.currentbalance<1) {
			throw new Exception("Insufficient currentBalance");}
			this.currentbalance-=1;
		}
	public void CallContact(long mobilenumber) throws Exception {
		if (this.currentbalance<2) {
			throw new Exception("Insufficient currentBalance");}
			this.currentbalance-=2;
	}
	
	}
	

