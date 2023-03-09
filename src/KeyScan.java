import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * Clase para lectura desde teclado de tipos primitivos
 * El tipo Char no está implementado, se debe usar en su valor el tipo String y 
 * posteriormente hacer una conversión de tipos.
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
	 * Pide por consola la entrada de un valor por parte del usuario. si el formato/valor
	 * no es el correcto, se repite la petición hasta completarla satisfactoriamente.
	 * @param msg Texto para solicitar el dato
	 * @param c Tipo de dato solicitado:
	 * 				s:	String. 
	 * 				i:	Int
	 * 				d:	double
	 * 				f:	float
	 * 				b:	Boolean
	 * @return Un objeto del tipo solicitado. (Se recomienda hacer un Cast
	 * en el código llamante , para recuparar corectamente el valor)
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
				    case 'b':	// Tipo boleano
				    	s=s.toUpperCase();
				    	return (s.equals("S"))?true:false;
					case 'i':	// tipo entero
						return Integer.parseInt(s);
					case 'f':	// tipo float
						return Float.parseFloat(s);
					case 'd':	// tipo doble
						return Double.parseDouble(s);				
					case 's':	// String
						return s;
					default:
						termine = true;
				} // switch
			} // comprueba patrón		
			System.out.println("Entrada no válida,\nVuelva a introducir valor:");
		}	
			return null;
	} // readValue
	
	/**
	 * Comprobación sintáctica, mediante expresiones regulares sobre el tipo
	 * de datos solicitado
	 * @param _s		Cadena de texto introducida por el usuario
	 * @param _tipo		Tipo de dato solicitado
	 * @return			True: Formato correcto, False: Formato incorrecto
	 */
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
