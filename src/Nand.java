import java.util.*;

/**
 * The main class for Nand.
 * This is a program that defines the Nand operator, evaluates an expression,
 * returns a list of the variables in the expression, returns a string
 * representation of the expression and returns a new expression in which all
 * occurrences of a variable are replaced with a provided expression.
 *
 * @author Dor Levy
 */
public class Nand extends BinaryExpression implements Expression {

    /**
     * This method is a constructor of the Nand class.
     * The method Defines the class members.
     *
     * @param leftExp This is the expression on the left side of the Nand operator
     * @param rightExp This is the expression on the right side of the Nand operator
     */
    public Nand (Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
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
        Boolean leftExpValue = super.getLeftExp().evaluate(assignment);
        Boolean rightExpValue = super.getRightExp().evaluate(assignment);
        return !(leftExpValue && rightExpValue);
    }

    /**
     * The evaluate method Evaluates the expression and returns the result.
     * If the expression contains a variable, an exception is thrown.
     *
     * @return Boolean This returns the value of the evaluation of the expression
     */
    public Boolean evaluate() throws Exception {
        Boolean leftValue = super.getLeftExp().evaluate();
        Boolean rightValue = super.getRightExp().evaluate();
        return !(leftValue && rightValue);
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
        return super.toString().replace("$", "A");
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
        Expression leftExp = super.getLeftExp().assign(var, expression);
        Expression rightExp = super.getRightExp().assign(var, expression);
        return new Nand(leftExp, rightExp);
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public Expression nandify() {
        return this;
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public Expression norify() {
        return new Nor(new Nor(new Nor(super.getLeftExp(), super.getLeftExp()), new Nor(super.getRightExp(), super.getRightExp()))
        , new Nor(new Nor(super.getLeftExp(), super.getLeftExp()), new Nor(super.getRightExp(), super.getRightExp())));
    }

    // Returned a simplified version of the current expression.
    public Expression simplify() {
        Expression leftExpression = super.getLeftExp().simplify();
        Expression rightExpression = super.getRightExp().simplify();
        try {
            return new Val(this.evaluate());
        } catch (Exception e) {
            if (leftExpression.toString().equals("T")) {
                return new Not(rightExpression);
            }
            if (rightExpression.toString().equals("T")) {
                return new Not(leftExpression);
            }
            if (leftExpression.toString().equals("F") || rightExpression.toString().equals("F")) {
                return new Val(true);
            }
            if (leftExpression.toString().equals(rightExpression.toString())) {
                return new Not(leftExpression);
            }
        }
        return new Nand(leftExpression, rightExpression);
    }
}

