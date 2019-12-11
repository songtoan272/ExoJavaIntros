package Exercice4;

public class StringCodage {
    private char[] alphabet;
    private String string;

    public StringCodage(String alphabet, String string) {
        this.alphabet = alphabet.toLowerCase().toCharArray();
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void isWellFormed(){
        for (char c1:string.toLowerCase().toCharArray()){
            boolean found = false;
            for (char c2:alphabet){
                if (c1 == c2){
                    found = true;
                    break;
                }
            }if (!found){
                System.out.println("The string "+ string + " is not well formed from the given alphabet.");
                return;
            }
        }
        System.out.println("The string "+ string + " is well formed.");
    }

    public static StringBuffer leftRotate(int steps, String str){
        int length = str.length();
        StringBuffer res = new StringBuffer(length);
        for (int i = 0; i < length; i++){
            res.append(str.charAt((i+steps) % length));
        }
        return res;
    }

    public static StringBuffer rightRotate(int steps, String str){
        int length = str.length();
        StringBuffer res = new StringBuffer(length);
        for (int i = 0; i < length; i++){
            res.append(str.charAt((i-steps+length)%length));
        }

        return res;
    }

    public void isAnagram(String str){
        if (str.isBlank()) {
            System.out.println("String to compare is not available.");
            return;
        }
        if (str.length() == string.length()) {
            char[] charOfStr = str.toCharArray();
            int[] track = new int[str.length()];
            for (char c1:charOfStr){
                boolean found = false;
                for (int i = 0; i < string.length(); i++){
                    if (c1 == string.charAt(i) && track[i] == 0){
                        track[i] = 1;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("The string " + str + " is not an anagram of " +
                            string + ".");
                    return;
                }
            }
            System.out.println("The string " + str + " is an anagram of " +
                    string + ".");
        }else
            System.out.println("The string " + str + " is not an anagram of " +
                string + ".");
    }

    public void removeSubStr(String strToRm){
        if (strToRm.isBlank()){
            System.out.println("String to remove is not available.");
            return;
        }
        int idxSubStr = string.indexOf(strToRm);
        String res = "";
        if (idxSubStr != -1){
            if (idxSubStr > 0)
                res = string.substring(0, idxSubStr);
            if (idxSubStr < string.length()-1)
                res = res.concat(string.substring(idxSubStr+1));
            System.out.println("The modified string now is "+res);
        }else{
            System.out.println("The given string does not contain the string "+ strToRm);
        }
    }

    private void swap(StringBuffer str, int idx1, int idx2){
        char temp = str.charAt(idx1);
        str.setCharAt(idx1, str.charAt(idx2));
        str.setCharAt(idx2, temp);
    }

    private void printallAnagrams(StringBuffer str, int start, int end){
        if (start == end)
            System.out.println(str);
        else{
            for (int i = start; i <= end; i++){
                swap(str, start, i);
                printallAnagrams(str, start+1, end);
                swap(str, start, i);
            }
        }
    }
    public void printAllAnagrams(){
        StringBuffer copyString = new StringBuffer(string);
        printallAnagrams(copyString, 0, string.length()-1);
    }

}
