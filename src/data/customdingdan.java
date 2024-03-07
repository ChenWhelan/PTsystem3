package data;
/**
 * 
 */

/**
 * @author techlife
 * 
 */
public class customdingdan {
	

	private String name = new String();
	private String address = new String();
	private String phone = new String();
	private String item = new String();
	private String shop = new String();
	private String amount = new String();
	private String riderid = new String();
	private String num = new String();
	public customdingdan(){
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getShop() {
		return shop;
	}
	
	public void setShop(String shop) {
		this.shop = shop;
	}

	public boolean verifyPwd(String phone) {
		if (! this.phone.equals(phone)){
			return false; 
		}
		
		return true;
	}

	public String getRiderId() {
		return riderid;
	}
	
	public void setRiderId(String riderid) {
		this.riderid = riderid;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAdress(String address) {
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	}
	


	




