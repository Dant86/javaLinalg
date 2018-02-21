public class Matrix {

	double[][] values;
	int rows;
	int cols;

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.values = new double[rows][cols];
	}

	public Matrix(double[][] values) {
		this.values = values;
		this.rows = values.length;
		this.cols = values[0].length;
	}

	public int rows() {
		return this.rows;
	}

	public int cols() {
		return this.cols;
	}

	public double[][] asArr() {
		return this.values;
	}

	public double[] getRow(int pos) {
		return this.values[pos];
	}

	public double[] getCol(int pos) {
		double[] res = new double[this.rows];
		for(int i = 0; i < this.rows; i++) {
			res[i] = this.values[i][pos];
		}
		return res;
	}

	public static double dot(double[] vec1, double[] vec2) {
		if(vec1.length != vec2.length) {
			String errMsg = "Lengths don't match";
			throw new IllegalArgumentException(errMsg);
		}
		double sum = 0;
		for(int i = 0; i < vec1.length; i++) {
			sum += vec1[i] * vec2[i];
		}
		return sum;
	}

	public Matrix multiply(Matrix other) {
		if(this.cols != other.rows()) {
			String errMsg = "Dimensions don't match";
			throw new IllegalArgumentException(errMsg);
		}
		double[][] res_ = new double[this.rows][other.cols()];
		for(int i = 0; i < res_.length; i++) {
			for(int j = 0; j < res_[0].length; j++) {
				res_[i][j] = dot(this.getRow(i), other.getCol(j));
			}
		}
		return new Matrix(res_);
	}

	public String toString() {
		String res = "[";
		for(int i = 0; i < this.rows; i++) {
			res += "[";
			for(int j = 0; j < this.cols; j++) {
				if(j < this.cols - 1) {
					res += this.values[i][j] + " ";
				}
				else {
					res += this.values[i][j];
				}
			}
			if(i < this.rows - 1) {
				res += "]\n";
			}
			else {
				res += "]";
			}
		}
		res += "]\n";
		return res;
	}

}