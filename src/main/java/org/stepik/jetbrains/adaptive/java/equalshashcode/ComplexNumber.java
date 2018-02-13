package org.stepik.jetbrains.adaptive.java.equalshashcode;


public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass().isInstance(obj)) {
            ComplexNumber that = this.getClass().cast(obj);
            return Double.compare(re, that.re) == 0 && Double.compare(im, that.im) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
}

