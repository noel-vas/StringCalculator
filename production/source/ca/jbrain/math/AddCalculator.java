package ca.jbrain.math;

public class AddCalculator {
    public static int add(String text) {
        if(text.isEmpty()) {
            return 0;
        }
        else {
            return Integer.parseInt(text);
        }
    }
}
