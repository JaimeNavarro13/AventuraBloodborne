/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author jaaii
 */

import modulos.FuncionesSonidos;

public class GestorSonidos {
    
    private static FuncionesSonidos bandaSonora;
    private static FuncionesSonidos musicaLuchaBestiaClerigo;
    private static FuncionesSonidos musicaLuchaLadyMaria;
    private static FuncionesSonidos musicaLuchaTiburones;
    private static FuncionesSonidos musicaEscenaFinal;

    static {
        bandaSonora  = new FuncionesSonidos("src/main/java/Sonidos/BandaSonora.mp3", 1);
        musicaLuchaBestiaClerigo  = new FuncionesSonidos("src/main/java/Sonidos/LuchaBestiaClerigo.mp3", 1);
        musicaLuchaLadyMaria = new FuncionesSonidos("src/main/java/Sonidos/LuchaLadyMaria.mp3", 1);
        musicaLuchaTiburones = new FuncionesSonidos("src/main/java/Sonidos/LuchaTiburones.mp3", 1);
        musicaEscenaFinal = new FuncionesSonidos("src/main/java/Sonidos/EscenaFinal.mp3", 1);
    }

    public static void iniciarMusicaFondo() {
        bandaSonora.reproducirSonidoMp3(null);
    }

    public static void pararMusicaFondo() {
        bandaSonora.pararSonidoMp3();
    }

    public static void iniciarMusicaPeleaBestiaClerigo() {
        musicaLuchaBestiaClerigo.reproducirSonidoMp3(null);
    }

    public static void pararMusicaPeleaBestiaClerigo() {
        musicaLuchaBestiaClerigo.pararSonidoMp3();
    }
    
    public static void iniciarMusicaPeleaLadyMaria() {
        musicaLuchaLadyMaria.reproducirSonidoMp3(null);
    }

    public static void pararMusicaPeleaLadyMaria() {
        musicaLuchaLadyMaria.pararSonidoMp3();
    }
    
    public static void iniciarMusicaPeleaTiburones() {
        musicaLuchaTiburones.reproducirSonidoMp3(null);
    }

    public static void pararMusicaPeleaTiburones() {
        musicaLuchaTiburones.pararSonidoMp3();
    }
    
        public static void iniciarMusicaEscenaFinal() {
        musicaEscenaFinal.reproducirSonidoMp3(null);
    }

    public static void pararMusicaEscenaFinal() {
        musicaEscenaFinal.pararSonidoMp3();
    }



}
