package br.com.geofusion.cart.code1;

import java.util.ArrayList;

public class Code1 {
    /**
     * Relação de recorrência:
     *
     * <code>
     * F(1) = 1
     * F(2) = 1
     * F(n) = F(n-1) + F(n-2); para n > 2
     * </code>
     *
     * @param n número inteiro
     * @return valor da relação de recorrência
     */
    public int getValue(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.add(0);
        intArray.add(1);
        int i = 2;
        while (i <= n) {
            intArray.add(intArray.get(i - 1) + intArray.get(i - 2));
            i++;
        }
        return intArray.get(n);
    }

    public static void main(String[] args) {
        Code1 fib = new Code1();
        AssertUtil.assertEquals(1, fib.getValue(1));
        AssertUtil.assertEquals(1, fib.getValue(2));
        for (int i = 3; i < 5; i++) {
            AssertUtil.assertEquals(fib.getValue(i), fib.getValue(i - 1) + fib.getValue(i - 2));
        }
    }
}
