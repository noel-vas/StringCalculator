package ca.jbrain.math;

public class AddCalculator {
    public static int add(String text) {
        if(text.isEmpty()) {
            return 0;
        } else if(text.contains(",")) {
            int total = 0;
            String[] sum = text.split(",");

            for(String str: sum)
            {
                str= str.trim();
                total += convertToInt(str);
            }
            return total;
        }
        else {
            return convertToInt(text);
        }
    }

    private static int convertToInt(String text){
        return Integer.parseInt(text);
    }
}
