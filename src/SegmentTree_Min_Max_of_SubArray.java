public class SegmentTree_Min_Max_of_SubArray {
    int[] maxv;
    int[] minv;
    int n;
    SegmentTree_Min_Max_of_SubArray(int[] nums) {
        n = nums.length;
        maxv = new int[n * 4];
        minv = new int[n * 4];
        build(1, 0, n - 1, nums);
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            maxv[node] = minv[node] = nums[l];
            return;
        }
        int m = (l + r) / 2;
        build(node * 2, l, m, nums);
        build(node * 2 + 1, m + 1, r, nums);
        maxv[node] = Math.max(maxv[node * 2], maxv[node * 2 + 1]);
        minv[node] = Math.min(minv[node * 2], minv[node * 2 + 1]);
    }

    int queryMax(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return maxv[node];
        }
        int m = (l + r) / 2;
        int res = Integer.MIN_VALUE;
        if (ql <= m) {
            res = Math.max(res, queryMax(node * 2, l, m, ql, qr));
        }
        if (qr > m) {
            res = Math.max(res, queryMax(node * 2 + 1, m + 1, r, ql, qr));
        }
        return res;
    }

    int queryMin(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return minv[node];
        }
        int m = (l + r) / 2;
        int res = Integer.MAX_VALUE;
        if (ql <= m) {
            res = Math.min(res, queryMin(node * 2, l, m, ql, qr));
        }
        if (qr > m) {
            res = Math.min(res, queryMin(node * 2 + 1, m + 1, r, ql, qr));
        }
        return res;
    }
}

// Use (2*node + 1) (2*node + 2) when starting node is 1
// in this case starting node is 0 thats why we use 2*node) (2*node + 1)
