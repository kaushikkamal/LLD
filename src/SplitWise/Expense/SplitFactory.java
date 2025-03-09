package SplitWise.Expense;

import SplitWise.Expense.Split.EqualExpenseSplit;
import SplitWise.Expense.Split.ExpenseSplit;
import SplitWise.Expense.Split.PercentageExpenseSplit;
import SplitWise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnequalExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> null;
        };
    }
}
