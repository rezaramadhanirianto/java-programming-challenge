package programmingChallenge.unclassified;

// -1, 8, 6, 0, 7, 3, 8, 9, -1, 6
// return 5
// -1 0 1
// return 3
public class TheJungleBook {
    private void minGroup(int[] species) {
        int max = 0;
        for(int i = 0; i< species.length;i++){
            max = Math.max(max, countLevel(species, i));
        }
        System.out.println(max);
    }

    private int countLevel(int[] species, int i){
        int count = 0;
        while(i != -1){
            i = species[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TheJungleBook jungleBook = new TheJungleBook();
        int[] testCase = {-1, 8, 6, 0, 7, 3, 8, 9, -1, 6};
        jungleBook.minGroup(testCase);
        int[] testCase2 = {-1, 0, 1};
        jungleBook.minGroup(testCase2);
    }
}
