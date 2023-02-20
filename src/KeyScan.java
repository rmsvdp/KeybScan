import java.util.Scanner;
import java.util.regex.Pattern;

public class KeyScan {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a;
		float f;
		double d;
		String s;
		
		f= (float) readValue("numero real",'f');
		a= (int) readValue("numero entero",'i');
		d= (double) readValue("numero doble",'d');
		s = (String) readValue("cadena",'s');
		System.out.println(a);
		System.out.println(f);
		System.out.println(d);
		System.out.println(s);
	}


	public static Object readValue(String msg,char c) {
		
		String s="";
		boolean termine = false;
		//Scanner sc = new Scanner(System.in);
		while (!termine)
		{ // bucle
			System.out.print(msg+"?");
			s =sc.nextLine();
			switch (c) {			
				case 'i':
					if (parse(s,c))
					return Integer.parseInt(s);
				case 'f':
					if (parse(s,c))
					return Float.parseFloat(s);
				case 'd':
					if (parse(s,c))
					return Double.parseDouble(s);				
				case 's':
					return s;
				default:
					termine = true;
			} // switch
			System.out.println("Formato de entrada no válida,\nVuelva a introducir valor:");
		}	
			return null;
	} // readValue
	
	public static boolean parse(String _s, char _tipo) {
		boolean result = false;
		String patron ="";
		switch(_tipo ) {
		case 'i':
			patron ="^-?\\d+$";
			break;
		case 'd':
		case 'f':
			patron = "^-?\\d+(\\.\\d+)?$";
			break;
		}
		result = Pattern.matches(patron,_s);
		return result;
	}
} // Class
