import java.util.*;

public abstract class UnaryExpression implements Expression{

    private Expression expression;

    public UnaryExpression (Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return this.expression;
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
        return new ArrayList<>(this.expression.getVariables());
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return "~" + "(" + this.expression.toString() + ")";
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
