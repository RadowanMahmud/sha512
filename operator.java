package hash;

import java.math.BigInteger;

public class operator {
    public operator(){

    }
    public String SHA512(String s,int mainlen){

       char[] c_arr = s.toCharArray();
        byte[] message = new byte[s.length()];
        for(int i=0;i<s.length();i++){
            if(c_arr[i]!='0' && c_arr[i]!='1')  message[i]=(byte)c_arr[i];
            else if(c_arr[i]=='1') message[i]= (byte) 0x80;
        }
       //byte[] message = s.getBytes();
        System.out.println(message.length);

        byte[] lenInBytes = BigInteger.valueOf(mainlen * 8).toByteArray();

        // And put it at the end of our padded input
        for (int i = lenInBytes.length; i > 0; i--) {
            message[s.length() - i] = lenInBytes[lenInBytes.length - i];
        }
        sha sha = new sha();
        long[][] blocks = sha.toBlocks(message);

        long[][] W = sha.expandedMessage(blocks);

        long[] eightInitialBuffers = initializedValues.eigthInitialBuffers.clone();
        algorithmicOperations algo = new algorithmicOperations();

        // For every block
        for (int i = 0; i < blocks.length; i++) {
            // a-h is set to the buffer initially
            long a = eightInitialBuffers[0];
            long b = eightInitialBuffers[1];
            long c = eightInitialBuffers[2];
            long d = eightInitialBuffers[3];
            long e = eightInitialBuffers[4];
            long f = eightInitialBuffers[5];
            long g = eightInitialBuffers[6];
            long h = eightInitialBuffers[7];

            // Run 80 rounds of the SHA-512 compression function on a-h
            for (int j = 0; j < 80; j++) {
                long t1 = h +algo.compressionSigma1(e) + algo.Ch(e, f, g) + initializedValues.K[j] + W[i][j];
                long t2 = algo.compressionSigma0(a) + algo.Maj(a, b, c);
                h = g;
                g = f;
                f = e;
                e = d + t1;
                d = c;
                c = b;
                b = a;
                a = t1 + t2;
            }

            eightInitialBuffers[0] = a + eightInitialBuffers[0];
            eightInitialBuffers[1] = b + eightInitialBuffers[1];
            eightInitialBuffers[2] = c + eightInitialBuffers[2];
            eightInitialBuffers[3] = d + eightInitialBuffers[3];
            eightInitialBuffers[4] = e + eightInitialBuffers[4];
            eightInitialBuffers[5] = f + eightInitialBuffers[5];
            eightInitialBuffers[6] = g + eightInitialBuffers[6];
            eightInitialBuffers[7] = h + eightInitialBuffers[7];

        }

        String result = "";
        for (int i = 0; i < 8; i++) {
            result += String.format("%016x", eightInitialBuffers[i]);
        }

        return result;
    }
}
