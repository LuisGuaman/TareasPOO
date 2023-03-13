
package newpackage;

import java.util.Scanner;


public class excepciones {
    public static void main (String []args){
        int n1;
        int n2;      
    //Api Java = Buscar en inter.
    //Excepciones
    /*Sintaxis try catch
    try {
    sentencias;
    }catch(Exception variable){
            sentencias;
    }
    */ 
        /* sintanxis try catch la de abajo como la de arriba es lo mismo.
        int numerador =12;
        int denominador=0;  
        try {
        int residuo= numerador /denominador;
        System.out.println("La division es"+residuo);
    } catch (ArithmeticException e){
        System.out.println(e);
    }*/
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el primer numero");
            n1 = sc.nextInt();
            System.out.println("Ingrese el segundo numero");
            n2 = sc.nextInt();

            int res = n1 * n2;
            System.out.println("El resultado es:" + res);
        } catch (java.util.InputMismatchException e) {
            System.out.println("No puedes ingresar palabras");
            
        }
        
    }
    
}
        
    



