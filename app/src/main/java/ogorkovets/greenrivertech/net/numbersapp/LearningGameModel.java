package ogorkovets.greenrivertech.net.numbersapp;

import java.util.Random;

/**
 * @author  Oleksandr Gorkovets
 * @version 1.0
 * @date 4/11/2016
 */
public class LearningGameModel {
    private int leftNumber;
    private int rightNumber;
    private int gamesPlayed;
    private int gamesWon;

    /**
     * This is default constructor
     */
    public LearningGameModel(){
        generateNumbers();
        gamesPlayed = 0;
        gamesWon = 0;
    }

    /**
     * This method is used to generate new random numbers
     * and assign them to left and right
     */
    public void generateNumbers() {
        leftNumber = randNum(10);
        rightNumber = randNum(10);
        if(leftNumber == rightNumber){
            generateNumbers();
        }
    }

    /**
     * this is getter for number of games played
     * @return games played
     */
    public int getGamesPlayed(){
        return gamesPlayed;
    }

    /**
     * this is getter method to return number of right answers
     * @return games won
     */
    public int getGamesWon(){
        return gamesWon;
    }

    /**
     * this is getter method to return left number
     * @return left number
     */
    public int getLeftNumber() {

        return leftNumber;
    }

    /**
     * this is getter method to return right number
     * @return right number
     */
    public int getRightNumber() {

        return rightNumber;
    }

    /**
     * this method is used to compare left and right numbers
     * @param num1
     * @param num2
     * @return if the chosen number is greater true and if is smaller false
     */

    public boolean play(int num1, int num2){
        gamesPlayed++;
        if(num1 > num2){
            gamesWon++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method generates new random number with the upper bound
     * @param max the upper bound
     * @return new randm number
     */
    public int randNum(int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
}
