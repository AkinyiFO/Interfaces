package dev.labs.s3;

// Source: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
// Note: Overloaded methods should be used sparingly, as they can make code much less readable.

class DataArtist {

    // Calligraphy to draw various types of data.
    // Different methods draw different data types.
    // Instead of drawString, drawInteger, or drawFloat, to avoid cumbersomeness, use draw several times with different parameters.

    public void draw(String s) {
    }

    public void draw(int i) {
    }

    public void draw(double f) {
    }

    public void draw(int i, double f) {
    }
}

public class OverloadingMethods {}