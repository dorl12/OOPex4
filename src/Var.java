import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Var implements Expression {

    String variable;

    public Var (String variable) {
        this.variable = variable;
    }
    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result. If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return assignment.get(this.variable);
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        throw new Exception("exception: can't evaluate");
    }

    // Returns a list of the variables in the expression.
    public List<String> getVariables() {
        List<String> varsList = new ArrayList<>();
        varsList.add(this.variable);
        return varsList;
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return this.variable;
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.variable)){
            return expression;
        }
        return this;
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public Expression nandify() {
        return this;
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public Expression norify() {
        return this;
    }

    // Returned a simplified version of the current expression.
    public Expression simplify() {
        return this;
    }
}
