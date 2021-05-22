package compilador;

import java.util.ArrayList;

public class AnalizadorLexico {
    

        ArrayList<Token> lista_token = new ArrayList();
        public AnalizadorLexico(ArrayList<Token> lista_token) {
            this.lista_token = lista_token;
        }
        
        public void analizar(String cadena){
            int estado = 0;
            //int decimal = 0;
            int num_token = 0;
            String lexema = "";
            String tipo = "";
            String [] lineas = separador(cadena, '\n');
            
            
            for (int i = 0; i < lineas.length; i++) {
                for (int j = 0; j < lineas[i].length(); j++) {
                    int n_actual, n_siguiente = -1;
                    
                    //obtenemos el numero del caracter en la tabla assci
                    n_actual = lineas[i].codePointAt(j);
                    if (estado == 0) {
                        estado = compara_letra(n_actual);
                    }
                    try{
                        //Obtenemos el numero de la tabla assci del caracter que sea mas 1
                        n_siguiente = lineas[i].codePointAt(j + 1);
                    }catch(Exception e){
                        
                    }
                    switch(estado){
                        case 1:
                            lexema = lexema + lineas[i].charAt(j);
                            if ((n_siguiente > 96 && n_siguiente < 123)||(n_siguiente > 64 && n_siguiente < 91)) {
                              estado = 1;  
                            }else{
                                num_token = 1;
                                tipo = "Cadena";        //asigna que es una cadena
                                estado = 0;
                            }
                           break;
                        case 2:
                            lexema = lexema + lineas[i].charAt(j);
                            if(n_siguiente > 47 && n_siguiente < 58){ //si es un dígito
                                estado = 2 ;
                            }else{
                                num_token = 2;
                                tipo = "Entero"; //Indica que es un número entero
                                estado = 0;
                            }
                           break;
                        case 100: //ignorar espacios en blancos
                            estado = -2;
                        break;
                        case 999:
                            lexema = String.valueOf(lineas[i].charAt(j));
                            num_token = 999;
                             tipo = "Desconocido";
                             estado = 0;
                        break;
                    }//fin switch
                    if (estado == 0){ 
                        lista_token.add(new Token(lexema, num_token, i+1,j+1,tipo)); //recibe lexema, numToken, fila, columna
                        
                        lexema = ""; //limpiar
                        tipo = "";
                    }
                    if (estado == -2){ //salto, tab, espacios
                        estado = 0;
                    }
                }
            }
        }
        
        /**
         * 
         * @param n
         * @return 1 si es letra y return 0 si no
         */
        public int compara_letra(int n){ //recibe elnúmero Ascci
            
            if ((n > 96 && n < 123)||(n > 64 && n < 91)) { //Compara si es letra
                return 1;
            }else if(n > 47 && n < 58){ //si es un dígito
                return 2;
            }else if(n == 32 || n== 13 || n == 9){//compara si es espacio, tab, enter
                return 100;
            }else{  //caracter no válido
                return 999;
            }
        }
        
        
        /**
         * Metodo para separar el texto en cadenas segun el parametro separar.
         * @param texto
         * @param separar
         * @return 
         */
        public String[] separador(String texto, char separar){
            String linea = "";
            int contador = 0;
            for (int i=0;i<texto.length();i++){
                if(texto.charAt(i) == separar){
                    contador++;
                }
            }
            String [] cadenas = new String[contador];
            contador = 0;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) != separar) {
                    linea = linea + String.valueOf(texto.charAt(i));
                }else{
                    cadenas[contador] = linea;
                    contador++;
                    linea = "";
                }
            }
            return cadenas;
        }
    }

