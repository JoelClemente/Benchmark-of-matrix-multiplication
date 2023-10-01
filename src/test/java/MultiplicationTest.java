import bigdata.matrix.Matrix;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicationTest {
    private static final int NUM_RUNS = 32;
    private static final int[] matrixSizes = {32, 64, 128, 256, 512};

    @Test
    public void testMatrixMultiplication() throws IOException {
        FileWriter csvWriter = new FileWriter("execution_times.csv");
        csvWriter.append("Matrix Size,Execution Time (seconds)\n");

        for (int size : matrixSizes) {
            double totalExecutionTime = 0.0;

            for (int run = 0; run < NUM_RUNS; run++) {
                double[][] a = Matrix.generateRandomMatrix(size);
                double[][] b = Matrix.generateRandomMatrix(size);

                long start = System.currentTimeMillis();
                double[][] result = new double[size][size];
                Matrix.multiplyMatrices(a, b, result);
                long stop = System.currentTimeMillis();

                double executionTimeInSeconds = (stop - start) / 1000.0;
                totalExecutionTime += executionTimeInSeconds;

                String csvLine = size + "," + executionTimeInSeconds + "\n";
                csvWriter.append(csvLine);
            }

            double averageExecutionTimeInSeconds = totalExecutionTime / NUM_RUNS;
            System.out.println("Matrix Size: " + size + " x " + size);
            System.out.println("Average Execution Time: " + averageExecutionTimeInSeconds + " seconds");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
