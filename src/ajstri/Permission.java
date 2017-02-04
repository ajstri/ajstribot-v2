package ajstri;

public enum Permission {
	Everyone(new String[]{"e"}),
	AJ(new String[]{"202422697173581824"}),
	Admins(new String[]{"188813019017379840", "106591269798608896", "202422697173581824"}),
	Rum(new String[]{"200642343445987328"}),
	Sin(new String[]{"238637788583428096"}),
	Crock(new String[]{"188813019017379840"}),
	;
	
	private String[] p;
	
	private Permission(String[] p) {
		this.p = p;
	}
	
	public String[] getUsers() {
		return p;
	}
}