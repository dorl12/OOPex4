import java.util.*;

public abstract class BinaryExpression implements Expression{

    private Expression leftExp;
    private Expression rightExp;

    public BinaryExpression (Expression leftExp, Expression rightExp) {
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    public Expression getLeftExp() {
        return this.leftExp;
    }

    public Expression getRightExp() {
        return this.rightExp;
    }

    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result. If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        List<String> expVars = this.getVariables();
        Set<String> assignmentVars = assignment.keySet();
        if (!assignmentVars.containsAll(expVars)){
            throw new Exception("exception: can't evaluate");
        }
        return true;
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public abstract Boolean evaluate() throws Exception;

    // Returns a list of the variables in the expression.
    public List<String> getVariables() {
        List<String> leftExVar = this.leftExp.getVariables();
        List<String> rightExVar = this.rightExp.getVariables();
        List<String> expVars = new LinkedList<>();
        expVars.addAll(leftExVar);
        expVars.addAll(rightExVar);
        Set<String> expVarsSet = new HashSet<>(expVars);
        return new ArrayList<>(expVarsSet);
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return "(" + this.leftExp.toString() + " $ " + this.rightExp.toString() + ")";
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public abstract Expression assign(String var, Expression expression);

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public abstract Expression nandify();

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public abstract Expression norify();
}
