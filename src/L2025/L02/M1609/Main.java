package L2025.L02.M1609;

/**
 * @author 王强
 * @since 2025/2/11
 */
public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        System.out.println("operations.minus(1, 2) = " + operations.minus(1, 2));
        System.out.println("operations.multiply(3, 4) = " + operations.multiply(3, 4));
        System.out.println("operations.divide(5, -2) = " + operations.divide(5, -2));
    }

}

class Operations {

    public Operations() {

    }

    public int minus(int a, int b) {
        return a + (-b);
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        boolean isNegative = (a < 0 && b > 0) || (a > 0 && b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 1) {
            return isNegative ? -a : a;
        }
        if (b == 1) {
            return isNegative ? -b : b;
        }
        int res = 0;
        for (int i = 0; i < b; i++) {
            res += a;
        }
        return isNegative ? -res : res;
    }

    public int divide(int a, int b) {
        boolean isNegative = (a < 0 && b > 0) || (a > 0 && b < 0);
        if (a == 0) {
            return 0;
        }
        int res = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 1) {
            return isNegative ? -a : a;
        }
        while (a >= b) {
            a -= b;
            res++;
        }
        return isNegative ? -res : res;
    }
}

/**
 * Your Operations object will be instantiated and called as such:
 * Operations obj = new Operations();
 * int param_1 = obj.minus(a,b);
 * int param_2 = obj.multiply(a,b);
 * int param_3 = obj.divide(a,b);
 */