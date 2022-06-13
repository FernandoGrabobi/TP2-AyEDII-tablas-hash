package CASASALCARRIA;

public class tablaDeDispersion {
    
    static final int TAMTABLA = 101;
    private static int numElementos;
    private static double factorCarga;
    private static casaRural [] tabla;
    
        //Constructor    
        public tablaDeDispersion(){
        tabla = new casaRural[TAMTABLA];
        for(int j = 0; j < TAMTABLA ; j++)
        tabla[j] = null;
        numElementos = 0;
        factorCarga = 0.0;
        }
        
        public static int direccion(String clave){
            int i = 0, p;
            long d;
            d = transformaCadena(clave);
            p = (int)(d % TAMTABLA);
            
            while (tabla[p]!= null && !tabla[p].elCodigo().equals(clave)) {
                i++;
                p = p + i*i;
                p = p % TAMTABLA; // considera el array como circular
            }
        return p;
        }
        
        static long transformaCadena(String c){
            long d;
            d = 0;
            for (int j = 0; j < Math.min(10,c.length()); j++){
            d = d * 27 + (int)c.charAt(j);
            }
            if (d < 0){ d = -d;}
         return d;
        }

        //Método Insertar
        public void insertar(casaRural r){
            int posicion;
            posicion = direccion(r.elCodigo());
            tabla[posicion] = r;
            numElementos++;
            factorCarga = (double)(numElementos)/TAMTABLA;
            if (factorCarga > 0.5){
                System.out.println("\n!! Factor de carga supera el 50%.!!"+ " Conviene aumentar el tamaño." );
            }

        }
            
        //Método Buscar
        public casaRural buscar(String clave){
            casaRural pr;
            int posicion;
            posicion = direccion(clave);
            pr = tabla[posicion];
            if (pr != null)
            if (! pr.esAlta) pr = null;
        return pr;
        }

        //Método Eliminar
        public void eliminar(String clave){
            int posicion;
            posicion = direccion(clave);
            if (tabla[posicion] != null)
            System.out.println("La casa fue eliminada correctamente");
            tabla[posicion].esAlta = false;
        }
        
    
    
    }
