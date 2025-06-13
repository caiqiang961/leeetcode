package org.lcr;

public class Solution139 {
    public int[] trainingPlan(int[] actions) {
        int index = -1;
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] % 2 != 0) {
                continue;
            }
            if (index == -1) {
                index = i + 1;
            }
            if (index >= actions.length) {
                return actions;
            }
            while (index < actions.length) {
                if (actions[index] % 2 != 0) {
                    int temp = actions[i];
                    actions[i] = actions[index];
                    actions[index] = temp;
                    index++;
                    break;
                }
                index++;
            }
        }
        return actions;
    }
}
