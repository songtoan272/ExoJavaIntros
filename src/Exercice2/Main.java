package Exercice2;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args)
    {
        String mail;
        if (args.length == 0) mail = "casota272@gmail.com";
        else mail = args[0];
        int score;

        Instant start = Instant.now();

        FileToHashMap filetoHM = new FileToHashMap("hackerRank.txt");
        filetoHM.printAllScores();
        System.out.println("Average score = " + filetoHM.calculateMean());
        System.out.println("Score of " + mail + " is " + filetoHM.getScore(mail).toString());

        Duration duration = Duration.between(start, Instant.now());
        System.out.println("Execution time is " + duration);
    }
}
