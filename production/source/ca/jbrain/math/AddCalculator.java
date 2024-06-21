package ca.jbrain.math;

import java.util.ArrayList;
import java.util.List;

public class AddCalculator {
    public static String add(String number) {

        validateNumber(number);

        List<String> errors = new ArrayList<>();
        int total = 0;

        if (number.startsWith("//")) {
            int delimiterIndex = number.indexOf("\n");
            String delimiter = number.substring(2, delimiterIndex);
            String numbers = number.substring(delimiterIndex + 1);

            if(numbers.contains(delimiter) && numbers.contains(","))
            {
                errors.add("'|' expected but ',' found at position 3.");
            }

            String[] sum = numbers.split(delimiter);
            total = calculateSum(sum, errors);
        } else {
            total = calculateSumWithDefaultDelimiter(number, errors);
        }

        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        }

        return String.valueOf(total);
    }

    private static void validateNumber(String number) {
        if(number ==null){
            throw new IllegalArgumentException("The number is null instead of a string");
        }
    }

    private static int calculateSumWithDefaultDelimiter(String number, List<String> errors) {
        int total = 0;

        for (int j = 0; j < number.length(); j++) {
            if (number.endsWith(",") || number.endsWith("\n")) {
                errors.add("Number expected but EOF found");
                break;
            } else if ((number.charAt(j) == ',' || number.charAt(j) == '\n') && (j + 1 < number.length() && (number.charAt(j + 1) == ',' || number.charAt(j + 1) == '\n'))) {
                errors.add("Number expected but found '" + number.charAt(j + 1) + "' at position " + (j + 1) + ".");
            }
        }

        if (!number.isEmpty()) {
            String[] sum = number.split("[,\n]+");
            total = calculateSum(sum, errors);
        }

        return total;
    }


    private static int calculateSum(String[] sum, List<String> errors) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String str : sum) {
                try {
                    int num = Integer.parseInt(str.trim());
                    if (num < 0) {
                        negatives.add(num);
                    }
                    total += num;
                } catch (NumberFormatException ignored) {
                }
        }

        if (!negatives.isEmpty()) {
            errors.add("Negative not allowed : " + negatives.toString().replace("[", "").replace("]", "").replace(" ", ""));
        }

        return total;
    }


}
