package SplitWise.Expense;

import SplitWise.Expense.Split.Split;
import SplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private double expenseAmount;
    private User paidByUser;
    private ExpenseSplitType splitType;
    private List<Split> splitDetails;

    public Expense(String expenseId, double expenseAmount, String description,
                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {

        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;

        this.splitDetails = new ArrayList<>();
        this.splitDetails.addAll(splitDetails);

    }
}
