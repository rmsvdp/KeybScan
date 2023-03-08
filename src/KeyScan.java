import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * Clase para lectura desde teclado de tipos primitivos
 * @author RMS
 *
 */
public class KeyScan {

	/**
	 * Objeto scanner para leer de teclado. Se declara static para que no se cierre el stream.
	 */
	public static Scanner sc = new Scanner(System.in);
	/**
	 * Constructor para instanciar el objeto.	
	 */
	public KeyScan() {
		super();
	}

	/**
	 * Pide por consola la entrada de un valor por parte del usuario
	 * @param msg
	 * @param c
	 * @return
	 */
	public  Object readValue(String msg,char c) {
		
		String s="";
		boolean termine = false;

		while (!termine)
		{ // bucle
			System.out.print(msg);
			if (c=='b') System.out.print("(S)í,(N)o");
			System.out.print("? ");
			s =sc.nextLine();
			if (parse(s,c)) {
				switch (c) {
				    case 'b':
				    	s=s.toUpperCase();
				    	return (s.equals("S"))?true:false;
					case 'i':
						return Integer.parseInt(s);
					case 'f':
						return Float.parseFloat(s);
					case 'd':
						return Double.parseDouble(s);				
					case 's':
						return s;
					default:
						termine = true;
				} // switch
			} // comprueba patrón		
			System.out.println("Entrada no válida,\nVuelva a introducir valor:");
		}	
			return null;
	} // readValue
	
	private boolean parse(String _s, char _tipo) {
		boolean result = false;
		String patron ="";
		
		switch(_tipo ) {
		case 's': return true;
		case 'i':
			patron ="^-?\\d+$";
			break;
		case 'b':
			_s = _s.toUpperCase();
			patron ="^[S,N]$";
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
