import java.util.Map;
import java.util.TreeMap;

public class TestPartOne {

    public static void main(String[] args) throws Exception {
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        Val truee = new Val(false);
        Map<String, Boolean> map = new TreeMap<>();
        map.put("y", true);
        map.put("x", true);
        map.put("z", false);
        Expression e1 = new And(new Xor(x, new Nand(y, z)), new Or(x,y));
        String string = e1.toString();
        System.out.println(string);
        Expression e2 = e1.assign("x", new Or(truee,z));
        String string2 = e2.toString();
        System.out.println(string2);
        try {
            System.out.println(e1.evaluate(map));
        } catch (Exception ex) {
            System.out.println("jdfkdf");
        }
    }
}
