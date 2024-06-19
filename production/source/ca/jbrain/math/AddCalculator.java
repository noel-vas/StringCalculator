package ca.jbrain.math;

public class AddCalculator {
    public static String add(String text) {
        if(text.isEmpty()) {
            return "0";
        } else  {
            int total = 0;
            String[] sum = text.split(",");

            for(String str: sum)
            {
                str= str.trim();
                total += convertToInt(str);
            }
            return String.valueOf(total);
        }
    }

    private static int convertToInt(String text){
        return Integer.parseInt(text);
    }
}
