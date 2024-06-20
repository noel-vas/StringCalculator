package ca.jbrain.math;

import java.util.ArrayList;
import java.util.List;

public class AddCalculator {
    public static String add(String number) {

        List<String> errors = new ArrayList<>();
        int total = 0;

        if (number.startsWith("//")) {
            // Extract delimiter and numbers part
            int delimiterIndex = number.indexOf("\n");
            String delimiter = number.substring(2, delimiterIndex);
            String numbers = number.substring(delimiterIndex + 1);
            String escapedDelimiter = escapeDelimiter(delimiter);

            if (numbers.contains(delimiter) && numbers.contains(",")) {
                int pos = numbers.indexOf(",");
                errors.add("'" + delimiter + "' expected but ',' found at position " + pos + ".");
                return String.join("\n", errors);
            }

            // Split numbers using the custom delimiter
            String[] sum = numbers.split(escapedDelimiter);
            total = calculateSum(sum, errors);
        } else {
            total = calculateSumWithDefaultDelimiter(number, errors);
        }

        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        }

        return String.valueOf(total);
    }

    private static String escapeDelimiter(String delimiter) {
        // Escape characters that have special meanings in regular expressions
        return delimiter.replace("[", "\\[").replace("]", "\\]").replace("|", "\\|");
    }

    private static int calculateSum(String[] sum, List<String> errors) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String str : sum) {
            if (!str.trim().isEmpty()) {
                try {
                    int num = Integer.parseInt(str.trim());
                    if (num < 0) {
                        negatives.add(num);
                    }
                    total += num;
                } catch (NumberFormatException ignored) {

                }
            }
        }

        // Check for negative numbers
        if (!negatives.isEmpty()) {
            errors.add("Negative not allowed : " + negatives.toString().replace("[", "").replace("]", "").replace(" ", ""));
        }

        return total;
    }

    private static int calculateSumWithDefaultDelimiter(String number, List<String> errors) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

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
}
