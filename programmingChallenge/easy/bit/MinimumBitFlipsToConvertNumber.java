package programmingChallenge.easy.bit;

class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int differingBits = start ^ goal;

        int count = 0;
        while (differingBits > 0) {
            count += differingBits & 1;
            differingBits >>= 1;
        }

        return count;
    }
}