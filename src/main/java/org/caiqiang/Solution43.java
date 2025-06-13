package org.caiqiang;


public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiply2("32", "3967")); //32 * 3967
        //    7 9 3 4
        //1 1 9 0 1
        //1 2 6 9 4 4


//        int[] a = new int[]{0,8,9,9};
//solution43.store(a,5,1);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
    }

    //int范围会超出
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        int n1 = 0, n2 = 0;
        int b1 = 1, b2 = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int current = ((int) num1.charAt(i)) - 48;
            n1 = n1 + (current * b1);
            b1 = b1 * 10;
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            int current = ((int) num2.charAt(i)) - 48;
            n2 = n2 + (current * b2);
            b2 = b2 * 10;
        }
        System.out.println(n1);
        System.out.println(n2);
        int result = n1 * n2;
        return result + "";
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }

        int[] arr = new int[num1.length() + 1 + num2.length()];
        int we = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {

            int current1 = ((int) num1.charAt(i)) - 48;
            int dierwei = 0;
            int wei = we;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int current2 = ((int) num2.charAt(j)) - 48;
                int a = current1 * current2 + dierwei;
                int save;
                if (a <= 9) {
                    save = a;
                    dierwei = 0;
                } else {
                    dierwei = a / 10;
                    save = a % 10;
                }
                store(arr, save, wei);
                wei++;
            }
            if (dierwei != 0) {
                store(arr, dierwei, wei);
            }
            //开始第二次循环
            we++;
        }
        String result = "";
        boolean falg = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && falg) {
                continue;
            }
            result = result + arr[i];
            falg = false;
        }
        return result;
    }

    private void store(int[] arr, int currentValue, int weiNum) {
        int save, dierwei = currentValue;
        while (dierwei != 0) {
            int a = arr[arr.length - weiNum] + dierwei;
            if (a <= 9) {
                save = a;
                dierwei = 0;
            } else {
                dierwei = a / 10;
                save = a % 10;
            }
            arr[arr.length - weiNum] = save;
            weiNum++;
        }
    }
}
