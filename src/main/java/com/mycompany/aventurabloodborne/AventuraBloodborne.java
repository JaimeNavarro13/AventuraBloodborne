/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aventurabloodborne;

import java.util.Random;
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
            "Ir a la casa", 
            "Ir a Yharnam", 
            "Ir a la torre del reloj", 
            "Ir a la aldea pesquera", 
            "Explorar un paisaje inusual"};

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
    do{
    if (cuchillaDentada == false || pistolaDelCazador == false) {
            FuncionesGraficas.warning("No puedes ir", "Necesitas la cuchilla dentada y la pistola del cazador para aventurarte en Yharnam.");
            escena0();
            return;

        } else if (insigniaKosm==false) {
            FuncionesGraficas.FotoyMensaje(
                    "Yharnam",
                    "src/main/java/imagenes/yharnam.png",
                    "Bienvenido a Yharnam",
                    0.8, false);
        }else {
            FuncionesGraficas.warning("Nada que hacer aqui", "Ya no hay nada que hacer en Yharnam");
            escena0();
            return;
              }
        

        if (bestiaClerigo == false) {
            escena2Eileen();
        } else {
            String[] opciones = {
                "1. Hablar con Eileen ",
                "2. Explorar",
                "3. Volver al sueño del cazador"};
            int opcion = FuncionesGraficas.FotoMensajeMenu(
                    "Yharnam", opciones,
                    "src/main/java/imagenes/yharnam.png",
                    "Decide que quieres hacer.",
                    0.8, false);

            switch (opcion) {

                case 0: //Hablar con Eileen
                    if (ataqueVisceral == false) {
                        FuncionesGraficas.FotoyMensaje(
                                "Habilidad adquirida",
                                "src/main/java/imagenes/DialocoConEileen.png",
                                "Te he estado observando desde las sombras."
                                + "\nTus pasos son torpes, pero tu instinto es bueno."
                                + "\nAfila tu determinación y apunta al corazón cuando el tiempo pare."
                                + "\nAhora, en combates difíciles, podrás hacer ataques viscerales, no los desperdicies.",
                                0.8, false);

                        ataqueVisceral = true;
                    } else {
                        FuncionesGraficas.warning("Habilidad adquirida", "¡Ya has adquirido el ataque visceral!");
                    }
                    escena2();
                    break;

                case 1://Explorar
                    if (ataqueVisceral == false) {
                        FuncionesGraficas.warning("Aviso", "Deberias hablar primero con Eileen.");
                        escena2();
                        return;
                    }
                        String[] opcionesBC = {
                            "1.Hablar",
                            "2.Pelear"
                            };
                        int opcionBC = FuncionesGraficas.FotoMensajeMenu(
                                "Bestia Clerigo", opcionesBC,
                                "src/main/java/imagenes/BestiaClerigo.png",
                                "Te encuentras una bestia que no parece ser de este mundo, ¿que harás? ",
                                0.8, false);
                    

                    switch (opcionBC) {

                        case 0:
                            luchaBestiaClerigo();
                            break;

                        case 1:
                            FuncionesGraficas.FotoyMensaje(
                                    "Bestia Clerigo",
                                    "src/main/java/imagenes/BestiaClerigo.png",
                                    "Toma esta llave y ve a por quien originó esta pesadilla.",
                                    0.8, false);
                            FuncionesGraficas.FotoyMensaje(
                                    "Llave de la torre",
                                    "src/main/java/imagenes/LlaveTorreDelReloj.png",
                                    "Has conseguido la llave de la torre del reloj astral.",
                                    0.8, false);
                            llaveTorreReloj = true;
                            bestiaClerigo=false;
                            escena2();
                            break;
                    }
                    
                case 2: //Volver al sueño del cazador
                    escena0();
                    break;
            }
        }
        
    }while(insigniaKosm=false);    
    }
        
    static void luchaBestiaClerigo(){
    
    int vidaJug=200;
    int dañoJugBase=50;
    int dañoVisceral=75;
    int curacionVisceral=50;
    int vidaBestiaClerigo=1000;
    int dañoBestiaClerigo=75;
    boolean hacerVisceral=false;
    boolean ladyMaria=true;
    boolean peleando=true;
    Random dado = new Random();
    
    while (vidaJug > 0 && vidaBestiaClerigo > 0) 
    {
     String[] opcionesLB = {
                "1. Atacar",
                "2. Ataque visceral"};

            int opcionLB = FuncionesGraficas.FotoMensajeMenu(
                    "Combate contra la Bestia Clérigo",
                    opcionesLB,
                    "src/main/java/imagenes/BestiaClerigo.png",
                    "Decide con que quieres atacar: ",
                    0.8, false);

            switch (opcionLB) {

                case 0: //Ataque normal
                    FuncionesGraficas.FotoyMensaje(
                            "Ataque",
                            "src/main/java/imagenes/ataqueSimple.png",
                            "Directo al corazón...",
                            0.8, false);
                    vidaBestiaClerigo = vidaBestiaClerigo - dañoJugBase;
                    break;

                case 1: //Ataque visceral
                    if (hacerVisceral == true) {
                        FuncionesGraficas.FotoyMensaje(
                                "¡Ataque visceral!",
                                "src/main/java/imagenes/ataqueVisceral.png",
                                "Tu ataque visceral impacta con una precisión brutal.",
                                0.8, false);

                        vidaBestiaClerigo = vidaBestiaClerigo - dañoVisceral;
                        
                    } else {
                        FuncionesGraficas.warning("No disponible", "No puedes usar el ataque visceral");
                    }
                    break;

            }

            if (vidaBestiaClerigo < 500) {
                FuncionesGraficas.FotoyMensaje(
                        "¡PELIGRO!",
                        "src/main/java/imagenes/BestiaClerigo.png",
                        "La bestia clerigo lanza un ataque desesperado.",
                        0.8, false);
                        vidaJug = vidaJug - dañoBestiaClerigo*10;
                        
                        if (vidaJug<= 0)
                            FuncionesGraficas.FotoyMensaje("Se acabó.", "src/java/main/imagenes/YouDied.png", "Hay cosas que no se solucionan solo peleando...", 0.8, false);
                        System.exit(0);
                
            } else {
                
                FuncionesGraficas.FotoyMensaje(
                        "La bestia se prepara para atacar", 
                        "src/main/java/imagenes/BestiaClerigo.png", 
                        "La Bestia Clérigo lanza un devastador ataque hacia ti", 
                        0.8, false);
                
                int suerte = dado.nextInt(5);

                if (suerte==0) {

                    FuncionesGraficas.FotoyMensaje(
                            "Esquiva",
                            "src/main/java/imagenes/esquiva.png",
                            "¡PANG! Desvias el ataque con tu pistola.",
                            0.8, false);
                } else {
                    vidaJug = vidaJug - dañoBestiaClerigo;

                    FuncionesGraficas.FotoyMensaje(
                            "¡GOLPE DEVASTADOR!",
                            "src/main/java/imagenes/BestiaClerigo.png",
                            "El golpe de la bestia te deja desorientado. Recibes " + dañoBestiaClerigo + " de daño.",
                            0.8, false);
                       }
            }
            if (vidaJug <= 0) {
                FuncionesGraficas.FotoyMensaje(
                        "HAS MUERTO",
                        "src/main/java/imagenes/YouDied.png",
                        "Este es tu fin",
                        0.8, false);
                break;
            }
        }
    }


    static void escena2Eileen(){
        
        FuncionesGraficas.FotoyMensaje("Eileen", "src/main/java/imagenes/DialocoConEileen.png", "Veo que tienes la llave de la torre del reloj astral, toma esto tambien, te servirá", 0.8, false);
        FuncionesGraficas.FotoyMensaje("insignia de Kosm", "src/main/java/imagenes/insigniaDeKosm.png", "Recibes la insignia de Kosm", 0.8, false);
        insigniaKosm=true;
        escena0();
        return;
        
    
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
                if (ladyMaria==true) {
                FuncionesGraficas.FotoyMensaje(
                        "Lady Maria", 
                        "src/main/java/imagenes/ladyMaria.png", 
                        "La verdad que buscas pesa más de lo que imaginas.", 
                        0.8, false);
                escena3();
                } else {
                    FuncionesGraficas.warning("Sala despejada", "Ya has derrotado a la guardiana de la torre. No hay nada más que hacer aquí, salvo avanzar hacia el secreto que ella protegía.");
                    escena3();
                }
                break;

            case 1: //2. Pelear
                if (ladyMaria==true) {
                luchaLadyMaria();
                escena3();
                } else {
                    FuncionesGraficas.warning("Sala despejada", "Ya has derrotado a la guardiana de la torre. No hay nada más que hacer aquí, salvo avanzar hacia el secreto que ella protegía.");
                    escena3();
                }
                break;
             
            case 2: //3. Huir
                escena0();
                break;
             
        }
    }
    
    static void luchaLadyMaria() {

        int vidaJug = 140;
        int vidaMaria = 250;
        int danoJugBase = 80;
        int danoMariaBase = 45;
        int danoMariaExtra = 75;
        int danoVisceral = 150;
        boolean peleando = true;

        if (rakuyo == true) {

            while (peleando == true) {

                String[] opcionesLM = {
                    "1. Atacar con el arma",
                    "2. Ataque visceral"
                };

                int opcionLM = FuncionesGraficas.FotoMensajeMenu(
                        "Combate en la Torre del Reloj",
                        opcionesLM,
                        "src/main/java/imagenes/ladymariasentada.png",
                        "Lady Maria te espera sentada en la silla... decide tu movimiento: ",
                        0.8, false);

                switch (opcionLM) {

                    case 0: // Ataque normal
                        FuncionesGraficas.FotoyMensaje(
                                "Golpe de Cazador",
                                "src/main/java/imagenes/golpesencillo.png",
                                "Tu arma choca contra su Rakuyo saltando chispas...",
                                0.8, false);
                        vidaMaria = vidaMaria - danoJugBase;
                        break;

                    case 1: // Ataque visceral
                        if (ataqueVisceral == true) {
                            FuncionesGraficas.FotoyMensaje(
                                    "¡Ataque visceral exitoso!",
                                    "src/main/java/imagenes/visceralcontraLM.png",
                                    "Desvías su ataque en el último segundo y hundes tu mano en su pecho.",
                                    0.8, false);

                            vidaMaria = vidaMaria - danoVisceral;
                        } else {
                            FuncionesGraficas.warning("Fallaste", "No lograste conectar el ataque visceral a tiempo.");
                            continue;
                        }
                        break;
                }

                if (vidaMaria <= 0) {
                    FuncionesGraficas.FotoyMensaje(
                            "¡VICTORIA!",
                            "src/main/java/imagenes/LMaliada.png",
                            "Lady Maria no ha aguantado la presión y decide ponerse de tu lado.",
                            0.8, false);

                    FuncionesGraficas.FotoyMensaje(
                            "Recompensas obtenidas",
                            "src/main/java/imagenes/TercioCordonUmbilical.png",
                            "Has conseguido: "
                            + "\nUn tercio de cordon umbilical"
                            + "\nMejora ataque visceral",
                            0.8, false);

                    peleando = false;
                    ladyMaria = false;
                    cordonHab2 = true;
                    mejoraAtaqueVisceral = 1;

                } else {
                    FuncionesGraficas.FotoyMensaje(
                            "Arte de Sangre",
                            "src/main/java/imagenes/LMlistalucha.png",
                            "Lady Maria esta lista para la lucha...",
                            0.8, false);

                    int suerteDefensa = (int) (Math.random() * 100);

                    if (suerteDefensa < 20) {
                        FuncionesGraficas.FotoyMensaje(
                                "Paso rápido",
                                "src/main/java/imagenes/LMesquiva.png",
                                "Su hoja pasa a milímetros de tu cuello. Ha estado cerca.",
                                0.8, false);

                    } else if (suerteDefensa > 85) {
                        vidaJug = vidaJug - danoMariaExtra;

                        FuncionesGraficas.FotoyMensaje(
                                "¡GOLPE DE SANGRE!",
                                "src/main/java/imagenes/LMataquefuerte.png",
                                "¡DEVASTADOR! El fuego y la sangre te queman. Recibes " + danoMariaExtra + " de daño.",
                                0.8, false);
                    } else {
                        vidaJug = vidaJug - danoMariaBase;

                        FuncionesGraficas.FotoyMensaje(
                                "Corte rápido",
                                "src/main/java/imagenes/ladyMaria.png",
                                "Sus movimientos son elegantes pero letales. Recibes " + danoMariaBase + " de daño.",
                                1.2, false);
                    }
                }

                if (vidaJug <= 0) {
                    FuncionesGraficas.FotoyMensaje(
                            "HAS MUERTO",
                            "src/main/java/imagenes/YouDied.png",
                            "La pesadilla vuelve a empezar...",
                            0.8, false);
                    peleando = false;
                    System.exit(0);
                    break;
                }
            }
        } else {
                        while (peleando == true) {

                String[] opcionesLM = {
                    "1. Atacar con el arma",
                    "2. Ataque visceral"
                };

                int opcionLM = FuncionesGraficas.FotoMensajeMenu(
                        "Combate en la Torre del Reloj",
                        opcionesLM,
                        "src/main/java/imagenes/ladymariasentada.png",
                        "Lady Maria te espera sentada en la silla... decide tu movimiento: ",
                        0.8, false);

                switch (opcionLM) {

                    case 0: // Ataque normal
                        FuncionesGraficas.FotoyMensaje(
                                "Golpe de Cazador",
                                "src/main/java/imagenes/golpesencillo.png",
                                "Tu arma choca contra su Rakuyo saltando chispas...",
                                0.8, false);
                        vidaMaria = vidaMaria - danoJugBase;
                        break;

                    case 1: // Ataque visceral
                        if (ataqueVisceral == true) {
                            FuncionesGraficas.FotoyMensaje(
                                    "¡Ataque visceral exitoso!",
                                    "src/main/java/imagenes/visceralcontraLM.png",
                                    "Desvías su ataque en el último segundo y hundes tu mano en su pecho.",
                                    0.8, false);

                            vidaMaria = vidaMaria - danoVisceral;
                            ataqueVisceral=false;
                        } else {
                            FuncionesGraficas.warning("Fallaste", "No lograste conectar el ataque visceral a tiempo.");
                            continue;
                        }
                        break;
                }

                if (vidaMaria <= 0) {
                    FuncionesGraficas.FotoyMensaje(
                            "¡VICTORIA!",
                            "src/main/java/imagenes/LMmuerta.png",
                            "Maltrecha y sin fuerzas, Maria te mira con ojos cansados. "
                            + "\n'Un cadáver... debe ser dejado en paz', susurra. "
                            + "\nEn un último acto de desafío, lleva su hoja a su propia garganta y se desploma sobre las flores del jardín astral. "
                            + "\nLa vía está libre.",
                            0.8, false);

                    FuncionesGraficas.FotoyMensaje(
                            "Recompensas obtenidas",
                            "src/main/java/imagenes/LMmuerta.png",
                            
                            "Has conseguido: "
                            + "\nMejora ataque visceral",
                            0.8, false);

                    peleando = false;
                    ladyMaria = false;
                    mejoraAtaqueVisceral = 1;

                } else {
                    FuncionesGraficas.FotoyMensaje(
                            "Arte de Sangre",
                            "src/main/java/imagenes/LMlistalucha.png",
                            "Lady Maria esta lista para la lucha...",
                            0.8, false);

                    int suerteDefensa = (int) (Math.random() * 100);

                    if (suerteDefensa < 20) {
                        FuncionesGraficas.FotoyMensaje(
                                "Paso rápido",
                                "src/main/java/imagenes/LMesquiva.png",
                                "Su hoja pasa a milímetros de tu cuello. Ha estado cerca.",
                                0.8, false);

                    } else if (suerteDefensa > 85) {
                        vidaJug = vidaJug - danoMariaExtra;

                        FuncionesGraficas.FotoyMensaje(
                                "¡GOLPE DE SANGRE!",
                                "src/main/java/imagenes/LMataquefuerte.png",
                                "¡DEVASTADOR! El fuego y la sangre te queman. Recibes " + danoMariaExtra + " de daño.",
                                0.8, false);
                    } else {
                        vidaJug = vidaJug - danoMariaBase;

                        FuncionesGraficas.FotoyMensaje(
                                "Corte rápido",
                                "src/main/java/imagenes/ladyMaria.png",
                                "Sus movimientos son elegantes pero letales. Recibes " + danoMariaBase + " de daño.",
                                1.2, false);
                    }
                }

                if (vidaJug <= 0) {
                    FuncionesGraficas.FotoyMensaje(
                            "HAS MUERTO",
                            "src/main/java/imagenes/YouDied.png",
                            "La pesadilla vuelve a empezar...",
                            0.8, false);
                    peleando = false;
                    System.exit(0);
                    break;
                }
            }
        }
    }

    static void escena4() {

        if (insigniaKosm == true) {
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
                            if (rakuyo == true) {
                                FuncionesGraficas.warning(
                                        "Pozo vacío",
                                        "El agua está en calma y teñida de rojo."
                                        + "\nYa has acabado con las bestias y obtenido la Rakuyo."
                                        + "\nNo hay razón para volver a bajar.");

                                escena4();
                            } else if (cuchillaChaman == false) {
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
        } else {
            FuncionesGraficas.warning("No puedes entrar", "Necesitas la Insignia de Kosm para acceder a la pesadilla de la Aldea Pesquera.");
            escena0();
        }
    }
    
    static void luchaTiburones() {

        int vidaJug = 140;
        int vidaTiburon = 250;
        int danoJugBase = 70;
        int danoTiburonBase = 50;
        int danoTiburonExtra = 90;
        int danoVisceral = 150;
        boolean peleando = true;
        
        while (peleando == true) {

            String[] opcionesLT = {
                "1. Atacar",
                "2. Ataque visceral"};

            int opcionLT = FuncionesGraficas.FotoMensajeMenu(
                    "Combate contra los tiburones",
                    opcionesLT,
                    "src/main/java/imagenes/luchaTiburones.png",
                    "Decide con que quieres atacar: ",
                    1.2, false);

            switch (opcionLT) {

                case 0: //Ataque normal
                    FuncionesGraficas.FotoyMensaje(
                            "Ataque",
                            "src/main/java/imagenes/ataqueSimple.png",
                            "Directo al corazón...",
                            0.8, false);
                    vidaTiburon = vidaTiburon - danoJugBase;
                    break;

                case 1: //Ataque visceral
                    if (ataqueVisceral == true) {
                        FuncionesGraficas.FotoyMensaje(
                                "¡Ataque visceral!",
                                "src/main/java/imagenes/ataqueVisceral.png",
                                "Tu ataque visceral impacta con una precisión brutal.",
                                0.8, false);

                        vidaTiburon = vidaTiburon - danoVisceral;
                    } else {
                        FuncionesGraficas.warning("No disponible", "No puedes usar el ataque visceral");
                        continue;
                    }
                    break;

            }

            if (vidaTiburon <= 0) {
                FuncionesGraficas.FotoyMensaje(
                        "¡VICTORIA!",
                        "src/main/java/imagenes/tiburonMuerto.png",
                        "El gigante cae.",
                        0.8, false);

                FuncionesGraficas.FotoyMensaje(
                        "¡VICTORIA!",
                        "src/main/java/imagenes/Rakuyo.png",
                        "Consigues la Rakuyo.",
                        0.8, false);
                peleando = false;
                tiburon = false;
                rakuyo = true;
                cordonHab3 = true;
                
            } else {
                
                FuncionesGraficas.FotoyMensaje(
                        "La bestia carga", 
                        "src/main/java/imagenes/luchaTiburones.png", 
                        "El tiburón hunde los pies en el suelo y se prepara para atacar...", 
                        1.2, false);
                
                int suerteDefensa = (int) (Math.random() * 100);

                if (suerteDefensa < 20) {

                    FuncionesGraficas.FotoyMensaje(
                            "Esquiva",
                            "src/main/java/imagenes/esquiva.png",
                            "El ancla pasa rozando tu cabeza. Ruedas a tiempo y no sufres daños.",
                            0.8, false);
                } else if (suerteDefensa > 85) {
                    vidaJug = vidaJug - danoTiburonExtra;

                    FuncionesGraficas.FotoyMensaje(
                            "¡GOLPE CRÍTICO!",
                            "src/main/java/imagenes/tiburonSolo.png",
                            "¡BRUTAL! Te lanza contra la pared. Recibes " + danoTiburonExtra + " de daño.",
                            0.8, false);
                } else {
                    vidaJug = vidaJug - danoTiburonBase;

                    FuncionesGraficas.FotoyMensaje(
                            "Impacto",
                            "src/main/java/imagenes/tiburonSolo.png",
                            "El golpe te sacude los huesos. Recibes " + danoTiburonBase + " de daño.",
                            1.2, false);
                }
            }
            if (vidaJug <= 0) {
                FuncionesGraficas.FotoyMensaje(
                        "HAS MUERTO",
                        "src/main/java/imagenes/YouDied.png",
                        "La oscuridad te consume...",
                        0.8, false);
                peleando = false;
                System.exit(0);
                break;
            }
        }
    }

    static void escena5() {
        if (bestiaClerigo == false && ladyMaria == false && tiburon == false) {
            FuncionesGraficas.FotoyMensaje(
                    "Umbral de la pesadilla",
                    "imagenes/FinalBossIntro.png", // fotofinal1
                    "Has superado todas las pruebas."
                    + "\nAnte ti, la pesadilla se condensa en una única forma imposible."
                    + "\nNo hay vuelta atrás.",
                    0.8, false);

            String[] opciones = {"Luchar"}; //Única opción, no tienes vuelta atrás, solo aceptar
            FuncionesGraficas.FotoMensajeMenu(
                    "Última decisión",
                    opciones,
                    "imagenes/FinalBossIntro.png",//final2
                    "Solo si has vencido en las tres peleas puedes llegar hasta aquí."
                    + "\nAceptas tu destino… y alzas tu arma.",
                    0.8, false);

            if (cordon == 3) {
                //Esto es como una historia, esta parte sería la que tiene el final bueno.
                FuncionesGraficas.FotoyMensaje( 
                        "La luna se rompe",
                        "imagenes/escenafinal.png",
                        "Los tres tercios de cordón laten al unísono en tu interior."
                        + "\nLa luna roja tiembla sobre el Sueño del Cazador y se agrieta como cristal viejo."
                        + "\nLa criatura final ruge, pero algo en el mundo entero empieza a romperse.",
                        0.8, false);

                FuncionesGraficas.FotoyMensaje(
                        "Cazador contra Pesadilla",
                        "imagenes/FinalBueno2.png",//final3
                        "La bestia se abalanza sobre ti. Cada impacto debería matarte, pero sigues en pie.\n"
                        + "Tus golpes atraviesan carne y raíces, arrancando gritos que resuenan en todo el sueño.\n"
                        + "Por un instante, comprendes que esta vez… sí puedes ganar.",
                        0.8, false);

                // Viñeta 3: golpe final + despertar
                FuncionesGraficas.FotoyMensaje(
                        "Despertar del cazador",
                        "imagenes/FinalBueno3.png",//finalbueno
                        "Encuentras una única abertura en el caos de extremidades.\n"
                        + "Clavas tu arma con todas tus fuerzas. La pesadilla se agrieta y se desmorona."
                        + "\nAbres los ojos en una cama desconocida. No hay luna roja. No hay ecos.\n"
                        + "\nSolo el viento colándose por una ventana abierta."
                        + "\nLa cacería ha terminado.",
                        0.8, false);

                t2 = System.currentTimeMillis(); //Tomamos el tiempo final que ha tardado el jugador y lo añadimos al Hall of fame
                long duracionSegundos = (t2 - t1) / 1000;

                FuncionesGraficas.mostrarDatos(
                        "Fin del juego",
                        "Has derrotado a todos los bosses y has eliminado la pesadilla."
                        + "\nTiempo total de la cacería: " + duracionSegundos + " segundos."
                );

                System.exit(0);

            } else {

                //La otra parte de la historia, no consigues todos los tercios de los cordones umbilicales y quedas atrapado para siempre.
                FuncionesGraficas.FotoyMensaje(
                        "Cordones insuficientes",
                        "imagenes/FinalMalo1.png",//final3
                        "Los cordones que llevas dentro laten con violencia, pero uno de ellos permanece en silencio."
                        + "\nLa criatura final te observa desde lo alto, como si ya conociera el resultado."
                        + "\nSabes que algo falla… pero es demasiado tarde para retroceder.",
                        0.8, false);

                FuncionesGraficas.FotoyMensaje(
                        "A mitad del abismo",
                        "imagenes/FinalMalo2.png",//finalmalo2
                        "Luchas con todo lo que te queda. Hieres a la pesadilla, la haces retroceder."
                        + "\nSu forma se contrae y parece desmoronarse. Crees que estás ganando."
                        + "\nEntonces, el sueño entero da un único latido.",
                        0.8, false);

                FuncionesGraficas.FotoyMensaje(
                        "Prisionero del Sueño",
                        "imagenes/FinalMalo3.png",//finalmalo3
                        "Los cordones incompletos no bastan."
                        + "\nLa pesadilla comprende tu intento… y se ríe de ti en silencio."
                        + "\nUn pulso recorre todo el Sueño del Cazador. Tu cuerpo se queda inmóvil, clavado en el suelo."
                        + "\nPasan noches, pasan lunas, pasan nuevos cazadores…"
                        + "\nPara ellos, la cacería acaba de empezar. Para ti… nunca terminará.",
                        0.8, false);

                System.exit(0);
            }

        } else {
            FuncionesGraficas.warning(
                    "Entrada cerrada",
                    "La entrada permanece cerrada."
                    + "\nTres presencias poderosas siguen vivas y te impiden avanzar.");
            escena0();
        }
    }
}
