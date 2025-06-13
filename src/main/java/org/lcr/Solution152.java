package org.lcr;

public class Solution152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
//        System.out.println(solution152.verifyTreeOrder(new int[]{4, 9, 6, 5, 8}));
        System.out.println(solution152.verifyTreeOrder(new int[]{3763, 4748, 8426, 7169, 1649, 9815, 15169, 26431, 25793, 23780, 16477, 30926, 32389, 33513, 31576, 27109, 37561, 37991, 38867, 36880, 51508, 51782, 52864, 52128, 52024, 60508, 66676, 64287, 68401, 74637, 76269, 75971, 69243, 57334, 77958, 85630, 79980, 88823, 88056, 86715, 78604, 89045, 91112, 90397, 89014, 76863, 51423, 45765, 95539, 257}));
    }

    public boolean verifyTreeOrder(int[] postorder) {
        return just(0, postorder.length - 1, postorder);
    }

    private boolean just(int startIndex, int endIndex, int[] postorder) {
        if (startIndex >= endIndex || endIndex <= 0 || startIndex < 0) {
            return true;
        }
        int root = postorder[endIndex];
        int right = postorder[endIndex - 1];
        if (root < right) {
            //有右子树
            int leftIndex = endIndex - 1;
            while (leftIndex >= 0) {
                if (postorder[leftIndex] <= postorder[endIndex]) {
                    break;
                }
                leftIndex--;
            }
            leftIndex = leftIndex + 1;

            for (int i = startIndex; i < leftIndex; i++) {
                if (postorder[i] >= postorder[endIndex]) {
                    return false;
                }
            }

            return just(startIndex, leftIndex - 1, postorder) &&
                    just(leftIndex, endIndex - 1, postorder);

        } else {
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println(startIndex);
                System.out.println(endIndex);
                if (postorder[i] >= postorder[endIndex]) {
                    return false;
                }
            }
            //没有右子树
            return just(startIndex, endIndex - 1, postorder);
        }
    }
}
