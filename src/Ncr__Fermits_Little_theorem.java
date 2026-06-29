public class Ncr__Fermits_Little_theorem {
    int mod = 1000000007;

    public long flt(long base, long exp) {
        long ans = 1;
        base %= mod;

        while(exp > 0) {
            if((exp % 2) == 1) {
                ans = (ans*base) % mod;
            }
            base  = (base*base) % mod;
            exp /= 2;
        }

        return ans;
    }

    private long ncr(int n, int r, long fact[], long inv[]) {
        if(r < 0 || r > n) return 0;

        long numera = fact[n];
        long denom = (inv[r] * inv[n-r]) % mod;

        return (numera * denom) % mod;
    }
}
