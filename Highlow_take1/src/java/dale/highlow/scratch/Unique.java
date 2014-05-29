package dale.highlow.scratch;

public class Unique {

	public static void main(String[] args) {
		Unique u1 = new Unique();
		Unique u2 = new Unique();
		
		System.out.println("u1: " + u1.hashCode() + " u2: " + u2.hashCode());
		System.out.println(u1.hashCode() == u2.hashCode());
		System.out.println(u1.getClass().hashCode() == u2.getClass().hashCode());
		
		System.out.println(u1.getClass().getCanonicalName());
	}
}
