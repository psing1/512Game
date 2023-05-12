/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.mainmenu;
import java.util.Arrays;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.InterruptedException;
import java.lang.Thread;     

import java.lang.Object;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author punz1738
 */





public class Game extends javax.swing.JFrame {
    Board main_board = new Board(4);
    Board ghost_board = new Board(4);
    public static int fib(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return (fib(n-1)+fib(n- 2));
    }
    public static void sleep(int s){
        int k = s;
        fib(45);
    }
    
 
    
    public static boolean check_legal(int dir, Board b1, Board ghost){
        Board copyghost = new Board(4);
        copyghost.set_board(ghost.getBoard()[0],ghost.getBoard()[1],ghost.getBoard()[2],ghost.getBoard()[3]);
        switch (dir){
            case 0:
                copyghost.compress_up();
                copyghost.merge_up();
                copyghost.compress_up();
                break;
            case 1:
                copyghost.compress_down();
                copyghost.merge_down();
                copyghost.compress_down();
                break;
            case 2:
                copyghost.compress_left();
                copyghost.merge_left();
                copyghost.compress_left();
                break;
            case 3:
                copyghost.compress_right();
                copyghost.merge_right();
                copyghost.compress_right();
                break;
        }

        return !(b1.same_as(copyghost));
    }
    

    
    public static boolean check_lost(Board B1, Board ghost){
        Board copyghost1 = new Board(4);
        copyghost1.set_board(ghost.getBoard()[0],ghost.getBoard()[1],ghost.getBoard()[2],ghost.getBoard()[3]);
        
        for (int i = 0 ; i < 4 ; i++){
            if (check_legal(i,B1,copyghost1)){
                return true;
            }
        }
        return false;
    }
    
    int[][] temp;
    public void setGUIBoard(int[]r1, int[] r2, int[]r3, int[]r4){
        B1.setText(""+r1[0]);
        B2.setText(""+r1[1]);
        B3.setText(""+r1[2]);
        B4.setText(""+r1[3]);
        
        B5.setText(""+r2[0]);
        B6.setText(""+r2[1]);
        B7.setText(""+r2[2]);
        B8.setText(""+r2[3]);
        
        B9.setText(""+r3[0]);
        B10.setText(""+r3[1]);
        B11.setText(""+r3[2]);
        B12.setText(""+r3[3]);
        
        B13.setText(""+r4[0]);
        B14.setText(""+r4[1]);
        B15.setText(""+r4[2]);
        B16.setText(""+r4[3]);
        
        
    }
    
    public void Reset(){
        main_board = new Board(4);
        main_board.ins_rand();
        main_board.ins_rand();
        temp = main_board.getBoard();
        setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
        ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
    }
    
    public void Listen(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode()==KeyEvent.VK_UP){
            if (check_legal(0,main_board,ghost_board)){
            main_board.compress_up();
            main_board.merge_up();
            main_board.compress_up();
            main_board.ins_rand();
            temp = main_board.getBoard();
            setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
            ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
            Colour();
            
            if (!(check_lost(main_board,ghost_board))){
                main_board.compress_up();
                main_board.merge_up();
                main_board.compress_up();
                temp = main_board.getBoard();
                setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
                ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
                Colour();
                Lost lost = new Lost();
                
                sleep(3);
                
                this.setVisible(false);
                lost.setVisible(true);
                
                Reset();
            }
            }
        }

        else if (evt.getKeyCode()==KeyEvent.VK_DOWN){
            if (check_legal(1,main_board,ghost_board)){
            main_board.compress_down();
            main_board.merge_down();
            main_board.compress_down();
            main_board.ins_rand();
            temp = main_board.getBoard();
            setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
            ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
            Colour();
            
            if (!(check_lost(main_board,ghost_board))){
                main_board.compress_down();
                main_board.merge_down();
                main_board.compress_down();
                temp = main_board.getBoard();
                setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
                ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
                Colour();
                Lost lost = new Lost();
                
                sleep(3);
                
                this.setVisible(false);
                lost.setVisible(true);
                
                Reset();
            }
            }
        }

        else if (evt.getKeyCode()==KeyEvent.VK_LEFT){
            if (check_legal(2,main_board,ghost_board)){
            main_board.compress_left();
            main_board.merge_left();
            main_board.compress_left();
            main_board.ins_rand();
            temp = main_board.getBoard();
            setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
            ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
            Colour();
            
            if (!(check_lost(main_board,ghost_board))){
                main_board.compress_left();
                main_board.merge_left();
                main_board.compress_left();
                temp = main_board.getBoard();
                setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
                ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
                Colour();
                Lost lost = new Lost();
                
                sleep(3);
                
                this.setVisible(false);
                lost.setVisible(true);
                
                Reset();
            }
            }
        }

        else if (evt.getKeyCode()==KeyEvent.VK_RIGHT){
            if (check_legal(3,main_board,ghost_board)){
            main_board.compress_right();
            main_board.merge_right();
            main_board.compress_right();
            main_board.ins_rand();
            temp = main_board.getBoard();
            setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
            ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
            Colour();
            
            
            if (!(check_lost(main_board,ghost_board))){
                main_board.compress_right();
                main_board.merge_right();
                main_board.compress_right();
                temp = main_board.getBoard();
                setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
                ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
                Colour();
                Lost lost = new Lost();
                
                sleep(3);
                
                this.setVisible(false);
                lost.setVisible(true);
                
                Reset();
            }
            }
        }

        else{
            //nothing
        }
    }    
    public void Colour(){
        List<JLabel> LabelList = List.of(B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16);
        List<JPanel> PanelList = List.of(Block1,Block2,Block3,Block4,Block5,Block6,Block7,Block8,Block9,Block10,Block11,Block12,Block13,Block14,Block15,Block16);
        
        for (int x = 0; x <16;x++){
            JPanel panel = PanelList.get(x);
            JLabel label = LabelList.get(x);
            
            switch (label.getText()) {
                case "0" -> {
                    panel.setBackground(new Color(50,50,50));
                    label.setForeground(new Color(50,50,50));
                }
                case "2" -> panel.setBackground(new Color(255,255,13));
                case "4" -> panel.setBackground(new Color(250,206,12));
                case "8" -> panel.setBackground(new Color(255,183,0));
                case "16" -> panel.setBackground(new Color(250,159,12));
                case "32" -> panel.setBackground(new Color(255,131,13));
                case "64" -> panel.setBackground(new Color(255,112,13));
                case "128" -> panel.setBackground(new Color(250,75,12));
                case "256" -> panel.setBackground(new Color(255,30,0));
                case "512" -> {
                   
                   WIn won = new WIn();
                   
                   temp = main_board.getBoard();
                   setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
                   panel.setBackground(new Color(255,13,159));
                   ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);

                   //panel.setBackground(new Color(255,13,159));

                  
                   fib(45);
                   won.setVisible(true);
              
                   this.setVisible(false);
                   

                   Reset();
                }
                default -> {
                }
            }
            
        }
    }
    
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        jLayeredPane1.setVisible(false);
        main_board.ins_rand();
        main_board.ins_rand();
        //main_board.cheat();
        temp = main_board.getBoard();
        setGUIBoard(temp[0],temp[1],temp[2],temp[3]);
        ghost_board.set_board(main_board.getBoard()[0],main_board.getBoard()[1],main_board.getBoard()[2],main_board.getBoard()[3]);
        Colour();
        
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bUP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Block4 = new javax.swing.JPanel();
        B4 = new javax.swing.JLabel();
        Block5 = new javax.swing.JPanel();
        B5 = new javax.swing.JLabel();
        Block6 = new javax.swing.JPanel();
        B6 = new javax.swing.JLabel();
        Block7 = new javax.swing.JPanel();
        B7 = new javax.swing.JLabel();
        Block8 = new javax.swing.JPanel();
        B8 = new javax.swing.JLabel();
        Block9 = new javax.swing.JPanel();
        B9 = new javax.swing.JLabel();
        Block10 = new javax.swing.JPanel();
        B10 = new javax.swing.JLabel();
        Block11 = new javax.swing.JPanel();
        B11 = new javax.swing.JLabel();
        Block12 = new javax.swing.JPanel();
        B12 = new javax.swing.JLabel();
        Block13 = new javax.swing.JPanel();
        B13 = new javax.swing.JLabel();
        Block14 = new javax.swing.JPanel();
        B14 = new javax.swing.JLabel();
        Block15 = new javax.swing.JPanel();
        B15 = new javax.swing.JLabel();
        Block16 = new javax.swing.JPanel();
        B16 = new javax.swing.JLabel();
        Block1 = new javax.swing.JPanel();
        B1 = new javax.swing.JLabel();
        Block2 = new javax.swing.JPanel();
        B2 = new javax.swing.JLabel();
        Block3 = new javax.swing.JPanel();
        B3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(50, 50, 60));
        setLocation(new java.awt.Point(500, 250));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 50, 60));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        bUP.setBackground(new java.awt.Color(50, 50, 60));
        bUP.setBorder(null);
        bUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUPActionPerformed(evt);
            }
        });
        bUP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bUPKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(bUP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(bUP))
        );

        jPanel3.setBackground(new java.awt.Color(50, 50, 60));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });

        jToggleButton1.setText("Menu");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToggleButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jToggleButton1KeyPressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(50, 50, 60));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton2.setText("Instructions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Settings");

        jButton4.setText("Quit Game");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(50, 50, 70));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        B4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B4.setText("B4");

        javax.swing.GroupLayout Block4Layout = new javax.swing.GroupLayout(Block4);
        Block4.setLayout(Block4Layout);
        Block4Layout.setHorizontalGroup(
            Block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block4Layout.setVerticalGroup(
            Block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B5.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B5.setText("B5");

        javax.swing.GroupLayout Block5Layout = new javax.swing.GroupLayout(Block5);
        Block5.setLayout(Block5Layout);
        Block5Layout.setHorizontalGroup(
            Block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block5Layout.setVerticalGroup(
            Block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B6.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B6.setText("B6");

        javax.swing.GroupLayout Block6Layout = new javax.swing.GroupLayout(Block6);
        Block6.setLayout(Block6Layout);
        Block6Layout.setHorizontalGroup(
            Block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block6Layout.setVerticalGroup(
            Block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B7.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B7.setText("B7");

        javax.swing.GroupLayout Block7Layout = new javax.swing.GroupLayout(Block7);
        Block7.setLayout(Block7Layout);
        Block7Layout.setHorizontalGroup(
            Block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block7Layout.setVerticalGroup(
            Block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B8.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B8.setText("B8");

        javax.swing.GroupLayout Block8Layout = new javax.swing.GroupLayout(Block8);
        Block8.setLayout(Block8Layout);
        Block8Layout.setHorizontalGroup(
            Block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block8Layout.setVerticalGroup(
            Block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B9.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B9.setText("B9");

        javax.swing.GroupLayout Block9Layout = new javax.swing.GroupLayout(Block9);
        Block9.setLayout(Block9Layout);
        Block9Layout.setHorizontalGroup(
            Block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block9Layout.setVerticalGroup(
            Block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B10.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B10.setText("B10");

        javax.swing.GroupLayout Block10Layout = new javax.swing.GroupLayout(Block10);
        Block10.setLayout(Block10Layout);
        Block10Layout.setHorizontalGroup(
            Block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block10Layout.setVerticalGroup(
            Block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B11.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B11.setText("B11");

        javax.swing.GroupLayout Block11Layout = new javax.swing.GroupLayout(Block11);
        Block11.setLayout(Block11Layout);
        Block11Layout.setHorizontalGroup(
            Block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block11Layout.setVerticalGroup(
            Block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B12.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B12.setText("B12");

        javax.swing.GroupLayout Block12Layout = new javax.swing.GroupLayout(Block12);
        Block12.setLayout(Block12Layout);
        Block12Layout.setHorizontalGroup(
            Block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B12)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block12Layout.setVerticalGroup(
            Block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B12)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B13.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B13.setText("B13");

        javax.swing.GroupLayout Block13Layout = new javax.swing.GroupLayout(Block13);
        Block13.setLayout(Block13Layout);
        Block13Layout.setHorizontalGroup(
            Block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B13)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block13Layout.setVerticalGroup(
            Block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B13)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B14.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B14.setText("B14");

        javax.swing.GroupLayout Block14Layout = new javax.swing.GroupLayout(Block14);
        Block14.setLayout(Block14Layout);
        Block14Layout.setHorizontalGroup(
            Block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B14)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block14Layout.setVerticalGroup(
            Block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B14)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B15.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B15.setText("B15");

        javax.swing.GroupLayout Block15Layout = new javax.swing.GroupLayout(Block15);
        Block15.setLayout(Block15Layout);
        Block15Layout.setHorizontalGroup(
            Block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B15)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block15Layout.setVerticalGroup(
            Block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B15)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B16.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B16.setText("B16");

        javax.swing.GroupLayout Block16Layout = new javax.swing.GroupLayout(Block16);
        Block16.setLayout(Block16Layout);
        Block16Layout.setHorizontalGroup(
            Block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B16)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block16Layout.setVerticalGroup(
            Block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B16)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B1.setText("B1");

        javax.swing.GroupLayout Block1Layout = new javax.swing.GroupLayout(Block1);
        Block1.setLayout(Block1Layout);
        Block1Layout.setHorizontalGroup(
            Block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block1Layout.setVerticalGroup(
            Block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B2.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B2.setText("B2");

        javax.swing.GroupLayout Block2Layout = new javax.swing.GroupLayout(Block2);
        Block2.setLayout(Block2Layout);
        Block2Layout.setHorizontalGroup(
            Block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block2Layout.setVerticalGroup(
            Block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        B3.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        B3.setText("B3");

        javax.swing.GroupLayout Block3Layout = new javax.swing.GroupLayout(Block3);
        Block3.setLayout(Block3Layout);
        Block3Layout.setHorizontalGroup(
            Block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Block3Layout.setVerticalGroup(
            Block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Block3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(B3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Block1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Block5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Block9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Block13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Block16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Block4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Block2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Block1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Block3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Block5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Block9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Block13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 145, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        Listen(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        
    }//GEN-LAST:event_jPanel2KeyPressed

    private void bUPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bUPKeyPressed
        Listen(evt);
    }//GEN-LAST:event_bUPKeyPressed

    private void bUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUPActionPerformed
        
    }//GEN-LAST:event_bUPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Instructions in1= new Instructions ();
        in1.setVisible (true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected())
        {
               jLayeredPane1.setVisible(true);
               
        }
        
        else{
        jLayeredPane1.setVisible(false);
       
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        Listen(evt);
    }//GEN-LAST:event_jPanel3KeyPressed

    private void jToggleButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton1KeyPressed
        Listen(evt);
    }//GEN-LAST:event_jToggleButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame myframe = new JFrame();

                myframe.setVisible(true);
                myframe.setAlwaysOnTop(true); 
                myframe.toFront();
                myframe.requestFocus();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B10;
    private javax.swing.JLabel B11;
    private javax.swing.JLabel B12;
    private javax.swing.JLabel B13;
    private javax.swing.JLabel B14;
    private javax.swing.JLabel B15;
    private javax.swing.JLabel B16;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B6;
    private javax.swing.JLabel B7;
    private javax.swing.JLabel B8;
    private javax.swing.JLabel B9;
    private javax.swing.JPanel Block1;
    private javax.swing.JPanel Block10;
    private javax.swing.JPanel Block11;
    private javax.swing.JPanel Block12;
    private javax.swing.JPanel Block13;
    private javax.swing.JPanel Block14;
    private javax.swing.JPanel Block15;
    private javax.swing.JPanel Block16;
    private javax.swing.JPanel Block2;
    private javax.swing.JPanel Block3;
    private javax.swing.JPanel Block4;
    private javax.swing.JPanel Block5;
    private javax.swing.JPanel Block6;
    private javax.swing.JPanel Block7;
    private javax.swing.JPanel Block8;
    private javax.swing.JPanel Block9;
    private javax.swing.JButton bUP;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
