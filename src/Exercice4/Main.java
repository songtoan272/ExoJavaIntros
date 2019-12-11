package Exercice4;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2){
            System.out.println("Missing arguments.");
            System.exit(0);
        }else{
            StringCodage stringCodage = new StringCodage(args[0], args[1]);
            int rotateSteps = 4;
            //verify if the string is well formed from the given alphabet
            stringCodage.isWellFormed();

            //rotate the string
            System.out.println("The string rotated to the left by " + rotateSteps +
                    " steps is "+ StringCodage.leftRotate(rotateSteps,stringCodage.getString()));
            System.out.println("The string rotated to the right by " + rotateSteps +
                    " steps is "+ StringCodage.rightRotate(rotateSteps,stringCodage.getString()));

            if (args.length > 2){
                int nbArg = 2;
                while (nbArg < args.length) {
                    switch (args[nbArg]) {
                        case "/a":
                            String strAnagram;
                            if (args.length > nbArg+1) {
                                strAnagram = args[nbArg+1];
                            }else strAnagram = "";
                            stringCodage.isAnagram(strAnagram);
                            nbArg+=2;
                            break;

                        case "/o":
                            String strToRm;
                            if (args.length > nbArg+1) strToRm = args[nbArg+1];
                            else strToRm = "";
                            stringCodage.removeSubStr(strToRm);
                            nbArg+=2;
                            break;

                        case "/an":
                            stringCodage.printAllAnagrams();
                            nbArg++;
                            break;

                        default:
                            System.out.println("Unknown option.");
                            nbArg++;
                            break;
                    }
                }
            }

        }
    }
}
