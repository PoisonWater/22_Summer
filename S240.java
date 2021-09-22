public class S240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] index = new int[]{0, cols-1};

        while (target != matrix[index[0]][index[1]]) {
            if (index[0] > rows - 1 || index[1] > cols - 1) return false;
            if (target > matrix[index[0]][index[1]])
                index[0] += 1;
            if (target < matrix[index[0]][index[1]])
                index[1] += 1;
        }
        return true;

    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{-5}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}