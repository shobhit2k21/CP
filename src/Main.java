//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int n = 10^5; // ^ power h xor nhi
        int mod = 1000000007;

        Ncr__Fermits_Little_theorem obj = new Ncr__Fermits_Little_theorem();

        long fact[] = new long[n+1];
        long inv[] = new long[n+1];
        fact[0] = 1;
        inv[0] = 1;

        for(int i=1; i<=n; i++) {
            fact[i] = (fact[i-1]*i) % mod;
        }

        inv[n] = obj.flt(fact[n], mod-2);
        for(int i=n-1; i>=1; i--) {
            inv[i] = (inv[i+1] * (i+1)) % mod;
        }

        System.out.println(fact[n] + " " + inv[n]);


    }
}