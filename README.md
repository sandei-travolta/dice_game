# Dice Game Simulation

This repository contains a Java 11 program that simulates a simple dice game for three players. The game is entirely text-based and operates at the NetBeans console. The objective of the game is to be the player with the highest cumulative score after eleven rounds of play.

## Game Description

The game involves three players who take turns rolling two dice. Each player must choose a column to insert the total displayed by the two dice. The game progresses over eleven rounds, and the aim is to win the most valuable categories by allocating higher dice throw totals than other players.

### Score Table

The score table consists of 11 columns with values ranging from 2 to 12. Each player must choose a different column in each round, and they cannot override a previously selected column. The game ends after 11 rounds when all three players have completed their row in the score table.

### Scoring

When a column is complete (i.e., all three players have selected that column), the player with the highest total in that column scores the respective value of that column. If there is a tie, the column does not score.

### End of Game

The winner is the player with the highest cumulative score at the end of the game. The program concludes by announcing the winner or indicating which players tied in the event of a tie.

## Requirements

- Java 11
- NetBeans IDE

## How to Run

1. Clone the repository to your local machine.
2. Open the project in NetBeans IDE.
3. Run the `Main.java` file to start the game.

## Example

|       | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | Scores |
|-------|---|---|---|---|---|---|---|---|----|----|----|--------|
| Player 1 |   |   |   |   |   |   | 10 |   |    |    |    |        |
| Player 2 |   |   |   |   |   |   |    |   |    |    |    |        |
| Player 3 |   |   |   |   |   |   |    |   |    |    |    |        |


Here is an example of how the score table might look after a few rounds:
## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.
