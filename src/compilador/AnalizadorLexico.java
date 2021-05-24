package compilador;

import java.util.ArrayList;

public class AnalizadorLexico {

    ArrayList<Token> lista_token = new ArrayList();
    ArrayList<Token> lista_errores = new ArrayList();
    String[] palabrasReservadas = {"automatic", "break", "case", "class", "def", "default", "double", "else", "equals", "exit", "false", "float", "for", "if", "input", "int", "long",
        "main", "new", "print", "private", "rotateLeft", "rotateRight", "on", "off", "public", "return", "static", "stop", "string",
        "switch", "this", "true", "void", "while"};

    String[][] operadoresArit = {{"+", "OpArit Suma"}, {"-", "OpArit Resta"}, {"/", "OpArit División"}, {"*", "OpArit División"}, {"%", "OpArit Resto"}};
    String[][] operadoresRela = {{"<", "OpRel Menor"}, {">", "OpRel Mayor"}, {"==", "OpRel igual"}, {"<=", "OpRel Menor igual"}, {">=", "OpRel Mayor igual"}, {"!=", "OpRel Diferente"}};
    String[][] operadoresLogicos = {{"&&", "OpLog And"}, {"||", "OpLog Or"}, {"!", "OpLog Not"}};
    String[][] operadoresAgrupacion = {{"(", "Paréntesis de apertura"}, {")", "Paréntesis de cierre"}, {"[", "Corchete de apertura"}, {"]", "Corchete de cierre"}, {"{", "Llave de apertura"}, {"}", "Llave de cierre"}};
    String[][] simbEspeciales = {{";", "Simbolo fin instrucción"}, {":", "Simbolo dos puntos"}, {"_", "Simbolo guión bajo"}, {"'", "Simbolo comilla simple"}, {",", "Simbolo coma"}, {".", "Simbolo punto"}, {"@", "Simbolo arroba"}};

    public AnalizadorLexico(ArrayList<Token> lista_token, ArrayList<Token> lista_errores) {
        this.lista_token = lista_token;
        this.lista_errores = lista_errores;
    }

    public void analizar(String cadena) {
        int estado = 0;
        //int decimal = 0;
        int num_token = 0;
        String lexema = "";
        String tipo = "";
        String[] lineas = separador(cadena, '\n');
        boolean match;

        for (int i = 0; i < lineas.length; i++) { //recorrer todas las líneas
            for (int j = 0; j < lineas[i].length(); j++) { //recorrer letra por letra de la linea
                int n_actual, n_siguiente = -1;

                //obtenemos el numero del caracter en la tabla assci
                n_actual = lineas[i].codePointAt(j);
                if (estado == 0) {
                    estado = definir_caracter(n_actual);
                }
                try {
                    //Obtenemos el numero de la tabla assci del caracter que sea mas 1
                    n_siguiente = lineas[i].codePointAt(j + 1);
                } catch (Exception e) {

                }
                switch (estado) {
                    case 1:
                        lexema = lexema + lineas[i].charAt(j);
                        if ((n_siguiente > 96 && n_siguiente < 123) || (n_siguiente > 64 && n_siguiente < 91 || (n_siguiente > 47 && n_siguiente < 58) || n_siguiente == 95)) {
                            estado = 1;
                        } else {
                            for (String palabrasReservada : palabrasReservadas) {
                                if (lexema.equals(palabrasReservada)) {
                                    //si es reservada
                                    tipo = "Palabra reservada";
                                    estado = 0;
                                }
                            }
                            if (!tipo.equals("Palabra reservada")) {
                                match = lexema.matches("[a-zA-Z]+[\\w_]*");  //Identificador
                                if (match) {
                                    tipo = "Identificador";
                                    estado = 0;
                                } else {
                                    tipo = "Identificador invalido ";        //asigna que es una cadena
                                    estado = 404;
                                }
                            }
                        }
                        break;
                    case 2://números
                        lexema = lexema + lineas[i].charAt(j);
                        if (n_siguiente > 47 && n_siguiente < 58 || n_siguiente == 46 || n_siguiente == 44 /*|| n_siguiente == 45 || n_siguiente == 43*/) { //si es numero
                            estado = 2;
                        } else {
                            if (lexema.matches("[-+]?[0-9]*[.]?[0-9]+")) {
                                tipo = "Número";
                            } else if (lexema.matches("[-+]?[0-9]*[.]$")) {
                                tipo = "Número invalido, se esperaba un digito despues del punto ";
                                estado = 404;
                                break;
                            } else if (lexema.matches("[+-]?[.0-9]{0,}")) {
                                tipo = "Número invalido, no es posible tener más de un punto. Error ";
                                estado = 404;
                                break;
                            } else if (lexema.matches("[+-]?[,.0-9]{0,}")) {
                                tipo = "Número invalido, no es posible tener una coma(,). Error ";
                                estado = 404;
                                break;
                            } else /*if (lexema.matches("[-+0-9]{0,}")) {
                                tipo = "Número";
                                estado = 0;
                                break;
                            }else if (lexema.matches("[-+,.0-9]{0,}")) {
                                tipo = "Número invalido, no es posible tener más de un simbolo(+ ó -). Error ";
                                estado = 404;
                                break;
                            }else*/{
                                tipo = "Número desconocido ";
                                estado = 404;
                                break;
                            }
                            estado = 0;
                            num_token = 2;
                        }
                        break;
                    case 3: //signo =
                        lexema = String.valueOf(lineas[i].charAt(j));
                        tipo = "Signo asignación";
                        estado = 0;
                        break;
                    case 4: //operadores logicos
                        lexema = lexema + lineas[i].charAt(j);
                        if (n_siguiente == 32 || n_siguiente == 13 || n_siguiente == 9) {//compara si es espacio, tab, enter
                            estado = 4;
                        } else {
                            for (String[] operadoresLogico : operadoresLogicos) {
                                if (lexema.equals(operadoresLogico[0])) {
                                    //
                                    tipo = operadoresLogico[1];
                                    estado = 0;
                                    break;
                                }
                            }
                        }
                        break;
                    case 5: //operadores logicos
                        lexema = lexema + lineas[i].charAt(j);
                        if (n_siguiente == 61) {// determina <=, >=, ==, !=
                            estado = 5;
                        } else {
                            for (String[] OperadorRela : operadoresRela) {
                                if (lexema.equals(OperadorRela[0])) {
                                    tipo = OperadorRela[1];
                                    estado = 0;
                                    break;
                                } else {
                                    tipo = "Caracter invalido ";
                                    estado = 404;
                                }
                            }
                        }
                        break;
//                    case 6: //Estructuras
//                        lexema = lexema + lineas[i].charAt(j);
//                        if (n_siguiente == 61) {// determina <=, >=, ==, !=
//                            estado = 5;
//                        } else {
//                            for (String[] OperadorRela : operadoresRela) {
//                                if (lexema.equals(OperadorRela[0])) {
//                                    tipo = OperadorRela[1];
//                                    estado = 0;
//                                    break;
//                                } else {
//                                    tipo = "Desconocido caso 5";
//                                    estado = 0;
//                                }
//                            }
//                        }
//                        break;
                    case 100: //ignorar espacios en blancos
                        estado = -2;
                        break;
                    case 999:
                        lexema = String.valueOf(lineas[i].charAt(j));

                        for (String[] operadoresArit1 : operadoresArit) {
                            if (lexema.equals(operadoresArit1[0])) {
                                //
                                tipo = operadoresArit1[1];
                                estado = 0;
                                break;
                            }
                        }
                        for (String[] operadoresRela1 : operadoresRela) {
                            if (lexema.equals(operadoresRela1[0])) {
                                //
                                tipo = operadoresRela1[1];
                                estado = 0;
                                break;
                            }
                        }

                        for (String[] operadoresAgrupacion1 : operadoresAgrupacion) {
                            if (lexema.equals(operadoresAgrupacion1[0])) {
                                //
                                tipo = operadoresAgrupacion1[1];
                                estado = 0;
                                break;
                            }
                        }
                        for (String[] simbEspeciale : simbEspeciales) {
                            if (lexema.equals(simbEspeciale[0])) {
                                //
                                tipo = simbEspeciale[1];
                                estado = 0;
                                break;
                            }
                        }

                        //                          num_token = 999;
//                            tipo = "Desconocido";
//                            estado = 0;
                        break;
                }//fin switch
                if (estado == 0) {
                    lista_token.add(new Token(lexema, num_token, i + 1, j + 1, tipo)); //recibe lexema, numToken, fila, columna

//                    for (String palabrasReservada : palabrasReservadas) {
//                        if (lexema.equals(palabrasReservada)) {
//                                    //si es reservada
//                            ///tipo = "Palabra reservada";
//                            estado = 6;
//                            
//                        }
//                    }
                    lexema = ""; //limpiar
                    tipo = "";
                }

                if (estado == 404) {// Se definen los errores
                    lista_errores.add(new Token(tipo, i + 1));
                    lista_token.add(new Token(lexema, num_token, i + 1, j + 1, tipo));
                    lexema = ""; //limpiar
                    tipo = "";
                    estado = 0;
                }

                if (estado == -2) { //salto, tab, espacios
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
    public int definir_caracter(int n) { //recibe elnúmero Ascci

        if ((n > 96 && n < 123) || (n > 64 && n < 91) || n == 95) { //Compara si es letra o _
            return 1;
        } else if ( n == 45 || n == 43 ) { //si es un signo  -=45, + =43
            return 999;
        } else if (n > 47 && n < 58 || n == 46 || n == 45 || n == 43 || n == 44) { //si es un dígito  -=45, + =43, .=46, ,=44 
            return 2;
        } else if (n == 32 || n == 13 || n == 9) {//compara si es espacio, tab, enter
            return 100;
        } else if (n == 61) { //si es operador asig (=)
            return 3;
        } else if (n == 38 || n == 179 || n == 33) { //para and 38= (&&), or(||) = 179, not(!) =33
            return 4;
        } else if (n == 60 || n == 62 || n == 33 || n == 61) { //
            return 5;
        } else {  //caracter no válido
            return 999;
        }
    }

    /**
     * Metodo para separar el texto en cadenas segun el parametro separar.
     *
     * @param texto
     * @param separar
     * @return
     */
    public String[] separador(String texto, char separar) {
        String linea = "";
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == separar) {
                contador++;
            }
        }
        String[] cadenas = new String[contador];
        contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != separar) {
                linea = linea + String.valueOf(texto.charAt(i));
            } else {
                cadenas[contador] = linea;
                contador++;
                linea = "";
            }
        }
        return cadenas;
    }
}
