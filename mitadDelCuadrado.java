/**
 * EJERCICIO 12.1 - Pag 348 y 349
 * Función hash: Método de la mitad del cuadrado
 * Original code from ESTRUCTURAS DE DATOS EN JAVA 
 * Creadores del codigo: Grabobi Fernando-Mendoza Jeremias-Ferro Marco
 */
import java.io.*;

////import java.lang.Number;
class Main {
  
  static final int M = 1024; 

  ////FUNCION QUE TRASNFORMA LA CLAVE
  static Double transformaClave(String clave) {
    
    Double d = 0.0;
    
    for (int j = 0; j < Math.min(clave.length(),10); j++) {
	    
      System.out.print("Posicion: "+ j);
      System.out.print(" --- ");
      System.out.println("Letra: "+clave.charAt(j)+" - "+(int)clave.charAt(j));  
      d = d * 27 + (int)clave.charAt(j);
    }
    if (d < 0) d = -d;
    return d;
    }

  
  ////FUNCION DE DISPERSION
  static int dispersion(Double x) {
	 Double t,k;
   int resultado;
    t = Math.pow(x,2);
    System.out.println("suma de valores: "+t);
    k = t / 1000; /// Nos permite elegir los 3 digitos que nos convenga del numero
    resultado = (int)(t % 1000); /// nos devuelve el modulo del numero obteniendo 3 digitos  de tipo entero 
    return resultado;
  }

  
  ////MAIN
  public static void main(String[]a) throws IOException {
    
	  String clave;
    Double valor;
    int coso;
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
    for (int k = 1; k <= 10; k++) {
      
      clave = "";
      valor = 0.0;
      
      System.out.print("\nClave a dispersar: ");
      
      clave = entrada.readLine();
      valor = transformaClave(clave);
      coso = dispersion(valor);
      
      System.out.println("Dispersion de la clave " + clave + " \t " + coso);
      
    }
  }
}
