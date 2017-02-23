package ajstri;

public enum Permission {
	Everyone(new String[]{"e"}),
	Admins(new String[]{"a"}),
	Ban(new String[]{"b"}),
	;
	
	private String[] p;
	
	private Permission(String[] p) {
		this.p = p;
	}
	
	public String[] getUsers() {
		return p;
	}
}