package br.com.geofusion.cart.code2;

public final class AssertUtil {

  private AssertUtil() {}

  public static void assertEquals(String str1, String str2) {
    if (!str1.equals(str2)) {
      throw new AssertionError(String.format("Os valores %s e %s são diferentes", str1, str2));
    }
  }

  public static void assertEquals(int i, int j) {
    if (i != j) {
      throw new AssertionError(String.format("Os valores %d e %d são diferentes", i, j));
    }
  }

}
