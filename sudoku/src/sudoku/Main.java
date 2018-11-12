package sudoku;

import java.util.*;
import java.io.*;

public class Main extends Thread {

    static boolean bittiMi;
    static int table = 0;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException {
        File txtDosyalari = new File("A.txt");
        txtDosyalari.delete();
        txtDosyalari = new File("B.txt");
        txtDosyalari.delete();
        txtDosyalari = new File("C.txt");
        txtDosyalari.delete();
        txtDosyalari = new File("D.txt");
        txtDosyalari.delete();

        bittiMi = false;
        Thread thread1 = new Thread(new ThreadA("t1"));
        Thread thread2 = new Thread(new ThreadB("t2"));
        Thread thread3 = new Thread(new ThreadC("t3"));
        Thread thread4 = new Thread(new ThreadD("t4"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(20000);
         
         
        GrafikA bo1 = new GrafikA();
        GrafikB bo2 = new GrafikB();
        GrafikC bo3 = new GrafikC();
        GrafikD bo4 = new GrafikD();
        
        bo1.setBounds(0, 0, 400, 400);
        bo2.setBounds(400, 0, 400, 400);
        bo3.setBounds(0, 400, 400, 400);
        bo4.setBounds(400, 400, 400, 400);
      
        dosyayayazdir();
  
     
        
    }

    private static void dosyayayazdir() {

        try {
            File dosya = new File("A.txt");
            FileWriter outFile = new FileWriter(dosya, true);

            PrintWriter out = new PrintWriter(outFile);

            for (String b : ThreadA.bb) {
                out.println(b);
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        try {
            File dosya = new File("B.txt");
            FileWriter outFile = new FileWriter(dosya, true);

            PrintWriter out = new PrintWriter(outFile);

            for (String b : ThreadB.bb) {
                out.println(b);
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        try {
            File dosya = new File("C.txt");
            FileWriter outFile = new FileWriter(dosya, true);

            PrintWriter out = new PrintWriter(outFile);

            for (String b : ThreadC.bb) {
                out.println(b);
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        try {
            File dosya = new File("D.txt");
            FileWriter outFile = new FileWriter(dosya, true);

            PrintWriter out = new PrintWriter(outFile);

            for (String b : ThreadD.bb) {
                out.println(b);
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

    }

    
}
