/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aventurabloodborne;

import modulos.*;

/**
 *
 * @author jaaii
 */
public class AventuraBloodborne {

    // Variables globales.
    static String nombreJug = new String();
    static long t1, t2;
    static int cordon = 0;
    static int mejoraAtaqueVisceral = 0;
    static boolean cordonHab1 = false;
    static boolean cordonHab2 = false;
    static boolean cordonHab3 = false;
    static boolean cuchillaDentada = false;
    static boolean pistolaDelCazador = false;
    static boolean ataqueVisceral = false;
    static boolean insigniaKosm = false;
    static boolean llaveTorreReloj = false;
    static boolean bestiaClerigo = true;
    static boolean ladyMaria = true;
    static boolean tiburon = true;
    static boolean rakuyo = false;
    static boolean cuchillaChaman = false;

    public static void main(String[] args) {

        String resp;

        do {
            nombreJug = FuncionesGraficas.FotoYPedirDatos(
                    "Creación del cazador", 
                    "src/main/java/imagenes/NombreJugador.png", 
                    "¿Cuál es el nombre de tu cazador?", 
                    0.8, false);

            presentacionJuego();

            // capturamos t1
            capturarTiempoInicio();

            // escena principal
            escena0();

            resp = FuncionesGraficas.pedirDatos("Jugar de nuevo", "¿Desea jugar de nuevo? (S/N)");
        } while (resp != null && resp.equalsIgnoreCase("S"));
    }

    static void presentacionJuego() {
        FuncionesGraficas.FotoyMensaje(
                "Sueño del cazador", 
                "src/main/java/imagenes/Presentacion.png", 
                "Bienvenido al sueño del cazador, " + nombreJug, 
                0.8, false);
    }

    static void capturarTiempoInicio() {
        t1 = System.currentTimeMillis();
    }

    static void escena0() {

        String[] opciones = {
            "1. Ir a la casa", 
            "2. Ir a Yharnam", 
            "3. Ir a la torre del reloj", 
            "4. Ir a la aldea pesquera", 
            "5. Explorar un paisaje inusual"};

        int opcion = FuncionesGraficas.FotoMensajeMenu(
                "Comienzo de la cacería", opciones, 
                "src/main/java/imagenes/SueñoDelCazador.png", 
                "¿Dónde quieres ir?", 
                0.8, false);

        switch (opcion) {
            case 0:
                escena1(); //Escena de la casa
                break;
            case 1:
                escena2(); //Escena Yharnam con Eileen
                break;
            case 2:
                escena3(); //Escena torre del reloj
                break;
            case 3:
                escena4(); //Escena aldea pesquera
                break;
            case 4:
                escena5(); //Escena final
                break;
        }
    }

    static void escena1() {
        String[] opciones = {
            "1. Abrir armario", 
            "2. Buscar en la habitación", 
            "3. Volver al sueño del cazador"};
        int opcion = FuncionesGraficas.FotoMensajeMenu(
                "Casa del cazador", opciones, 
                "src/main/java/imagenes/InteriorCasa.png", 
                "Te encuentras en la casa del cazador.", 
                0.8, false);

        switch (opcion) {
            case 0: //Abrir armario
                if (cuchillaDentada == false && pistolaDelCazador == false) {
                    FuncionesGraficas.FotoyMensaje(
                            "Armario del cazador", 
                            "src/main/java/imagenes/CuchillaDentadaYPistolaDelCazador.png", 
                            "Has encontrado la cuchilla dentada y la pistola del cazador.", 
                            0.8, false);
                    cuchillaDentada = true;
                    pistolaDelCazador = true;
                } else {
                    FuncionesGraficas.warning("Armario vacío", "Este armario está vacío");
                }
                escena1();
                break;
            case 1: //Buscar en la habitación
                if (cordonHab1 == false) {
                    FuncionesGraficas.FotoyMensaje(
                            "Habitación del cazador", 
                            "src/main/java/imagenes/TercioCordonUmbilical.png", 
                            "Rebuscas entre papeles... encuentras un cordón umbilical.", 
                            0.8, false);
                    cordonHab1 = true;
                    cordon++;
                } else {
                    FuncionesGraficas.warning("Nada nuevo", "No hay nada más que buscar.");
                }
                escena1();
                break;
            case 2: //Volver al sueño del cazador
                escena0();
                break;
            default:
                FuncionesGraficas.warning("Opción no válida", "Debes elegir una de las opciones del menú.");
                escena1();
                break;

        }
    }

    static void escena2() {
        if (cuchillaDentada==false || pistolaDelCazador==false) {
            FuncionesGraficas.warning("No puedes ir", "Necesitas la cuchilla dentada y la pistola del cazador para aventurarte en Yharnam.");
            escena0();
            return;
            
        }
        
        else FuncionesGraficas.FotoyMensaje(
                "Yharnam", 
                "src/main/java/imagenes/yharnam.png", 
                "Bienvenido a Yharnam", 
                0.8, false);
        
        if (bestiaClerigo==false)
        {
         escena2Eileen();
        } else 
             {
               String[] opciones = {
                   "1.Hablar con Eileen ", 
                   "2. Explorar", 
                   "3. Volver al sueño del cazador"};
                int opcion = FuncionesGraficas.FotoMensajeMenu(
                        "Yharnam", opciones, 
                        "src/main/java/imagenes/yharnam.png", 
                        "Decide que quieres hacer.", 
                        0.8, false);
                
                switch (opcion){
                
                    case 0: //Hablar con Eileen
                        if(ataqueVisceral==false){//la foto de eileen no me va, he puesto otra para ver si va y sí va.
                        FuncionesGraficas.FotoyMensaje(
                                "Eileen", 
                                "src/main/java/imagenes/DialocoConEileen.png", 
                                "No me suena haberte visto antes por aqui, ten esto, te vendrá bien si quieres sobrevivir.", 
                                0.8, false);
                        
                        ataqueVisceral=true;
                        }else{
                             FuncionesGraficas.warning("Nada que decir", "No hay nada mas que hablar.");
                             }
                        escena2();
                        break;
                        
                    case 1://Explorar
                        if (ataqueVisceral==false)
                        {
                         FuncionesGraficas.warning("Aviso", "Deberias hablar primero con Eileen.");
                        } else 
                        {
                         String [] opcionesBC = {
                             "1.Hablar", 
                             "2.Pelear"};
                         int opcionBC = FuncionesGraficas.FotoMensajeMenu(
                                 "Bestia Clerigo", opcionesBC, 
                                 "src/main/java/imagenes/BestiaClerigo.png", 
                                 "Te encuentras una bestia que no parece ser de este mundo, ¿que harás? ", 
                                 0.8, false);
                        }
                        
                        switch (opcion){
                            
                            case 0: luchaBestiaClerigo();
                            
                            case 1: FuncionesGraficas.FotoyMensaje(
                                    "Bestia Clerigo", 
                                    "src/main/java/imagenes/BestiaClerigo.png", 
                                    "Toma esta llave y ve a por quien originó esta pesadilla.", 
                                    0.8, false);
                                    FuncionesGraficas.FotoyMensaje(
                                            "Llave de la torre", 
                                            "src/main/java/imagenes/LlaveTorreDelReloj.png", 
                                            "Has conseguido la llave de la torre del reloj astral.", 
                                            0.8, false);
                                    llaveTorreReloj=true;
                                    escena2();
                                    break;
                        }
                }
             }
        
                }
    static void luchaBestiaClerigo(){
    
    int vidaJug=200;
    int vidaMaxJug=250;
    int dañoJug=50;
    int dañoVisceral=75;
    int curacionVisceral=50;
    int vidaBestiaClerigo=1000;
    int dañoBestiaClerigo=75;
    boolean hacerVisceral=false;
    boolean ladyMaria=true;
    do
    {
        String []opciones = {
            "1.Atacar", 
            "2.Ataque visceral"};
    
    FuncionesGraficas.menuDesplegable(
            "Lucha o muere", 
            "Toma una decisión.", 
            opciones);
    
    
    }while (vidaJug>0);
    
   
    
    
    
    }
    static void escena2Eileen(){
    
    }

    static void escena3() {
        if (llaveTorreReloj==false) {
            FuncionesGraficas.warning("Acceso bloqueado", "Necesitas la llave de la torre para poder acceder.");
            escena0();
            return;
        } 
        
        String[] opciones = {
            "1. Hablar con Lady Maria", 
            "2. Pelear con Lady Maria", 
            "3. Huir y volver al sueño del cazador"};
        
        int opcion = FuncionesGraficas.FotoMensajeMenu(
                "Torre del reloj astral", opciones, 
                "src/main/java/imagenes/torreDelReloj.jpg", 
                "Lady Maria reposa inmovil en la silla del reloj astral.", 
                0.8, false);
        
        switch (opcion) {
            case 0: //1. Hablar
                FuncionesGraficas.FotoyMensaje(
                        "Lady Maria", 
                        "src/main/java/imagenes/ladyMaria.png", 
                        "La verdad que buscas pesa más de lo que imaginas.", 
                        0.8, false);
                escena3();
                break;

            case 1: //2. Pelear
             
            case 2: //3. Huir
                escena0();
                break;
             
        }
    }

    static void escena4() {
        String[] opciones = {
            "1. Buscar por la aldea",
            "2. Entrar en el pozo",
            "3. Volver al sueño del cazador"};
        int opcion = FuncionesGraficas.FotoMensajeMenu(
                "Aldea pesquera", opciones,
                "src/main/java/imagenes/AldeaPesquera.png",
                "La bruma del mar cubre las chozas y el olor a sangre vieja llena el aire.",
                0.8, false);

        switch (opcion) {

            case 0:
                boolean seguirBuscando = true;

                while (seguirBuscando == true) {

                    String[] opcionesAldea = {
                        "1. Rastrear la aldea",
                        "2. Seguir un rastro extraño",
                        "3. Rebuscar entre los restos del chamán",
                        "4. Volver atrás"
                    };

                    int opcionAldea = FuncionesGraficas.FotoMensajeMenu(
                            "Aldea pesquera",
                            opcionesAldea,
                            "src/main/java/imagenes/AldeaPesquera.png",
                            "El sonido del mar golpea la costa mientras decides tu siguiente paso.",
                            0.8,
                            false
                    );

                    switch (opcionAldea) {

                        case 0: // Rastrear la aldea
                            FuncionesGraficas.warning("Rastrear la aldea", "No hay nada.");
                            break;

                        case 1: // Seguir un rastro extraño
                            FuncionesGraficas.FotoyMensaje(
                                    "Demasiada curiosidad",
                                    "src/main/java/imagenes/jabali.png",
                                    "Has encontrado algo que no debías...\nHas muerto.",
                                    0.8, false);
                            System.exit(0);
                            break;

                        case 2: // Rebuscar entre los restos del chamán
                            if (cuchillaChaman == false) {
                                FuncionesGraficas.FotoyMensaje(
                                        "Restos del chamán",
                                        "src/main/java/imagenes/CuchillaDeChaman.png",
                                        "Entre los restos del chamán encuentras una cuchilla impregnada de extrañas runas.",
                                        0.6, false);
                                cuchillaChaman = true;
                            } else {
                                FuncionesGraficas.warning("Restos del chamán", "No hay nada que buscar.");
                            }

                            break;

                        case 3: //Volver atrás
                            seguirBuscando = false;
                            break;

                    }
                }
                escena4();
                break;

            case 1: //Entrar en el pozo

                String[] opcionesPozo = {
                    "1. Luchar contra lo que habita en el pozo",
                    "2. Volver a la aldea pesquera"};

                int opcionPozo = FuncionesGraficas.FotoMensajeMenu(
                        "Pozo de la aldea",
                        opcionesPozo,
                        "src/main/java/imagenes/pozo.png",
                        "Te asomas al pozo."
                        + "\nAlgo enorme se mueve en la oscuridad...",
                        0.8, false);

                switch (opcionPozo) {

                    case 0: //Luchar
                        if (cuchillaChaman == false) {
                            FuncionesGraficas.FotoyMensaje(
                                    "Necesitas la cuchilla del chamán",
                                    "src/main/java/imagenes/tiburontemata.png",
                                    "Sin la cuchilla del chamán en tus manos, los dos tiburones no dudan:"
                                    + "\nsaltan sobre ti con una ferocidad inhumana."
                                    + "\nNo tienes opción alguna."
                                    + "\nTu cuerpo desaparece bajo un torbellino de dientes y garras."
                                    + "\nHas muerto.",
                                    0.8, false);

                            FuncionesGraficas.FotoyMensaje(
                                    "Has muerto",
                                    "src/main/java/imagenes/YouDied.png",
                                    "La profundidad del pozo se convierte en tu tumba.",
                                    0.8, false);

                            System.exit(0);
                        } else {
                            luchaTiburones();
                            escena4();
                        }
                        break;

                    case 1: //Volver a la aldea
                        escena4();
                        break;
                }

            case 2: //Volver al sueño del cazador
                escena0();
                break;
        }
    }
    
    static void luchaTiburones() {
    
    }

    static void escena5() {

    }
}
