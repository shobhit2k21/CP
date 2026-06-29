import java.util.Arrays;

class Binary_Lifting {
    int ancestor[][];
    int col;

    public Binary_Lifting(int n, int[] parent) {
        this.col = 32 - Integer.numberOfLeadingZeros(n);
        this.ancestor = new int[n][col];

        for (int a[] : ancestor)
            Arrays.fill(a, -1);

        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }

        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j - 1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j - 1]][j - 1];
                }
            }
        }

    }

    public int getKthAncestor(int node, int k) {    // Kth ancestor using Binary Lifting
        for (int j = 0; j < col; j++) {
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];
            }

            if (node == -1)
                return -1;
        }

        return node;
    }
}
