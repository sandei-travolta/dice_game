package Services;

import entities.ScoreEntity;
import interfaces.GameEngineInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class GameEngine implements GameEngineInterface {
    boolean gameIson=true;
    int numberOfTurns=0;
    final Scanner input;
    final ScoreEntity scoreEntity;
    List<Integer> wonColumns=new ArrayList<>();
    public GameEngine(){
        input=new Scanner(System.in);
        scoreEntity=new ScoreEntity();
    }
    @Override
    public void startGameEngine() {
       System.out.println("Game Engine Starts");
       //Ensure game is on
       while (gameIson){
           /// Keep Track of current player
           for(int i=1;i<=3;i++){
               System.out.println("Player "+i+" is playing\n");
               int dice1=rollDice();
               int dice2=rollDice();
               System.out.println("Dice1: "+dice1+"\n" +
                       "Dice2: "+dice2+"\n" +
                       "Sum: "+(dice1+dice2));
               System.out.println("Player "+i+"\n" +
                       "Selecte where to add number");
               int position=input.nextInt();
               System.out.println("value: "+scoreEntity.getScore()[i-1][position-1]);
               while (!(scoreEntity.getScore()[i-1][position-1] ==0)){
                   System.out.println("Position Filled Try Again");
                   position=input.nextInt();
               }
               scoreEntity.updateScore((i-1),(position-1),(dice1+dice2));
           }
           for (int i=0;i<11;i++){
               if (isColumnComplete(i)&&wonColumns.contains(i)==false){
                   getColumnWinner(i);
               }
           }
           showTable();
           numberOfTurns++;
           if(numberOfTurns==11){
               endGameEngine();
           }
       }

    }

    @Override
    public int rollDice() {
        Random random =new Random();
        return random.nextInt(6)+1;
    }

    @Override
    public void showTable() {
        System.out.println("Score Table:");
        System.out.println("------------");

        // Print the header
        System.out.format("%-10s", "player");
        for (int j = 0; j <11; j++) {
            System.out.format("%-5d", j+2);
        }
        System.out.print("Score");
        System.out.println();

        // Print the divider
        System.out.println("-------------------------------------------");

        // Print the scores
        for (int i = 0; i < scoreEntity.getScore().length; i++) {
            System.out.format("Player %d:  ", i+1); // Print row label
            int rowSum = 0;
            for (int j = 0; j < scoreEntity.getScore()[i].length; j++) {
                System.out.format("%-5d", scoreEntity.getScore()[i][j]);
            }
            System.out.println(); // New line after each row
        }
    }

    @Override
    public void endGameEngine() {
        gameIson=false;
        getWinner();
        System.out.println("Game Ends");
    }

    @Override
    public boolean isColumnComplete(int column) {
        return scoreEntity.getScore()[0][column] != 0 &&
                scoreEntity.getScore()[1][column] != 0 &&
                scoreEntity.getScore()[2][column] != 0;
    }

    @Override
    public void getColumnWinner(int column) {
        int index=-1;
        int count=0;
        int maxScore=Math.max(scoreEntity.getScore()[0][column],Math.max(scoreEntity.getScore()[1][column],scoreEntity.getScore()[2][column]));
        for(int i=0;i<3;i++){
            if (maxScore==scoreEntity.getScore()[i][column]){
                count++;
            }
        }
        if(count>1){
            System.out.println("Column "+column+"Ends as Draw");
        }else{
            for(int i=0;i<3;i++){
                if(maxScore==scoreEntity.getScore()[i][column]){
                    index=i;
                }
            }
            wonColumns.add(column);
            int sum=scoreEntity.getScore()[index][11]+(column+2);
            scoreEntity.updateScore(index,11,sum);
            System.out.println("Winner for column "+(column+1)+" is "+index);
        }

    }

    @Override
    public void getWinner() {
        int index=-1;
        if(scoreEntity.getScore()[0][11]==scoreEntity.getScore()[1][11]||scoreEntity.getScore()[0][11]==scoreEntity.getScore()[2][11]||scoreEntity.getScore()[1][11]==scoreEntity.getScore()[2][11]){
            System.out.println("Game Ends As Draw");
            showTable();
        }
        else {
            int maxScore=Math.max(scoreEntity.getScore()[0][11],Math.max(scoreEntity.getScore()[1][11],scoreEntity.getScore()[2][11]));
            for(int i=0;i<3;i++){
                if(maxScore==scoreEntity.getScore()[i][11]){
                    index=i;
                }
            }
            showTable();
            System.out.println("Winner for The Game is Player "+(index+1));
        }

    }

}
