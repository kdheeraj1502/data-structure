package companies.stream;

public class CloneClass implements Cloneable{
	public int i = 12;
	public int j = 45;
	public int k = 78;
	public int l = 8;
	public int m = 34;
	public int n = 10;
	
	
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneClass cc = new CloneClass();
		CloneClass cl = (CloneClass) cc.clone();
		System.out.println(cc.i);
		System.out.println(cl.i);
		cl.i = 88888;
		System.out.println(cc.i);
		System.out.println(cl.i);
	}
}
