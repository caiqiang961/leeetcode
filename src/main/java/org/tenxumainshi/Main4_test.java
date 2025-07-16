package org.tenxumainshi;

import java.util.*;

public class Main4_test {
}


class City {
    private Map<String, List<Node>> adj = new HashMap<>();

    void addNode(String node) {
        adj.putIfAbsent(node, new ArrayList<>());
    }

    void addEdge(String node1, String node2, int weight) {
        adj.get(node1).add(new Node(node2, weight));
        adj.get(node2).add(new Node(node1, weight));
    }

    /**
     * 使用 Dijkstra 算法求解。Dijkstra 算法是一种常用的求解最短路径的算法,它的核心思想是贪心,每次选择离源点最近的节点,并使用该节点来更新其他节点的最短距离。
     * <p>
     * 算法步骤如下:
     * <p>
     * 1.创建一个集合 S,初始时将源节点加入。
     * 2.创建一个距离映射 dist,用于存储源点到各节点的最短路径权重和,初始时将所有节点的距离设为无穷大,源节点距离设为 0。
     * 3.从距离源点最近的节点开始,将该节点加入集合 S,并使用该节点来更新其他节点到源点的距离。
     * 具体做法是:对该节点的每个邻居节点,计算经过该节点到达该邻居节点的距离,如果这个距离比之前记录的距离更短,就更新 dist 中存储的距离值。
     * 4.重复第3步,直到目标节点被加入集合 S 为止。此时 dist 中存储的就是源点到各节点的最短距离。
     * 5.为了获得最短路径的节点序列,我们需要从目标节点开始,不断找出前驱节点,直到回到源节点为止。
     *
     * @param source
     * @param dest
     * @return
     */
    List<String> shortestPath(String source, String dest) {
        // 创建存储顶点到起点的距离的映射
        Map<String, Integer> dist = new HashMap<>();
        // 创建存储顶点的前一个顶点的映射，用于最终构建最短路径
        Map<String, String> prev = new HashMap<>();
        // 创建存储已访问顶点的集合
        Set<String> visited = new HashSet<>();
        // 创建优先队列，用于按照顶点到起点的距离进行排序
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // 初始化距离映射，将所有顶点的距离初始化为无穷大
        for (String node : adj.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        // 将起点到自身的距离初始化为0
        dist.put(source, 0);
        // 将起点加入优先队列
        pq.offer(new Node(source, 0));

        // Dijkstra算法的核心部分
        while (!pq.isEmpty()) {
            // 从优先队列中取出当前距离起点最近的顶点
            Node curr = pq.poll();
            String node = curr.node;
            int weight = curr.weight;

            // 如果当前顶点已访问过，则跳过
            if (visited.contains(node)) continue;
            // 将当前顶点标记为已访问
            visited.add(node);

            // 遍历当前顶点的邻居节点
            for (Node neighbor : adj.get(node)) {
                String nextNode = neighbor.node;
                int newWeight = weight + neighbor.weight;
                // 如果通过当前顶点到达邻居节点的路径比之前计算的距离短，则更新距离映射和前一个顶点映射
                if (newWeight < dist.get(nextNode)) {
                    dist.put(nextNode, newWeight);
                    prev.put(nextNode, node);
                    // 将邻居节点加入优先队列，以便后续继续迭代
                    pq.offer(new Node(nextNode, newWeight));
                }
            }
        }

        // 构建最短路径
        List<String> path = new ArrayList<>();
        String curr = dest;
        // 从目标节点开始，沿着前一个顶点映射逆向遍历，直到回到起点
        while (prev.containsKey(curr)) {
            path.add(0, curr);
            curr = prev.get(curr);
        }
        // 将起点加入到路径中
        path.add(0, source);
        return path;
    }

    private static class Node {
        String node;
        int weight;

        Node(String n, int w) {
            node = n;
            weight = w;
        }
    }
}
