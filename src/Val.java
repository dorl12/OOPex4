import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Val implements Expression {

    boolean value;

    public Val (boolean value) {
        this.value = value;
    }
    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result. If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    // Returns a list of the variables in the expression.
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        if (this.value) {
            return "T";
        }
        return "F";
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
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
