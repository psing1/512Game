/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.mainmenu;

/**
 *
 * @author punz1738
 */
import java.util.Arrays;
public class Board{
    private int[] row1, row2, row3, row4;
    public static boolean IntegerInArray(int[] a, int targ){
        for (int i : a){
            if (i==targ){
                return true;
            }
        }
        return false;
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Board(int len){
        this.row1 = new int[len];
        this.row2 = new int[len];
        this.row3 = new int[len];
        this.row4 = new int[len];
    }
    
    public void cheat(){
        this.row1[0] = 256;
        this.row1[1] = 256;
    }
    
    public void ins_rand(){
        int[] row_chosen = new int[4];
        int temp1;
        int returnValue;
        int temp;
        do
        {
            temp = Board.getRandomNumber(0,4);
            switch(temp){
                case 0:
                    row_chosen = this.row1;
                    break;
                case 1:
                    row_chosen = this.row2;
                    break;
                case 2:
                    row_chosen = this.row3;
                    break;
                case 3:
                    row_chosen = this.row4;
            }
        } while(!Board.IntegerInArray(row_chosen,0));
        do{
            temp1 = Board.getRandomNumber(0,4);
        }while(row_chosen[temp1]!=0);

        int rand_1to10 = Board.getRandomNumber(1,11);
        if (rand_1to10==10){
            returnValue = 4;
        }else{
            returnValue = 2;
        }

        switch(temp){
            case 0:
                this.row1[temp1] = returnValue;
                break;
            case 1:
                this.row2[temp1] = returnValue;
                break;
            case 2:
                this.row3[temp1] = returnValue;
                break;
            case 3:
                this.row4[temp1] = returnValue;
                break;
        }
    }

    public boolean same_as(Board b1){
        for (int i = 0 ; i<4 ; i++){
            for (int j = 0 ; j<4 ; j++){
                if (this.getBoard()[i][j] != b1.getBoard()[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void print_board(){
        System.out.println(Arrays.toString(this.row1));
        System.out.println(Arrays.toString(this.row2));
        System.out.println(Arrays.toString(this.row3));
        System.out.println(Arrays.toString(this.row4));
    }

    public void set_board(int[] r1,int[] r2,int[] r3,int[] r4){
        this.row1 = Arrays.copyOf(r1,4);
        this.row2 = Arrays.copyOf(r2,4);
        this.row3 = Arrays.copyOf(r3,4);
        this.row4 = Arrays.copyOf(r4,4);
    }


    

    public int[][] getBoard(){
        return new int[][]{this.row1,this.row2,this.row3,this.row4};
    }
    public void compress_up(){
        int temp;
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row1[indC] == 0){
                temp = this.row2[indC];
                this.row1[indC] = temp;
                this.row2[indC] = 0;
            }            
        }
        //row 3
        for (int indC = 0 ; indC < 4 ; indC++){
            int gap = 0;
            if (this.row1[indC] == 0){
                gap ++;
            }
            if (this.row2[indC] == 0){
                gap ++;
            }
            switch (gap){
                case 0:
                    break;
                case 1:
                    temp = this.row3[indC];
                    this.row2[indC] = temp;
                    this.row3[indC] = 0;
                    break;
                case 2:
                    temp = this.row3[indC];
                    this.row1[indC] = temp;
                    this.row3[indC] = 0;
                    break;
            }
        }
        for (int indC = 0 ; indC < 4 ; indC++){
            //row 4
            int gap = 0;
            if (this.row1[indC] == 0){
                gap ++;
            }
            if (this.row2[indC] == 0){
                gap ++;
            }
            if (this.row3[indC] == 0){
                gap++;
            }
            switch (gap){
                case 0:
                    break;
                case 1:
                    temp = this.row4[indC];
                    this.row3[indC] = temp;
                    this.row4[indC] = 0;
                    break;
                case 2:
                    temp = this.row4[indC];
                    this.row2[indC] = temp;
                    this.row4[indC] = 0;
                    break;
                case 3:
                    temp = this.row4[indC];
                    this.row1[indC] = temp;
                    this.row4[indC] = 0;
                    break;
            }
        }
    }
    public void compress_down(){
        int temp;
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row4[indC] == 0){
                temp = this.row3[indC];
                this.row4[indC] = temp;
                this.row3[indC] = 0;
            }            
        }
        //row 3
        for (int indC = 0 ; indC < 4 ; indC++){
            int gap = 0;
            if (this.row4[indC] == 0){
                gap ++;
            }
            if (this.row3[indC] == 0){
                gap ++;
            }
            switch (gap){
                case 0:
                    break;
                case 1:
                    temp = this.row2[indC];
                    this.row3[indC] = temp;
                    this.row2[indC] = 0;
                    break;
                case 2:
                    temp = this.row2[indC];
                    this.row4[indC] = temp;
                    this.row2[indC] = 0;
                    break;
            }
        }
        for (int indC = 0 ; indC < 4 ; indC++){
            //row 4
            int gap = 0;
            if (this.row4[indC] == 0){
                gap ++;
            }
            if (this.row3[indC] == 0){
                gap ++;
            }
            if (this.row2[indC] == 0){
                gap++;
            }
            switch (gap){
                case 0:
                    break;
                case 1:
                    temp = this.row1[indC];
                    this.row2[indC] = temp;
                    this.row1[indC] = 0;
                    break;
                case 2:
                    temp = this.row1[indC];
                    this.row3[indC] = temp;
                    this.row1[indC] = 0;
                    break;
                case 3:
                    temp = this.row1[indC];
                    this.row4[indC] = temp;
                    this.row1[indC] = 0;
                    break;
            }
        }
    }
    public void compress_left(){
        for (int r = 0 ; r<3 ; r++){
            for (int i = 1; i<4; i++){
                if (this.row1[i-1] == 0){
                    this.row1[i-1] = this.row1[i];
                    this.row1[i] = 0;
                }
                if (this.row2[i-1] == 0){
                    this.row2[i-1] = this.row2[i];
                    this.row2[i] = 0;
                }
                if (this.row3[i-1] == 0){
                    this.row3[i-1] = this.row3[i];
                    this.row3[i] = 0;
                }
                if (this.row4[i-1] == 0){
                    this.row4[i-1] = this.row4[i];
                    this.row4[i] = 0;
                }
            }
        }
    }
    public void compress_right(){
        for (int r = 0 ; r<3 ; r++){
            for (int i = 2; i>=0; i--){
                if (this.row1[i+1] == 0){
                    this.row1[i+1] = this.row1[i];
                    this.row1[i] = 0;
                }
                if (this.row2[i+1] == 0){
                    this.row2[i+1] = this.row2[i];
                    this.row2[i] = 0;
                }
                if (this.row3[i+1] == 0){
                    this.row3[i+1] = this.row3[i];
                    this.row3[i] = 0;
                }
                if (this.row4[i+1] == 0){
                    this.row4[i+1] = this.row4[i];
                    this.row4[i] = 0;
                }
            }
        }
    }
    public void merge_up(){
        int temp;
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row1[indC] == this.row2[indC]){
                temp = this.row2[indC];
                this.row1[indC] = temp*2;
                this.row2[indC] = 0;
            }            
        }

        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row3[indC] == this.row2[indC]){
                temp = this.row3[indC];
                this.row2[indC] = temp*2;
                this.row3[indC] = 0;
            }    
        }
        
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row3[indC] == this.row4[indC]){
                temp = this.row4[indC];
                this.row3[indC] = temp*2;
                this.row4[indC] = 0;
            }    
        }
    }
    public void merge_down(){
        int temp;
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row4[indC] == this.row3[indC]){
                temp = this.row3[indC];
                this.row4[indC] = temp*2;
                this.row3[indC] = 0;
            }            
        }

        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row3[indC] == this.row2[indC]){
                temp = this.row2[indC];
                this.row3[indC] = temp*2;
                this.row2[indC] = 0;
            }            
        }
        
        for (int indC = 0 ; indC < 4 ; indC++){
            if (this.row1[indC] == this.row2[indC]){
                temp = this.row1[indC];
                this.row2[indC] = temp*2;
                this.row1[indC] = 0;
            }    
        }
        
    }
    public void merge_right(){
        if (this.row1[3] == this.row1[2]){
            this.row1[3] = this.row1[2]*2;
            this.row1[2] = 0;
        }
        if (this.row1[0] == this.row1[1]){
            this.row1[1] = this.row1[0]*2;
            this.row1[0] = 0;
        }
        if (this.row1[1] == this.row1[2]){
            this.row1[2] = this.row1[1]*2;
            this.row1[1] = 0;
        }
        if (this.row2[3] == this.row2[2]){
            this.row2[3] = this.row2[2]*2;
            this.row2[2] = 0;
        }
        if (this.row2[0] == this.row2[1]){
            this.row2[1] = this.row2[0]*2;
            this.row2[0] = 0;
        }
        if (this.row2[1] == this.row2[2]){
            this.row2[2] = this.row2[1]*2;
            this.row2[1] = 0;
        }
        if (this.row3[3] == this.row3[2]){
            this.row3[3] = this.row3[2]*2;
            this.row3[2] = 0;
        }
        if (this.row3[0] == this.row3[1]){
            this.row3[1] = this.row3[0]*2;
            this.row3[0] = 0;
        }
        if (this.row3[1] == this.row3[2]){
            this.row3[2] = this.row3[1]*2;
            this.row3[1] = 0;
        }
        if (this.row4[3] == this.row4[2]){
            this.row4[3] = this.row4[2]*2;
            this.row4[2] = 0;
        }
        if (this.row4[0] == this.row4[1]){
            this.row4[1] = this.row4[0]*2;
            this.row4[0] = 0;
        }
        if (this.row4[1] == this.row4[2]){
            this.row4[2] = this.row4[1]*2;
            this.row4[1] = 0;
        }
    }
    public void merge_left(){
        if (this.row1[1] == this.row1[0]){
            this.row1[0] = this.row1[1]*2;
            this.row1[1] = 0;
        }
        if (this.row1[1] == this.row1[2]){
            this.row1[1] = this.row1[2]*2;
            this.row1[2] = 0;
        }
        if (this.row1[2] == this.row1[3]){
            this.row1[2] = this.row1[3]*2;
            this.row1[3] = 0;
        }
        if (this.row2[1] == this.row2[0]){
            this.row2[0] = this.row2[1]*2;
            this.row2[1] = 0;
        }
        if (this.row2[1] == this.row2[2]){
            this.row2[1] = this.row2[2]*2;
            this.row2[2] = 0;
        }
        if (this.row2[2] == this.row2[3]){
            this.row2[2] = this.row2[3]*2;
            this.row2[3] = 0;
        }
        if (this.row3[1] == this.row3[0]){
            this.row3[0] = this.row3[1]*2;
            this.row3[1] = 0;
        }
        if (this.row3[1] == this.row3[2]){
            this.row3[1] = this.row3[2]*2;
            this.row3[2] = 0;
        }
        if (this.row3[2] == this.row3[3]){
            this.row3[2] = this.row3[3]*2;
            this.row3[3] = 0;
        }
        if (this.row4[1] == this.row4[0]){
            this.row4[0] = this.row4[1]*2;
            this.row4[1] = 0;
        }
        if (this.row4[1] == this.row4[2]){
            this.row4[1] = this.row4[2]*2;
            this.row4[2] = 0;
        }
        if (this.row4[2] == this.row4[3]){
            this.row4[2] = this.row4[3]*2;
            this.row4[3] = 0;
        }
    }
}