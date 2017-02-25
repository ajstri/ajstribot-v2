package ajstri;

public enum Category {
	Generic("generic"),
	Admin("admin"),
	Fun("fun"),
	Music("music");
	
	private String s;
	
	private Category(String s) {
		this.s = s;
	}
	
	public String getName() {
		return s;
	}
}
