public class Matrix {
    private final double[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }


    @Override
    public int hashCode() {
        double sum = 0;
        for (double[] doubles : this.matrix) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                sum += doubles[j];
            }
        }
        int result = 25;
        result = 54 * result + (int) sum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix)) {
            return false;
        } else {
            Matrix obj1 = (Matrix) obj;
            if (obj1.getRows() == this.getRows() && obj1.getColumns() == this.getColumns()) {
                for (int i = 0; i < this.getRows(); i++) {
                    for (int j = 0; j < this.getColumns(); j++) {
                        if (obj1.getMatrix()[i][j] != this.getMatrix()[i][j])
                            return false;
                    }
                }
                return true;
            } else
                return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder matrixToString = new StringBuilder();
        for (double[] doubles : this.matrix) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                matrixToString.append(doubles[j]).append(" ");
            }
            matrixToString.append("\n");
        }
        return matrixToString.toString();
    }
}
