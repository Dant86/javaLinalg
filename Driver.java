public class Driver {

	public static void main(String[] args) {
		double[][] doubles = new double[5][5];
		Matrix newMat = new Matrix(doubles);
		System.out.println(newMat);
		double[][] newDoubs = new double[5][7];
		Matrix mat2 = new Matrix(newDoubs);
		System.out.print(newMat.multiply(mat2));
	}

}