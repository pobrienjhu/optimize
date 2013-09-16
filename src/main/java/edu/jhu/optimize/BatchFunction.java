package edu.jhu.optimize;

public interface BatchFunction extends Function {

    /**
     * Sets the current point for this function.
     * @param point The point.
     */
    void setPoint(double[] point);

    /**
     * Gets value of this function at the current point, computed on the given batch of examples.
     * @param batch A set of indices indicating the examples over which the gradient should be computed.
     * @return The value of the function at the point.
     */
    double getValue(int[] batch);

    /**
     * Gets the number of examples.
     */
    int getNumExamples();

}