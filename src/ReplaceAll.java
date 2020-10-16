
public class ReplaceAll {
public static void main(String[] args) {
	String defaultValue =args[0];
	System.out.println("before => "+defaultValue);
	defaultValue = defaultValue.replaceAll("\"","\\\\\"");
	System.out.println("after => "+defaultValue);
	System.out.println(System.getProperty("java.io.tmpdir"));
}
}
