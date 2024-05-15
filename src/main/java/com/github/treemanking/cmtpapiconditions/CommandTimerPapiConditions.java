package com.github.treemanking.cmtpapiconditions;

import com.github.treemanking.cmtpapiconditions.conditions.PlaceholderPAPICondition;
import me.playbosswar.com.CommandTimerPlugin;
import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import me.playbosswar.com.api.events.EventExtension;
import me.playbosswar.com.hooks.HookType;

import java.util.ArrayList;

public class CommandTimerPapiConditions extends ConditionExtension {

    ConditionRules conditionRules = new ConditionRules();
    CommandTimerPlugin commandTimerPlugin = getCommandTimerPlugin();

    public CommandTimerPapiConditions() {
        // Check if PAPI is on the server
        if (!getCommandTimerPlugin().getHooksManager().isHookEnabled(HookType.PAPI)) {
            getCommandTimerPlugin().getLogger().warning("PlaceholderAPI wasn't detected, the PlaceHolderAPI extension for CMT will do nothing");
            return;
        }

        // If so, add register rules
        conditionRules.register(new PlaceholderPAPICondition());
    }

    @Override
    public @org.jetbrains.annotations.NotNull String getConditionGroupName() {
        return "PLACEHOLDERS";
    }

    @Override
    public @org.jetbrains.annotations.NotNull String[] getDescription() {
        return new String[] {"Use Placeholder API to create certain conditions for your tasks."};
    }

    @Override
    public @org.jetbrains.annotations.NotNull String getAuthor() {
        return "TreemanKing";
    }

    @Override
    public @org.jetbrains.annotations.NotNull String getVersion() {
        return "1.0.0";
    }

    public @org.jetbrains.annotations.NotNull ConditionRules getRules() {
        return conditionRules;
    }

    @Override
    public ArrayList<EventExtension> getEvents() {
        return new ArrayList<>();
    }
}