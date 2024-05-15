package com.github.treemanking.cmtpapiconditions.utilities;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public interface PlaceholderConversionUtilities {

    default boolean checkCondition(String condition, Player player) {
        // Remove whitespaces before splitting the condition
        String trimmedCondition = condition.replaceAll("\\s+", "");

        // Split the condition into placeholder and value parts
        String[] parts = trimmedCondition.split("<=|>=|<|>|==");

        if (parts.length == 2) {
            // Trim to remove any leading/trailing whitespaces
            String placeholder = parts[0].trim();
            String actualValue = PlaceholderAPI.setPlaceholders(player, placeholder);
            String restOfCondition = parts[1].trim();

            // Preserve the operator
            String operator = condition.substring(placeholder.length(), condition.length() - restOfCondition.length()).trim();

            return performComparison(actualValue, operator, restOfCondition);
        } else {
            // Log a warning or handle the case where the condition format is invalid
            Bukkit.getLogger().warning("Invalid condition format: " + condition);
            return false;
        }
    }

    default boolean performComparison(String actualValue, String operator, String expectedValue) {
        if (isNumeric(actualValue) && isNumeric(expectedValue)) {
            // Numeric comparison
            double actualNumeric = Double.parseDouble(actualValue);
            double expectedNumeric = Double.parseDouble(expectedValue);

            switch (operator) {
                case "==": return actualNumeric == expectedNumeric;
                case "<": return actualNumeric < expectedNumeric;
                case ">": return actualNumeric > expectedNumeric;
                case "<=": return actualNumeric <= expectedNumeric;
                case ">=": return actualNumeric >= expectedNumeric;
                default: return false; // Unsupported operator
            }
        } else if (isBoolean(actualValue) && isBoolean(expectedValue)) {
            // Boolean comparison
            boolean actualBoolean = Boolean.parseBoolean(actualValue);
            boolean expectedBoolean = Boolean.parseBoolean(expectedValue);

            return actualBoolean == expectedBoolean;
        } else {
            // String comparison
            return actualValue.equals(expectedValue);
        }
    }

    default boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    default boolean isBoolean(String str) {
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }
}
