package ca.jbrain.math;

public class AddCalculator {
    public static String add(String text) {

        for(int j=0;j<text.length();j++){
            if((text.charAt(j)==',' || text.charAt(j)=='\n') &&  (text.charAt(j+1)==',' || text.charAt(j+1)=='\n')){
                return "Number expected but found '\\n' at position 4";
            }
        }

        if(text.isEmpty()) {
            return "0";
        } else  {
            int total = 0;
            String[] sum = text.split("[,\n]+");
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
