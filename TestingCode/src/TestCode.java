
public class TestCode {

	public static void main (String[] args){
		System.out.println(changePi("xpix"));
		System.out.println(changePi("pipi"));
		System.out.println(changePi("xxpipixx"));
	}
	
	
	public static String changePi(String str) {
		if(str.length() <= 2){
			if(str.equals("pi")){
				return "3.14";
			}else{
				return str;
			}
		}else if(str.indexOf("pi") >= 0){
			if(str.indexOf("pi") == 0){
				return changePi(str.substring(0, str.indexOf("pi") + 2)) + changePi(str.substring(str.indexOf("pi") + 2));
			}else{
				return changePi(str.substring(0, str.indexOf("pi"))) + changePi(str.substring(str.indexOf("pi")));
			}
		}else{
			return str;
		}
	}
}
