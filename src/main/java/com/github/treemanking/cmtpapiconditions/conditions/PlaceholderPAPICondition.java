package com.github.treemanking.cmtpapiconditions.conditions;

import com.github.treemanking.cmtpapiconditions.utilities.PlaceholderConversionUtilities;
import me.playbosswar.com.api.ConditionRule;
import me.playbosswar.com.api.NeededValue;
import org.bukkit.entity.Player;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlaceholderPAPICondition implements ConditionRule, PlaceholderConversionUtilities {

    @Override
    public String getName() {
        return "PLACEHOLDER_API";
    }

    @Override
    public String getDescription() {
        return "Checks statements against the placeholder conditions";
    }

    @Override
    public boolean evaluate(Facts facts) {
        Player player = facts.get("player");
        String placeholderCondition = facts.get("placeholderCondition");

        if (player == null || placeholderCondition == null) return false;

        return checkCondition(placeholderCondition, player);
    }

    @Override
    public ArrayList<NeededValue<?>> getNeededValues() {
        ArrayList<NeededValue<?>> neededValues = new ArrayList<>();

        neededValues.add(new NeededValue<>("placeholderCondition",
                "Placeholder Condition",
                String.class,
                ""));
        return neededValues;
    }

    @Override
    public void execute(Facts facts) throws Exception {

    }

    @Override
    public int compareTo(@NotNull Rule o) {
        return 0;
    }

}
