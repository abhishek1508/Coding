public class LC_12_IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    private static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num = generate("M", num, 1000, builder);
            } else if (num >= 500) {
                if (num >= 900) {
                    num = generate("CM", num, 900, builder);
                } else {
                    num = generate("D", num, 500, builder);
                }
            } else if (num >= 100) {
                if (num >= 400) {
                    num = generate("CD", num, 400, builder);
                } else {
                    num = generate("C", num, 100, builder);
                }
            } else if (num >= 50) {
                if (num >= 90) {
                    num = generate("XC", num, 90, builder);
                } else {
                    num = generate("L", num, 50, builder);
                }
            } else if (num >= 10) {
                if (num >= 40) {
                    num = generate("XL", num, 40, builder);
                } else {
                    num = generate("X", num, 10, builder);
                }
            } else if (num >= 5) {
                if (num >= 9) {
                    num = generate("IX", num, 9, builder);
                } else {
                    num = generate("V", num, 5, builder);
                }
            } else {
                if (num >= 4) {
                    num = generate("IV", num, 4, builder);
                } else {
                    num = generate("I", num, 1, builder);
                }
            }
        }
        return builder.toString();
    }

    private static int generate(String roman, int num, int base, StringBuilder builder) {
        int quotient = num/base;
        for (int i = 0; i < quotient; i++) {
            builder.append(roman);
        }
        return num%base;
    }
}
