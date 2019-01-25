/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labortorio2_renatovarela;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asus Pc
 */
public class Labortorio2_RenatoVarela {

    /**
     * @param args the command line arguments
     */
    static ArrayList registro = new ArrayList();

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
      
        login();
        menu();

    }
    
    
    public static void login(){
          String usuario = "" , contrasena = "";
        
        while(!usuario.equals("leobanegas" ) && !contrasena.equals("99") ){
            System.out.println("Ingrese el nombre de usuario");
            usuario = leer.next();
            
            System.out.println("Ingrese la contrasena");
            contrasena = leer.next();
            
        }
    }

    public static void menu() {
        int opcion = 0;
        boolean salir = false;

        while (salir == false) {
            System.out.println("Ingrese alguna opcion: \n1)Registro de casas  \n2)Manejo de Estados  \n3)Log in  \n4)Salir");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:

                    registro();

                    break;

                case 2:
                    Manejo();

                    break;

                case 3:
                    login();

                    break;

                case 4:
                    salir = true;

                    break;
                    
                default:
                    System.out.println("eso no existe");
                    break;

            }
        }

    }

    public static void registro() {
        int opcion;
        System.out.println("-------------------------------------------------");
        System.out.println("Ingrese que es lo que desea hacer en esta opcion:\n"
                + "1.Crear Casas\n"
                + "2. Listar Casas\n"
                + "3. Modificar Casas\n"
                + "4. Borrar Casas");
        opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                crear();
                break;

            case 2:
                lista();
                break;

            case 3:
                modificar();

                break;

            case 4:
                eliminar();
                break;
                
            default:
                System.out.println("eso no existe");
                break;

        }

    }

    public static void Manejo() {
        int posicion, demoler;
        String estado, estado2;
        boolean correcto = false;
        System.out.println("Ingrese la posicion de la Casa que desea Modificar");
        posicion = leer.nextInt();

        System.out.println("Estado actual de esa Casa: " + ((Casas) registro.get(posicion)).getEstado());
        estado = ((Casas) registro.get(posicion)).getEstado();

        System.out.println("");
        estado2 = Ingresar_estado();
        //LISTO , CONSTRUCCION, CONSTRUCCION EN ESPERA, ESPERA DE DEMOLICION

        while (correcto == false) {
            correcto = true;

            if (estado.equals("LISTO") && !estado2.equals("ESPERA DE DEMOLICION")) {
                System.out.println("Cuando esta en LISTO su estado solo puede cambia a en ESPERA DE DEMOLICION ");
                correcto = false;
                estado2 = Ingresar_estado();
            } else if (estado.equals("CONSTRUCCION EN ESPERA") && !estado2.equals("CONSTRUCCION")) {
                System.out.println("Cuando el estado de la casa esta en CONSTRUCCION EN ESPERA su estado solo puede cambia a en CONSTRUCCION ");
                correcto = false;
                estado2 = Ingresar_estado();
            } else if (estado.equals("CONSTRUCCION") && !estado2.equals("LISTO")) {
                System.out.println("Cuando el estado de la casa esta en CONSTRUCCION su estado solo puede cambia a en LISTO ");
                correcto = false;
                estado2 = Ingresar_estado();
            } else if (estado.equals("ESPERA DE DEMOLICION")) {
                System.out.println("NO SE PUEDE MODIFICAR EN ESTE ESTADO");

            } else {
                if (contar_C() == false) {
                System.out.println("Ese estado ya esta lleno no se cambiara");
                correcto = true;
                
            }else if (contar_D() == false) {
                System.out.println("Ese estado ya esta lleno no se cambiara");
                correcto = true;
                
            }else{
            

                System.out.println("MODIFICACION EXISTOSA");
                ((Casas) registro.get(posicion)).setEstado(estado2);
            }
            }

        }

        //contar(posicion);
        if (((Casas) registro.get(posicion)).getEstado().equals("ESPERA DE DEMOLICION")) {

            System.out.println("Desea demoler al casa en la posicion: " + ((Casas) registro.get(posicion)).getEstado() + " \nIngrese 1) para demoler "
                    + "\ningrese 2) para no demoler");

            demoler = leer.nextInt();

            if (demoler == 1) {
                registro.remove(posicion);
            } else if (demoler == 2) {
                System.out.println("NO SERA DEMOLIDA");
            } else {
                System.out.println("ESA OPCION NO EXISTE");
            }

        }

    }

    //metodo para contar las casas en espera de demolicion
    
    static int espera_d = 0;
    public static boolean contar_D() {
        int demoler;
        boolean puede;

        puede = true;
        for (int i = 0; i < registro.size(); i++) {

            if (((Casas) registro.get(i)).getEstado().equals("ESPERA DE DEMOLICION")) {
                espera_d++;
               
            }

        }

        if (espera_d > 3) {
            System.out.println("Ya no pueden haber mas casas en: ESPERA DE DEMOLICION");
            puede = false;
            //registro.remove(posicion);

        }

        return puede;
    }
    
    
    public static void demoler(){
        
        int demoler;
        boolean puede;

        puede = true;
        for (int i = 0; i < registro.size(); i++) {

            if (((Casas) registro.get(i)).getEstado().equals("ESPERA DE DEMOLICION")) {
                espera_d++;
                
                  System.out.println("Desea demoler al casa en la posicion: " + ((Casas) registro.get(i)) + " \nIngrese 1) para demoler "
                    + "\ningrese 2) para no demoler");

            demoler = leer.nextInt();

            if (demoler == 1) {
                registro.remove(i);
            } else if (demoler == 2) {
                System.out.println("NO SERA DEMOLIDA");
            } else {
                System.out.println("ESA OPCION NO EXISTE");
            }
                
                

            }

        }
        
    }
    
    //termina espera de demolicion
    
    
//Metodo para contar las casas en construccion 
    static int construccion = 0;
    public static boolean contar_C() {
        
        boolean puede;

        puede = true;
        for (int i = 0; i < registro.size(); i++) {

            if (((Casas) registro.get(i)).getEstado().equals("CONSTRUCCION")) {
                construccion++;

            }

        }

        if (construccion > 5) {
            System.out.println("Ya no pueden haber mas casas en: Construccion");
            puede = false;
            //registro.remove(posicion);
        }

        return puede;
    }
    
    //termina el metodo
    
    

    public static String Ingresar_estado() {
        String estado = "";
        boolean correcto = false;

        while (correcto == false) {
            System.out.println("Ingrese el ESTADO al que desea Modificar: \n1)para: LISTO"
                    + "\n2)para: CONSTRUCCION"
                    + "\n3)para CONSTRUCCION EN ESPERA"
                    + "\n4)para ESPERA DE DEMOLICION");
            estado = leer.next();
            if (estado.equals("1")) {
                estado = "LISTO";
                correcto = true;
            } else if (estado.equals("2")) {
                estado = "CONSTRUCCION";
                correcto = true;
            } else if (estado.equals("3")) {
                estado = "CONSTRUCCION EN ESPERA";
                correcto = true;
            } else if (estado.equals("4")) {
                estado = "ESPERA DE DEMOLICION";
                correcto = true;
            } else {
                System.out.println("ESE ESTADO NO EXISTE, vuelva a ingresarlo");
            }
        }
        return estado;
    }

    /* ---------------------------------TODAS LOS METODOS DE AQUI ABAJO SON LOS UTILIZADOS EN EL METODO PARA REGISTRO (CRUD) -----------------------------*/
    public static void crear() {
        boolean correcto = false;
        int numero_casas, numero_bloque, pisos, banos, cuartos;
        String nombre_dueno, color, estado = "", ocupada, ingeniero;
        double ancho, largo;

        System.out.println("Ingrese el numero de la casa");
        numero_casas = leer.nextInt();

        System.out.println("Ingrese el numero del bloque");
        numero_bloque = leer.nextInt();

        System.out.println("Ingrese el numero de pisos");
        pisos = leer.nextInt();

        System.out.println("Ingrese numero de banos");
        banos = leer.nextInt();

        System.out.println("Ingrese el numero de cuartos");
        cuartos = leer.nextInt();

        System.out.println("La casa esta ocupada? Ingrese (s para si o n para no ) ");
        ocupada = leer.next();
        
        while(!ocupada.equals("s") && !ocupada.equals("n") ){
            System.out.println("solo puede elegir los caracteres que se le indican [s o n]");
            ocupada = leer.next();
        }
        
        if (ocupada.equals("s")) {
            
            System.out.println("Nombre del propietario");
        nombre_dueno = leer.next();
        
        }else{
            nombre_dueno = "Sin dueno";
        }
            
            
        

        

        System.out.println("INgrese el color de la casa");
        color = leer.next();

        //Ingresamos el estado dandole opciones al usuario con su respectiva validadcion
        while (correcto == false) {
            System.out.println("Ingrese un numero para definir el estado de la casa: \n1)para: LISTO"
                    + "\n2)para: CONSTRUCCION"
                    + "\n3)para CONSTRUCCION EN ESPERA"
                    + "\n4)para ESPERA DE DEMOLICION");
            estado = leer.next();
            if (estado.equals("1")) {
                estado = "LISTO";
                correcto = true;
            } else if (estado.equals("2")) {
                estado = "CONSTRUCCION";
                correcto = true;

                if (contar_C() == false) {
                    System.out.println("Ingrese otro estado");
                    correcto = false;
                }

            } else if (estado.equals("3")) {
                estado = "CONSTRUCCION EN ESPERA";
                correcto = true;
            } else if (estado.equals("4")) {
                estado = "ESPERA DE DEMOLICION";
                
                correcto = true;
                
                if (contar_D() == false) {
                    System.out.println("Ingrese otro estado");
                    correcto = false;
                }

            } else {
                System.out.println("ESE ESTADO NO EXISTE, vuelva a ingresarlo");
            }
        }

        //Termina la declaracion del estado
        System.out.println("Ingrese el ancho de la casa");
        ancho = leer.nextDouble();

        System.out.println("Ingrese el Largo de la casa");
        largo = leer.nextDouble();

        System.out.println("Nombre del Ingeniero");
        ingeniero = leer.next();
        
        demoler();

        registro.add(new Casas(numero_casas, numero_bloque, pisos, banos, cuartos, nombre_dueno, color, estado, ancho, largo, ocupada, ingeniero));

    }

    public static void lista() {

        String s = " ";

        for (Object t : registro) {

            s += "Posicion de la casa:" + registro.indexOf(t) + "\n" + "---------------------------\n " + t + "\n";

        }

        System.out.println(s);

    }

    public static void eliminar() {
        int posicion;
        System.out.println("Ingrese la POSICION de la casa que desea ELIMINAR");
        posicion = leer.nextInt();

        registro.remove(posicion);

    }

    public static void modificar() {

        //// variables por la cual se reemplazara
        int numero_casas, numero_bloque, pisos, banos, cuartos;
        String nombre_dueno, color, estado, ocupada, ingeniero;
        double ancho, largo;

        // Finaliza
        int posicion, posicion2;
        //Object atributo;

        System.out.println("Ingrese la POSICION de la casa que desea Modificar (Recuerde el ESTADO no se puede modificar desde aqui )");
        posicion = leer.nextInt();

        System.out.println("Ingrese el Numero de el ATRIBUTO que desea modificar");
        posicion2 = leer.nextInt();

        switch (posicion2) {

            case 1:

                System.out.println("Ingrese el numero de la casa");
                numero_casas = leer.nextInt();

                ((Casas) registro.get(posicion)).setNumero_casas(numero_casas);

                break;

            case 2:

                System.out.println("Ingrese el numero del bloque");
                numero_bloque = leer.nextInt();
                ((Casas) registro.get(posicion)).setNumero_bloque(numero_bloque);

                break;

            case 3:

                System.out.println("Ingrese el numero de pisos");
                pisos = leer.nextInt();
                ((Casas) registro.get(posicion)).setPisos(pisos);

                break;

            case 4:

                System.out.println("Ingrese numero de banos");
                banos = leer.nextInt();
                ((Casas) registro.get(posicion)).setBanos(banos);

                break;

            case 5:
                System.out.println("Ingrese el numero de cuartos");
                cuartos = leer.nextInt();
                ((Casas) registro.get(posicion)).setCuartos(cuartos);

                break;

            case 6:

                System.out.println("Nombre del propietario");
                nombre_dueno = leer.next();
                ((Casas) registro.get(posicion)).setNombre_dueno(nombre_dueno);

                break;

            case 7:

                System.out.println("INgrese el color de la casa");
                color = leer.next();
                ((Casas) registro.get(posicion)).setColor(color);

                break;

            case 8:

                System.out.println("EL ESTADO NO PUEDE SE MODIFICAD DESDE AQUI!!!!!!!!!!!!!!!");
                break;

            case 9:

                System.out.println("La casa esta ocupada? Ingrese (s para si o n para no ) ");
                ocupada = leer.next();
                ((Casas) registro.get(posicion)).setOcupada(ocupada);

                break;

            case 10:
                System.out.println("Ingrese el Ancho de la casa");
                ancho = leer.nextDouble();
                ((Casas) registro.get(posicion)).setAncho(ancho);

                break;

            case 11:

                System.out.println("Ingrese el Largo de la casa");
                largo = leer.nextDouble();
                ((Casas) registro.get(posicion)).setLargo(largo);

                break;

            case 12:

                System.out.println("Ingrese el Nombre del Ingeniero");
                ingeniero = leer.next();
                ((Casas) registro.get(posicion)).setIngeniero(ingeniero);

                break;

        }

    }

}
