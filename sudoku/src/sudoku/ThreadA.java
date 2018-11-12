package sudoku;

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadA implements Runnable {

    static List<String> bb = new ArrayList<String>();
 
    int[][] newBoard = new int[9][9];
    static String GrafikAdiA = " ";
    private String ad;
    public static Color CLOSED_CELL_TEXT;

    public ThreadA(String ad) {
        this.ad = ad;
    }

    ThreadA() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void run() {
        int[][] tahta = setUpBoard();

        int ii, jj,i,j,rr, randDeger;

        long start, end = 0;
        Random generator = new Random(System.currentTimeMillis());
        tahta = setUpBoard();
       ii = generator.nextInt(800);
        jj = generator.nextInt(800);
        i=(ii%9);
         j=(jj%9);
         rr=generator.nextInt(800);
        randDeger = (rr%8) + 1;

        start = System.currentTimeMillis();
        if (cozum(i, j, tahta, 0, randDeger) && Main.bittiMi != true) {
            Main.bittiMi = true;
            end = System.currentTimeMillis();
            System.out.print(ad);
            System.out.print("Time (ms)" + (end - start) + "\n");
            GrafikAdiA = "Board A=" + (end - start) + " MS DE BULDU";
            CLOSED_CELL_TEXT = Color.GREEN;
            ekranaYazdir(tahta);
        } 
        else {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadA.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(ad);
            GrafikAdiA = "Board A";
            ekranaYazdir(tahta);
        }
    }

    static int[][] setUpBoard() {

        int[][] newBoard = new int[9][9];
        int i, j, n = 0;

        String str = " ";
        String[] veri = new String[9];
        char[] a = new char[81];
        try {
            FileInputStream fileStream = new FileInputStream("sudoku.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataStream));

            for (i = 0; i < 9; i++) {
                str = bufferReader.readLine();
                veri[i] = str;
            }
            dataStream.close();

        } catch (Exception e) {
            System.out.println("Hata : " + e.getMessage());
        }

        
        String[] words = new String[9];
        for (i = 0; i <= 8; i++) {
            words[i] = veri[i].replaceAll("\\*", "0");
        }
        int z = 0;

        for (int b = 0; b < 9; b++) {
            for (int c = 0; c < 9; c++) {

                a[z] = words[b].charAt(c);
                z++;
            }
        }

        int[] puzzle = new int[81];
        for (int t = 0; t < 81; t++) {
            puzzle[t] = a[t] - '0';
        }
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                newBoard[i][j] = puzzle[n++];
            }
        }
        return newBoard;

    }

    static boolean cozum(int satir, int sutun, int[][] tahta, int kacKere, int startV) {
        if (kacKere == 81) {
            return true;
        }
        if (Main.bittiMi) {
            return true;
        }

      
        if (++sutun == 9) {
            sutun = 0;
            if (++satir == 9) {
                satir = 0;
            }
        }

        if (tahta[satir][sutun] != 0) {  
            return cozum(satir, sutun, tahta, kacKere + 1, startV);
        }

       
        for (int val = 1; val <= 9; ++val) {
            if (++startV == 10) {
                startV = 1;
            }
            
            
            if (kontrol(satir, sutun ,startV, tahta)) {
                tahta[satir][sutun] = startV;  
                if (cozum(satir, sutun, tahta, kacKere + 1, startV)) {
                    String a = (1 + satir) + ".satır  " + (1 + sutun) + ".sütun " + tahta[satir][sutun] + " \n ";
                    bb.add(a);
                  
                    return true;
                }
            }
        }

        tahta[satir][sutun] = 0; 
        return false;
    }
    

    static boolean kontrol(int satir, int sutun, int ranDeger, int[][] tahta) {
        int i;

      
        for (i = 0; i < 9; i++) {
            if (tahta[satir][i] == ranDeger) {
                return false;
            }
            
            if (tahta[i][sutun] == ranDeger) {
                return false;
            }
            
            if (tahta[satir / 3 * 3 + i % 3][sutun / 3 * 3 + i / 3] == ranDeger) {
                return false;
            }
        }
        return true; 
    }

    static void ekranaYazdir(int[][] TahtadanYazdir) {
        int i, j;

        for (i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" -----------------------");
            }

            for (j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                if (TahtadanYazdir[i][j] == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(Integer.toString(TahtadanYazdir[i][j]) + " ");
                    GrafikA.puzzle[i][j] = TahtadanYazdir[i][j];
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
      
    }
}
