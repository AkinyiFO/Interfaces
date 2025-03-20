package dev.labs.s3;

public class CharSeqReversedInConstructor implements CharSequence {
    private String s;

    public CharSeqReversedInConstructor(String s) {
        // Reverse the string in the constructor
        this.s = new StringBuilder(s).reverse().toString();
    }

    public char charAt(int i) {
        if ((i < 0) || (i >= s.length())) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return s.charAt(i);
    }

    public int length() {
        return s.length();
    }

    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > s.length() || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        return s.subSequence(start, end);
    }

    public String toString() {
        return s;
    }

    private static int random(int max) {
        return (int) Math.round(Math.random() * max);
    }

    public static void main(String[] args) {
        CharSeqReversedInConstructor s =
                new CharSeqReversedInConstructor("Write a class that implements the CharSequence interface found in the java.lang package.");

        // Exercise charAt() and length()
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();

        // Exercise subSequence() and length()
        int start = random(s.length() - 1);
        int end = random(s.length() - 1 - start) + start;
        System.out.println(s.subSequence(start, end));

        // Exercise toString()
        System.out.println(s);
    }
}
