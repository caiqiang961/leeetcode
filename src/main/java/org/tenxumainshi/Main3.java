package org.tenxumainshi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:实现LRU缓存
 *
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

 * 获取数据 get(key)：

 *     如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1

 * 写入数据 put(key, value)：
 *
 *
 *     如果关键字已经存在，则变更其数据值
 *
 *
 *     如果关键字不存在，则插入该组「关键字/值」
 *
 *
 *     当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间
 * 示例：

 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */
//        *cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1); // 返回 1
//        *cache.put(3,3); // 该操作会使得关键字 2 作废
//        *cache.get(2); // 返回 -1 (未找到)
//        *cache.put(4,4); // 该操作会使得关键字 1 作废
//        *cache.get(1); // 返回 -1 (未找到)
//        *cache.get(3); // 返回 3
//        *cache.get(4); // 返回 4
// * @author: caiqiang
// * @create: 2023-08-08 18:42
// **/
public class Main3 {

    public static void main(String[] args) {
        Main3 main3 = new Main3(2);

       // main3.put();
    }

    public Main3(int capily) {
        this.cache = new ConcurrentHashMap<>();
        this.deque = new ArrayDeque<>();
        this.capily = capily;
    }
    private int capily;
    private Map<Integer,Integer> cache;

    private Deque<Integer> deque;

    private void put(int key,int value){
        cache.put(key,value);
        deque.remove(key);
        deque.offerLast(key);

        if (deque.size() > capily ) {
            cache.remove(deque.pollFirst());
        }
    }

    private int get(int key){
        if (!deque.contains(key)) {
            return -1;
        }
        deque.remove(key);
        deque.offerLast(key);
        return cache.get(key);
    }


}
