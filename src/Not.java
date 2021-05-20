import java.util.*;

/**
 * The main class for Not.
 * This is a program that defines the Not operator, evaluates an expression,
 * returns a list of the variables in the expression, returns a string
 * representation of the expression and returns a new expression in which all
 * occurrences of a variable are replaced with a provided expression.
 *
 * @author Dor Levy
 */
public class Not extends UnaryExpression implements Expression {

    /**
     * This method is a constructor of the Not class.
     * The method Defines the class members.
     *
     * @param expression This is an expression
     */
    public Not (Expression expression) {
        super(expression);
    }

    /**
     * The evaluate method gets an assignment and Evaluates the expression using
     * the variable values provided in the assignment, and returns the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment This is the assignment that includes variables and their values
     * @return Boolean This returns the value of the evaluation of the expression
     */
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        super.evaluate(assignment);
        Boolean expValue = super.getExpression().evaluate(assignment);
        return !expValue;
    }

    /**
     * The evaluate method Evaluates the expression and returns the result.
     * If the expression contains a variable, an exception is thrown.
     *
     * @return Boolean This returns the value of the evaluation of the expression
     */
    public Boolean evaluate() throws Exception {
        Boolean expValue = super.getExpression().evaluate();
        return !expValue;
    }

    /**
     * The getVariables method returns a list of the variables in the expression.
     *
     * @return List<String> This returns a list of the variables in the expression.
     */
    public List<String> getVariables() {
        return super.getVariables();
    }

    /**
     * The toString method returns a string representation of the expression.
     *
     * @return String This returns a string representation of the expression.
     */
    public String toString() {
        return super.toString();
    }

    /**
     * The assign method gets a variable and an expression and Returns
     * a new expression in which all occurrences of the variable are
     * replaced with the provided expression.
     *
     * @param var This is a variable
     * @param expression This is an expression
     * @return Expression This returns a new expression
     */
    public Expression assign(String var, Expression expression) {
        Expression assignedExpression = super.getExpression().assign(var, expression);
        return new Not(assignedExpression);
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public Expression nandify() {
        return new Nand(super.getExpression(), super.getExpression());
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public Expression norify() {
        return new Nor(super.getExpression(), super.getExpression());
    }

    // Returned a simplified version of the current expression.
    public Expression simplify() {
        Expression exp = super.getExpression().simplify();
        try {
            return new Val(this.evaluate());
        } catch (Exception e) {
            return new Not(exp);
        }
    }
}
