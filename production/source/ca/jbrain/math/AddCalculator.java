package ca.jbrain.math;

import java.util.ArrayList;
import java.util.List;

public class AddCalculator {
    public static String add(String number) {

        if (number.startsWith("//")) {
            // Extract delimiter and numbers part
            int delimiterIndex = number.indexOf("\n");
            String delimiter = number.substring(2, delimiterIndex);
            String numbers = number.substring(delimiterIndex + 1);

            // Escape delimiter for split method
            String escapedDelimiter = escapeDelimiter(delimiter);

            if (numbers.contains("|") && numbers.contains(",")) {
                int pos = numbers.indexOf(",");
                return "'|' expected but ',' found at position " + (pos) + ".";
            }

            // Split numbers using the custom delimiter
            String[] sum = numbers.split(escapedDelimiter);

            // Calculate the total sum
            int total = 0;
            List<Integer> negatives = new ArrayList<>();
            for (String str : sum) {
                if (!str.trim().isEmpty()){
                    int num = Integer.parseInt(str.trim());
                    if (num < 0) {
                        negatives.add(num);
                    }
                    total += num;
                }
            }

            if (!negatives.isEmpty()) {
                StringBuilder sb = new StringBuilder("Negative not allowed : ");
                for (int i = 0; i < negatives.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(negatives.get(i));
                }
                return sb.toString();
            }


            return String.valueOf(total);
        } else {
            // Default delimiter handling (',' and '\n')
            return calculateSumWithDefaultDelimiter(number);
        }
    }

    private static String escapeDelimiter(String delimiter) {
        // Escape characters that have special meanings in regular expressions
        return delimiter.replace("[", "\\[").replace("]", "\\]").replace("|", "\\|");
    }

    private static String calculateSumWithDefaultDelimiter(String number) {
        for (int j = 0; j < number.length(); j++) {
            if (number.endsWith(",") || number.endsWith("\n")) {
                return "Number expected but EOF found";
            } else if ((number.charAt(j) == ',' || number.charAt(j) == '\n') && (number.charAt(j + 1) == ',' || number.charAt(j + 1) == '\n')) {
                return "Number expected but found '\\n' at position 4";
            }
        }

        if (number.isEmpty()) {
            return "0";
        } else {
            int total = 0;
            List<Integer> negatives = new ArrayList<>();
            String[] sum = number.split("[,\n]+");
            for (String str : sum) {
                if (!str.trim().isEmpty()) {
                    int num = Integer.parseInt(str.trim());
                    if (num < 0) {
                        negatives.add(num);
                    }
                    total += num;
                }
            }

            if (!negatives.isEmpty()) {
                StringBuilder sb = new StringBuilder("Negative not allowed : ");
                for (int i = 0; i < negatives.size(); i++) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(negatives.get(i));
                }
                return sb.toString();
            }
            return String.valueOf(total);
        }
    }
}
