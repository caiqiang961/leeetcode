package org.tenxumainshi;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//任务背景：
//你是圣人敕封的“荔枝使”，负责将荔枝从“岭南”运往“长安”
//
//📌 任务要求：
//目标：使用以下城市图，用你熟悉的算法（如 Dijkstra、A*）找出从深圳→西安的最优路线，并输出路径和总代价
//
//城市图如下：括号中的数字代表运输时间（单位：小时）
//city_graph = {
//'深圳': {'广州': 1.5, '东莞': 1.0},
//'广州': {'深圳': 1.5, '韶关': 2.5, '长沙': 5.5},
//'东莞': {'深圳': 1.0, '惠州': 1.2},
//'惠州': {'东莞': 1.2, '武汉': 8.0},
//'韶关': {'广州': 2.5, '长沙': 4.0},
//'长沙': {'韶关': 4.0, '武汉': 3.0, '郑州': 8.0},
//'武汉': {'惠州': 8.0, '长沙': 3.0, '郑州': 4.5, '西安': 10.0},
//'郑州': {'长沙': 8.0, '武汉': 4.5, '洛阳': 2.0},
//'洛阳': {'郑州': 2.0, '西安': 5.0},
//'西安': {'武汉': 10.0, '洛阳': 5.0}
//}
//
//进阶挑战：（全选或可选其中一个）
//✅ 加入费用优化
//比如每段路程有个运输费用字段，你可以做双目标选择（费用 vs 时间），甚至加入权重因子。
//
//✅ 加入断路逻辑
//如果城市之间突然“断联”，你可以在图中临时删除某条边再重新运行算法，模拟现实变化。
//
//💻 需要输出内容：
//1、设计思路（文字表述）；
//2、原始代码；
//3、算法实现结果（运输总代价+最优路径的图形化展示）
//
//⏰ 截止日期：
//2025年6月19日-29日
//
//🏆 任务奖励：
//最终的运送成果将由“中书省”合议决策，根据以下三项进行综合评分：
//方案完整性★★★
//算法实现结果★★★
//互动数据（点赞评论数）★★★
//⚠️内容必须是原创的，使用chatgpt、deepseek、元宝等AI工具的，“中书省”评判为AI生成，将不参与评奖。
//
//排名TOP1-5名的“荔枝使”可获得1箱桂味荔枝+夏日露营套装
//排名TOP6-10名的“荔枝使”可获得1箱桂味荔枝
//随机挑选20位送出🧧「8.8元红包」

public class Main4 {
    private static final double[][] address = new double[11][11];
    private final Map<Integer, String> mapNumToStr;
    private final Map<String, Integer> mapStrToNum;

    {
        //初始化
        String city_graph = "{\n" +
                "            \"深圳\": {\"广州\": 1.5, \"东莞\": 1.0},\n" +
                "            \"广州\": {\"深圳\": 1.5, \"韶关\": 2.5, \"长沙\": 5.5},\n" +
                "            \"东莞\": {\"深圳\": 1.0, \"惠州\": 1.2},\n" +
                "            \"惠州\": {\"东莞\": 1.2, \"武汉\": 8.0},\n" +
                "            \"韶关\": {\"广州\": 2.5, \"长沙\": 4.0},\n" +
                "            \"长沙\": {\"韶关\": 4.0, \"武汉\": 3.0, \"郑州\": 8.0},\n" +
                "            \"武汉\": {\"惠州\": 8.0, \"长沙\": 3.0, \"郑州\": 4.5, \"西安\": 10.0},\n" +
                "            \"郑州\": {\"长沙\": 8.0, \"武汉\": 4.5, \"洛阳\": 2.0},\n" +
                "            \"洛阳\": {\"郑州\": 2.0, \"西安\": 5.0},\n" +
                "            \"西安\": {\"武汉\": 10.0, \"洛阳\": 5.0}\n" +
                "        }";
        JSONObject jsonObject = JSONObject.parseObject(city_graph);

        mapNumToStr = new HashMap<>();
        mapNumToStr.put(1, "深圳");
        mapNumToStr.put(2, "广州");
        mapNumToStr.put(3, "东莞");
        mapNumToStr.put(4, "惠州");
        mapNumToStr.put(5, "韶关");
        mapNumToStr.put(6, "长沙");
        mapNumToStr.put(7, "武汉");
        mapNumToStr.put(8, "郑州");
        mapNumToStr.put(9, "洛阳");
        mapNumToStr.put(10, "西安");
        mapStrToNum = new HashMap<>();
        mapStrToNum.put("深圳", 1);
        mapStrToNum.put("广州", 2);
        mapStrToNum.put("东莞", 3);
        mapStrToNum.put("惠州", 4);
        mapStrToNum.put("韶关", 5);
        mapStrToNum.put("长沙", 6);
        mapStrToNum.put("武汉", 7);
        mapStrToNum.put("郑州", 8);
        mapStrToNum.put("洛阳", 9);
        mapStrToNum.put("西安", 10);

        // 初始化
        for (int i = 1; i < 11; i++) {
            address[0][i] = i;
            address[i][0] = i;
        }
        jsonObject.forEach((k, v) -> {
            JSONObject jsonObject1 = jsonObject.getJSONObject(k);
            jsonObject1.forEach((k1, v1) -> {
                double doubleValue = jsonObject1.getDoubleValue(k1);
                address[mapStrToNum.get(k)][mapStrToNum.get(k1)] = doubleValue;
            });
        });
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
//                if ((j + i) > 11) {
//                    address[i][j] = -1;
//                }
                if (i != j && address[i][j] == 0) {
                    address[i][j] = Integer.MAX_VALUE;
                }

            }
        }
    }

    public static void main(String[] args) {
        Main4 m = new Main4();
        //初始打印
        m.addressPrint();
        Resp resp = m.bfsTest(1, address.length - 1);
        System.out.println("结果:" + resp);
    }

    private Resp bfsTest(int startIndex, int endIndex) {
        //这是起点到所有路径到最短距离
        double[] result = address[startIndex];
        //这是起点到对应下标的城市的累计最小距离
        double[] leiJiWight = new double[endIndex + 1];
        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        // 节点到前一个节点到映射(bfs不擅长找链路，所以需要保存每个节点到映射)
        Map<Integer, Integer> prePathMap = new HashMap<>();
        //放入起点
        deque.addLast(startIndex);
        while (!deque.isEmpty()) {
            Integer currCity = deque.pollFirst();
            set.add(currCity);
            // 遍历邻居城市
            for (int i = 1; i < address[currCity].length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                if (address[currCity][i] == Integer.MAX_VALUE) {
                    continue;
                }

                // address[currCity][i] (当前城市到下一个城市到距离) + leiJiWight[currCity] (起点到当前城市的距离)
                double currWight = address[currCity][i] + leiJiWight[currCity];
                if (currWight <= result[i]) {
                    leiJiWight[i] = result[i] = currWight;
                    deque.addLast(i);
                    prePathMap.put(i, currCity);
                }

            }
        }
        Resp resp = new Resp();
        resp.wight = address[startIndex][endIndex];

        // 回溯路径
        int curr = 10;
        if (prePathMap.containsKey(curr)) {
            Deque<Integer> deque1 = new ArrayDeque<>();
            deque1.addFirst(curr);
            while (curr != 1) {
                curr = prePathMap.remove(curr);
                deque1.addFirst(curr);
            }
            deque1.forEach(d -> {
                resp.path.add(mapNumToStr.get(d));
            });
        }

        return resp;
    }


    //打印，忽略
    private void addressPrint() {
        for (int i = 0; i < address.length; i++) {
            for (int j = 0; j < address[i].length; j++) {
                if (!(i == 0 && j == 0) && (i == 0 || j == 0)) {
                    System.out.printf("%-9s", mapNumToStr.get((int) address[i][j]));
                } else {
                    if (address[i][j] == Integer.MAX_VALUE) {
                        System.out.printf("%-10s", "max");
                    } else {
                        System.out.printf("%-10s", address[i][j]);
                    }

                }

            }
            System.out.println();
        }
    }
}

class Resp {
    double wight;
    List<String> path;

    Resp() {
        this.path = new ArrayList<>();
    }

    @Override
    public String toString() {

        return "时间:" + (wight == Integer.MAX_VALUE ? "-1" : wight) + ",路径:" + (path.size() == 0 ? "无通路" : path);
    }
}