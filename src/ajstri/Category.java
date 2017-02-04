package ajstri;

public enum Category {
	Generic("generic"),
	Admin("admin"),
	Custom("custom"),
	Fun("fun");
	
	private String s;
	
	private Category(String s) {
		this.s = s;
	}
	
	public String getName() {
		return s;
	}
	
}
