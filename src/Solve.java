class Solve {
    public static int[] findTwoElement(int arr[], int n) {
        int res[] = new int[2];
        int actualSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        res[0] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int seat = Math.abs(arr[i]) - 1;
            if (arr[seat] < 0) {
                res[0] = Math.min(res[0], Math.abs(arr[seat]));
            }
            arr[seat] *= -1;
        }
        res[1] = actualSum - (sum-res[0]);
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 4};
        Arrays.Basics.print1DArray(findTwoElement(arr, arr.length));
    }
}