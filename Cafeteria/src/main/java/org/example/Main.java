package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        //Definir los variables necesarios
        String NombredeCliente;
        int CantidaddeProducto;
        int Menu;
        int Cantidad;
        double Precio;
        double Total;
        //Informacion del cliente y productos
        System.out.println("Ingrese su nombre");
        NombredeCliente = sc.nextLine();
        System.out.println("Menu");
        System.out.println("1. Cafe");
        System.out.println("2.Desayuno tradicional");
        System.out.println("3.Almuerzo tradicional");
        System.out.println("4.Cena tradicional");
        System.out.println("5.Jugo");
        System.out.println("6. Salir de Menu");
        //Facturar el nombre de usario

        System.out.println("Seleccione la opcion");
        Menu = sc.nextInt();
        if (Menu == 1)
        {
            Precio = 12.50;
            System.out.println("Cafe cuesta" + Precio);
            System .out.println("cuantos desea");
            Cantidad = sc.nextInt();

            Total  = Precio * Cantidad;
            System.out.println("Total a pagar " + Total);

        }
       else if (Menu ==2) {
            Precio = 32.75;
            System.out.println(" El desayuno tiene un costo de " + Precio);
            System .out.println(" cuantos desea");
            Cantidad = sc.nextInt();

            Total = Precio * Cantidad;
            System.out.println(" Total a pagar " + Total);
        }
        else if(Menu == 3) {
            Precio = 42.75;
            System.out.println(" El almuerzo tiene un costo de " + Precio);
            System .out.println("cuantos desea");
            Cantidad = sc.nextInt();

            Total = Precio * Cantidad;
            System.out.println(" Total a pagar " + Total);
        }
        else if(Menu == 4) {
            Precio = 32.75;
            System.out.println(" La cena tiene un costo de " + Precio);
            System .out.println("cuantos desea");
            Cantidad = sc.nextInt();

            Total = Precio * Cantidad;
            System.out.println("Total a pagar " + Total);
        }
        else if(Menu ==5) {
            Precio = 10.50;
            System.out.println("El jugo tiene un costo de " + Precio);
            System .out.println("cuantos desea");
            Cantidad = sc.nextInt();

            Total = Precio * Cantidad;
            System.out.println("Total a pagar " + Total);
            System.out.println("Matenme mi gente ya no quiero estudiar, Merezco vivir en paz bruh");
        }
        else {
            System.out.println("Sin opciones");
        }







        }


    }




