package labs.one.parta;

public class Example {
    public static void main(String[] args) {
        if (args.length > 0){
            System.out.println("The command lines arguments are:");
            for (String arg:args){
                System.out.println(arg);
            }
        }else{
            System.out.println("There is no command line arguments.");
        }
    }
}
