package org.caiqiang;

import org.caiqiang.pojo.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution133 {
    Map<Integer, Node> singletonMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return getSingleton(node);
    }

    private Node getSingleton(Node node) {
        if (node == null){
            return null;
        }
        //先从最终缓存中获取，获取不到再去二级缓存获取，获取不到在创建并放在二级缓存
        Node result;
        //单例池获取
        result = singletonMap.get(node.val);
        if (result != null) {
            return result;
        }
        //createBean
        result = new Node(node.val);
        //先放在单例池中,循环引用也可以获取到
        singletonMap.put(node.val, result);
        //填充属性
        if (node.neighbors != null && node.neighbors.size() != 0) {
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (result.neighbors == null) {
                    result.neighbors = new ArrayList<>();
                }
                Node singleton = getSingleton(node.neighbors.get(i));
                if (singleton != null){
                    result.neighbors.add(singleton);
                }

            }
        }
        return result;
    }

}
