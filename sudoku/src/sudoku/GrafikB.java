/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.*;        
import java.awt.event.*; 
import javax.swing.*;    


public class GrafikB extends JFrame {

    public static final int CELL_SIZE = 50;   
    public static final int CANVAS_WIDTH = CELL_SIZE * 9;
    public static final int CANVAS_HEIGHT = CELL_SIZE * 9;
    public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); 
  
    public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);

    private JTextField[][] tfCells = new JTextField[9][9];
    public static int[][] puzzle = new int[9][9];

    public GrafikB() {

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(9, 9));

        for (int satir = 0; satir < 9; ++satir) {
            for (int sutun = 0; sutun < 9; ++sutun) {
                tfCells[satir][sutun] = new JTextField();
                cp.add(tfCells[satir][sutun]);
                tfCells[satir][sutun].setText(puzzle[satir][sutun] + "");
                tfCells[satir][sutun].setEditable(false);
                tfCells[satir][sutun].setBackground(CLOSED_CELL_BGCOLOR);
                tfCells[satir][sutun].setForeground(ThreadB.CLOSED_CELL_TEXT);
                tfCells[satir][sutun].setHorizontalAlignment(JTextField.CENTER);
                tfCells[satir][sutun].setFont(FONT_NUMBERS);
            }
        }

        cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle(ThreadB.GrafikAdiB);
        setVisible(true);

    }

    public static void main(String[] args) {
    }

}
