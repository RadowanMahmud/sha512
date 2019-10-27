package hash;

public class algorithmicOperations {
    public algorithmicOperations(){

    }
   /* public long Ch(long x, long y, long z) {
        return (x & y) ^ (~x & z);
    }

    public long Maj(long x, long y, long z) {
        return (x & y) ^ (x & z) ^ (y & z);
    }

    public long rotate(long x, int l) {
        return (x >>> l) | (x << (Long.SIZE - l));
    }

    public long compressionSigma0(long x) {
        return rotate(x, 28) ^ rotate(x, 34) ^ rotate(x, 39);
    }

    public long compressionSigma1(long x) {
        return rotate(x, 14) ^ rotate(x, 18) ^ rotate(x, 41);
    }

    public long messageSigma0(long x) {
        return rotate(x, 1) ^ rotate(x, 8) ^ (x >>> 7);
    }

    public long messageSigma1(long x) {
        return rotate(x, 19) ^ rotate(x, 61) ^ (x >>> 6);
    }*/
   public long rotateRight(long x, int n)
   {
       return (x >>> n) | (x << (64 - n));
   }

    public long Ch(long x, long y, long z)
   {
       return ((x & y) ^ ((~x) & z));
   }

    public long Maj(long x, long y, long z)
    {
        return ((x & y) ^ (x & z) ^ (y & z));
    }

    public long compressionSigma0(long x)
    {
        return rotateRight(x, 28) ^ rotateRight(x, 34) ^ rotateRight(x, 39);
    }

    public long compressionSigma1(long x)
    {
        return rotateRight(x, 14) ^ rotateRight(x, 18) ^ rotateRight(x, 41);
    }

    public long messageSigma0(long x)
    {
        return rotateRight(x, 1) ^ rotateRight(x, 8) ^ (x >>> 7);
    }

    public long messageSigma1(long x)
    {
        return rotateRight(x, 19) ^ rotateRight(x, 61) ^ (x >>> 6);
    }
}
