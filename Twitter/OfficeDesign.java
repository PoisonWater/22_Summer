package Twitter;

public class OfficeDesign {
    private int getMaxHeight(int startIndex, int endIndex, int startHeight, int endHeight) {

        // Basic Parameters for Judgement
        int hi = Math.max(startHeight, endHeight);
        int lo = Math.min(startHeight, endHeight);
        int gap = Math.abs(startIndex - endIndex) - 1;

        // Judgements:
        // Height Difference smaller than blank gaps (Gaps are wider)
        if (hi - lo < gap) {
            return hi + lo + gap + 1 / 2;

        // Height Difference taller than blank gaps (Height difference is taller)
        } else {
            return lo + gap;
        }
    }

    public int maxHeight(int n, int[] tablePositions, int[] tableHeights) {

        int maxHeight = 0;

        for (int i = 1; i < tablePositions.length; i++) {
            if (Math.abs(tablePositions[i] - tablePositions[i - 1]) > 1) { // Not Adjacent
                maxHeight = Math.max(
                        getMaxHeight(tablePositions[i - 1], tablePositions[i], tableHeights[i - 1], tableHeights[i]),
                        maxHeight);
            }
        }

        return 0;
    }
}
