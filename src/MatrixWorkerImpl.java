public class MatrixWorkerImpl implements IMatrixWorker {

    @Override
    public void print(double[][] m) {
        for (double[] doubles : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        return m1.length == m2.length && m1[0].length == m2[0].length;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) {
        if (haveSameDimension(m1, m2)) {
            double[][] m3 = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    m3[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return m3;
        } else throw new IllegalArgumentException("Matrices must be the same size.");
    }


    @Override
    public double[][] subtract(double[][] m1, double[][] m2) {
        if (haveSameDimension(m1, m2)) {
            double[][] m3 = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    m3[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return m3;
        } else throw new IllegalArgumentException("Matrices must be the same size.");
    }


    @Override
    public double[][] multiply(double[][] m1, double[][] m2) {
        if (m1[0].length == m2.length) {
            double[][] m3 = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m1[0].length; k++) {
                        m3[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return m3;
        } else
            throw new IllegalArgumentException("The number of columns of the first matrix is not equal to the number of rows of the second matrix.");
    }

    public double determinant(double[][] m) {
        double det = 0;
        if (m[0].length == m.length) {
            int size = m.length;
            if (size == 1) {
                return m[0][0];
            }
            for (int i = 0; i < size; i++) {
                double[][] minor = new double[size - 1][size - 1];
                for (int j = 0; j < size - 1; j++) {
                    for (int k = 0; k < size - 1; k++) {
                        if (k >= i)
                            minor[j][k] = m[j + 1][k + 1];
                        else
                            minor[j][k] = m[j + 1][k];
                    }
                }
                det += Math.pow(-1, i) * m[0][i] * determinant(minor);
            }
            return det;

        } else throw new IllegalArgumentException("Cannot calc determinant of non-square matrix.");
    }
}
