/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author judith
 */
public class isNumber {
      public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
            System.out.println("es numero");
        } catch (NumberFormatException excepcion) {
            resultado = false;
            System.out.println("no es numero");
        }

        return resultado;
    }


} 