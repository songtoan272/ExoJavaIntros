package Exercice2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class FileToHashMap {
    private HashMap<String, Integer> hackerRank = new HashMap<>();
    private File file;

    public FileToHashMap(String filename) {
        this.file = new File(filename);
        this.readIn();
    }

    private void readIn(){
        String line, mail, score;
        String[] splited = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                splited = line.split(":");
                hackerRank.put(splited[0], Integer.parseInt(splited[1]));
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public float calculateMean(){
        int sum = 0;
        ArrayList<Integer> scoreList = new ArrayList<>(hackerRank.values());

        for (Integer score:scoreList){
            sum += score;
        }
        return (float)sum / hackerRank.size();
    }

    public Optional<Integer> getScore(String mail){
        Optional<Integer> res = Optional.ofNullable(hackerRank.get(mail));
        return res;
    }

    public void printAllScores(){
        hackerRank.forEach((key, value) -> System.out.println("key = " + key + "|value = "+ value));
    }

}
