package org.mp.sesion06.evaluador;

import org.mp.sesion05.colas.Queue;
import org.mp.sesion05.pilas.Stack;

import java.util.StringTokenizer;

/**
 * Evaluador de expresiones matemáticas en notación postfija.
 *
 * Usa una pila de enteros para los operandos y una cola auxiliar para
 * la tokenización. Los operadores se representan con el enum {@link Operador},
 * que encapsula la lógica de cada operación.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class Evaluador {

    private Stack<Integer> pila;
    private Queue<String> cola;

    // -------------------------------------------------------------------------

    /**
     * Operadores aritméticos soportados por el evaluador.
     * Cada constante encapsula su símbolo y la lógica de la operación.
     */
    public enum Operador {

        SUMA('+') {
            @Override public int aplicar(int a, int b) { return a + b; }
        },
        RESTA('-') {
            @Override public int aplicar(int a, int b) { return a - b; }
        },
        MULTIPLICACION('*') {
            @Override public int aplicar(int a, int b) { return a * b; }
        },
        DIVISION('/') {
            @Override public int aplicar(int a, int b) {
                if (b == 0) throw new ArithmeticException("División por cero");
                return a / b;
            }
        };

        private final char simbolo;

        Operador(char simbolo) {
            this.simbolo = simbolo;
        }

        /**
         * Aplica la operación a los dos operandos.
         *
         * @param a Operando izquierdo.
         * @param b Operando derecho.
         * @return Resultado de la operación.
         */
        public abstract int aplicar(int a, int b);

        /**
         * Devuelve el {@code Operador} correspondiente al carácter dado.
         *
         * @param c Carácter del operador.
         * @return El {@code Operador} cuyo símbolo coincide con {@code c}.
         * @throws IllegalArgumentException Si el carácter no es un operador válido.
         */
        public static Operador fromChar(char c) {
            for (Operador op : values()) {
                if (op.simbolo == c) return op;
            }
            throw new IllegalArgumentException("Operador desconocido: " + c);
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Crea un evaluador con la pila y cola proporcionadas.
     *
     * @param pila Pila de enteros para almacenar operandos.
     * @param cola Cola auxiliar para la tokenización.
     */
    public Evaluador(Stack<Integer> pila, Queue<String> cola) {
        this.pila = pila;
        this.cola = cola;
    }

    /**
     * Elimina los espacios de la expresión y devuelve sus tokens en un array.
     *
     * @param expresion Expresión en notación postfija.
     * @return Array de tokens sin espacios en blanco.
     */
    public String[] eliminarBlancos(String expresion) {
        StringTokenizer tokenizer = new StringTokenizer(expresion, "+-*/ ", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.equals(" ")) cola.enqueue(token);
        }
        int size = cola.getSize();
        String[] resultado = new String[size];
        for (int i = 0; i < size; i++) resultado[i] = cola.dequeue();
        return resultado;
    }

    /**
     * Extrae dos operandos de la pila, aplica el operador y apila el resultado.
     *
     * @param op            Carácter del operador.
     * @param operandosPila Pila de operandos.
     * @throws ExpresionMalFormadaException Si la pila tiene menos de dos operandos.
     * @throws ArithmeticException          Si se produce una división por cero.
     */
    public void procesarUnOperador(char op, Stack<Integer> operandosPila)
            throws ExpresionMalFormadaException {
        if (operandosPila.getSize() < 2) {
            throw new ExpresionMalFormadaException(
                    "Se necesitan dos operandos para '" + op + "'");
        }
        int b = operandosPila.pop();
        int a = operandosPila.pop();
        operandosPila.push(Operador.fromChar(op).aplicar(a, b));
    }

    /**
     * Evalúa una expresión en notación postfija y devuelve el resultado.
     *
     * <p>Si todos los tokens concatenados forman un único número, se apila
     * directamente. En otro caso se procesan token a token.</p>
     *
     * @param expresion Expresión en notación postfija.
     * @return Resultado entero de la evaluación.
     * @throws ExpresionMalFormadaException Si la expresión está vacía, contiene
     *                                      tokens inválidos o sobran operandos al final.
     */
    public int evaluarExpresion(String expresion) throws ExpresionMalFormadaException {
        String[] tokens = eliminarBlancos(expresion);

        if (tokens.length == 0) {
            throw new ExpresionMalFormadaException("La expresión está vacía");
        }

        StringBuilder sb = new StringBuilder();
        for (String t : tokens) sb.append(t);

        if (soloDigitos(sb.toString())) {
            pila.push(Integer.parseInt(sb.toString()));
        } else {
            for (String token : tokens) {
                if (esOperador(token)) {
                    procesarUnOperador(token.charAt(0), pila);
                } else {
                    try {
                        pila.push(Integer.parseInt(token));
                    } catch (NumberFormatException e) {
                        throw new ExpresionMalFormadaException("Token inválido: '" + token + "'");
                    }
                }
            }
        }

        int resultado = pila.pop();
        if (!pila.isEmpty()) {
            while (!pila.isEmpty()) pila.pop();
            throw new ExpresionMalFormadaException("La expresión tiene operandos sobrantes");
        }
        return resultado;
    }

    // -------------------------------------------------------------------------

    /**
     * @return {@code true} si todos los caracteres son dígitos.
     */
    private boolean soloDigitos(String expresion) {
        if (expresion == null || expresion.isEmpty()) return false;
        for (char c : expresion.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * @return {@code true} si el token es un operador aritmético soportado.
     */
    private boolean esOperador(String token) {
        return token.length() == 1 && "+-*/".indexOf(token.charAt(0)) >= 0;
    }
}