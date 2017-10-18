/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionsingleton;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author CDS
 */
public class Cliente {

    public static void main(String[] args) {
        Queue<String> cola = new PriorityQueue<>();
        Stack<Integer> pila = new Stack<>();
        Scanner leer = new Scanner(System.in);

        int opcion = 0;
        int turno = 0;
        int numeroCanasta = 0;
        String nombre;

        while (opcion != 4) {
            System.out.println("---------------MENU------------------");
            System.out.println("1. Añadir persona a la fila del super");
            System.out.println("2. Atender a persona de la fila");
            System.out.println("3. Consultar personas de la fila");
            System.out.println("-------------------------------------");
            System.out.println("4. Añadir canasta al monton");
            System.out.println("5. Retirar canasta del monton");
            System.out.println("6. Consultar total de canastas del monton");
            System.out.println("7. Salir");
            System.out.println("-------------------------------------");
            System.out.println("ELIJA UNA OPCIÓN---------------------");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Singleton singleton = Singleton.getInstance();
                    System.out.println("Ingrese nombre cliente: ");
                    nombre=leer.nextLine();
                    singleton.getInstance().setPersona(nombre);
                    singleton.getInstance().setTurno(turno+1);
                    cola.add(singleton.getInstance().getPersona());
                    System.out.println("Se añadio "+nombre+" a la fila");
                    break;
                case 2:
                    if (!cola.isEmpty()) {
                        System.out.println("Ingrese número canasta del cliente");
                        numeroCanasta = leer.nextInt();
                        pila.push(numeroCanasta);
                        System.out.println("Se atendió a " + cola.peek());
                        cola.remove();
                    } else {
                        System.out.println("No hay nadie en la fila por atender");
                    }
                    break;
                case 3:
                    System.out.println("En la fila hay " + cola.size() + " personas");
                    for (String i : cola) {
                        System.out.println("•" + i);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese número canasta");
                    numeroCanasta = leer.nextInt();
                    pila.push(numeroCanasta);
                    break;
                case 5:
                    if (!pila.isEmpty()) {
                        pila.pop();
                        System.out.println("Se retiro una canasta");
                    } else {
                        System.out.println("No hay canastas disponibles");
                    }
                    break;
                case 6:
                    System.out.println("En el monton hay: " + pila.size());
                    break;
                case 7:
                    System.out.println("Ustes salió");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }

    }
}
