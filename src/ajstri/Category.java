package ajstri;

import java.util.ArrayList;

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
	
	public static ArrayList<String> getNames() {
		ArrayList<String> arr = new ArrayList<String>();
		for(Category c : Category.values()) arr.add(c.getName());
		return arr;
	}
	
}
