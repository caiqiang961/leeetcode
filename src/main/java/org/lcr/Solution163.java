package org.lcr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public static void main(String[] args) {
        Solution163 solution163 = new Solution163();
        solution163.test();
    }
    public int findKthNumber(int k) {
        for (int i = 0; i < k; i++) {

        }
        return 0;
    }

    private void test() {
        List<Test> list = new ArrayList<>();
        list.add(new Test());
        System.out.println(list);

        try {
            Method add = list.getClass().getMethod("add",Object.class);
//            Method add = list.getClass().getMethod("add",Test.class);// 使用Test就报错，这就证明在运行时根根没有泛型
            add.invoke(list,new Integer(1));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list);// 多了非泛型的类型数据，这就证明在运行时根根没有泛型
    }
}
class Test{

}
