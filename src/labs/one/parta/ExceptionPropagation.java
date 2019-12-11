package labs.one.parta;

public class ExceptionPropagation {

    public static float moyenne(String[] tabInt){
        int sum = 0, count = 0, num;
        float mean;

        for (String strNum:tabInt) {
            num = Integer.parseInt(strNum);
            sum += num;
            count += 1;
        }

        mean = (float)sum / count;
        return mean;
    }

    public static float moyenne1(String[] tabInt){
        int sum = 0, count = 0, num;
        float mean = 0.0f;
        try{
            mean = moyenne(tabInt);
        }catch (NumberFormatException nfe){
            System.out.println("Incorrect value: " + nfe.getLocalizedMessage());
            //throw nfe;
        }
        return mean;
    }

    public static void main(String[] args) {
        String[] tabNum = {"123", "435", "1235", "4367", "12r", "34fgd"};
        float mean = 0.0f;

        try {
            mean =  moyenne(tabNum);
        }catch (NumberFormatException nfe){
            System.out.println("Method = "+ nfe.getStackTrace()[0].getMethodName());
        }
        System.out.println("Mean = " + mean);
    }
}
