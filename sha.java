package hash;

public class sha {
    public sha(){

    }

    public long[][] toBlocks(byte[] message) {

        // a block has: 1024 bits = 128 bytes = 16 longs
        long[][] blocks = new long[message.length / 128][16];

        // For every block
        for (int i = 0; i < message.length / 128; i++) {
            // For each long in a block
            for (int j = 0; j < 16; j++) {
                // Set the block value to the correct one
                blocks[i][j] = arrToLong(message, i * 128 + j * 8);
            }
        }
        return blocks;
    }

    public long arrToLong(byte[] input, int j) {
        long v = 0;
        for (int i = 0; i < 8; i++) {
            v = (v << 8) + (input[i + j] & 0xff);
        }
        return v;
    }

    public long[][] expandedMessage(long[][] block){
        long[][] W = new long[block.length][80];

        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < 16; j++) {
                W[i][j] = block[i][j];
            }
            algorithmicOperations algo=new algorithmicOperations();
            for (int j = 16; j < 80; j++) {
                W[i][j] = algo.messageSigma1(W[i][j-2]) + W[i][j-7] + algo.messageSigma0(W[i][j-15]) + W[i][j-16];
            }
        }

        return W;
    }
}
