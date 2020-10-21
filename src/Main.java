public class Main {
    public static void main(String[] args) {

        IMatrixWorkerImpl m = new IMatrixWorkerImpl();

        double[][] A = {{1.1, 2},
                {3, 6}};

        double[][] B = {{1, 2, 5, 6},
                {3, 4, 6, -3},
                {3, -5, 8, 2},
                {5, 7, 3, 1}};

        double[][] C = {{1, 2, 5, 6, 3},
                {3, 4, 6, 3, 9},
                {3, 5, 8, 2, 1},
                {5, 7, 3, 1, -25},
                {0, 3, 4, 1, -5}};

        System.out.println(m.determinant(C));


    }
}
