package entities;

public class ScoreEntity {
    ///Keep Track of score
    private int[][] score;
    public ScoreEntity(){
        score=new int[3][12];
    }

    public int[][] getScore() {
        return score;
    }

    public void setScore(int[][] score) {
        this.score = score;
    }
    public void updateScore(int i, int position,int sum) {
        if (i >= 0 && i < score.length && position >= 0 && position < score[i].length) {
            score[i][position] = sum; // Set the sum of the dice rolls
        } else {
            System.out.println("Invalid indices provided. Please provide valid indices.");
        }
    }
}
