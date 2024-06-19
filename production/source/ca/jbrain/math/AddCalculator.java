package ca.jbrain.math;

public class AddCalculator {
    public static int add(String text) {
        if(text.isEmpty()) {
            return 0;
        } else if(text.length()==3) {
            String[] sum = text.split(",");
            return Integer.parseInt(sum[0]) + Integer.parseInt(sum[1]);
        }
        else {
            return Integer.parseInt(text);
        }
    }
}
