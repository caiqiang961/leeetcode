package org.mianshi;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Map;

//比较俩个string是否是完全一样的json串儿
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s1 = "   {\n" +
                "        \"timestamp\": 1715828588,\n" +
                "        \"namespace\": \"qce/taas\",\n" +
                "        \"dimension\": {\n" +
                "            \"appid\": \"1251365580\",\n" +
                "            \"clusterid\": \"cls-uiq690ye\",\n" +
                "            \"podname\": \"1251365580-cls-uiq690ye-test-301-cqxtzx-zx-1-0\",\n" +
                "            \"taskid\": \"test-301\"\n" +
                "        },\n" +
                "        \"batch\": [\n" +
                "            {\n" +
                "                \"name\": \"mem\",\n" +
                "                \"value\": 52.43\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"cpu\",\n" +
                "                \"value\": 49\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        String s2 = "   {\n" +
                "        \"timestamp\": 1715828588,\n" +
                "        \"namespace\": \"qce/taas\",\n" +
                "        \"dimension\": {\n" +
                "            \"appid\": \"1251365580\",\n" +
                "            \"clusterid\": \"cls-uiq690ye\",\n" +
                "            \"podname\": \"1251365580-cls-uiq690ye-test-301-cqxtzx-zx-1-0\",\n" +
                "            \"taskid\": \"test-301\"\n" +
                "        },\n" +
                "        \"batch\": [\n" +
                "            {\n" +
                "                \"name\": \"mem\",\n" +
                "                \"value\": 52.43\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"cpu\",\n" +
                "                \"value\": 49\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        System.out.println(solution1.compare(s1, s2));
    }

    // 比较俩个json字符串是否完全一样
    public boolean compare(String str1, String str2) {
        if (JSONObject.isValidArray(str1) != JSONObject.isValidArray(str1)) {
            return false;
        }
        if (!isJsonObject(str1)) {
            JSONArray jsonArray1 = JSONArray.parseArray(str1);
            JSONArray jsonArray2 = JSONArray.parseArray(str2);
            return parse(jsonArray1, jsonArray2);
        } else {
            JSONObject jsonObject1 = JSONObject.parseObject(str1);
            JSONObject jsonObject2 = JSONObject.parseObject(str2);
            return parse(jsonObject1, jsonObject2);
        }
    }

    private boolean isJsonObject(Object o) {
        String s = JSON.toJSONString(o);
        return !JSONObject.isValidArray(s);
    }

    private boolean parse(JSON json1, JSON json2) {
        if (json1 instanceof JSONObject && json2 instanceof JSONObject) {
            JSONObject jsonObject1 = (JSONObject) json1;
            JSONObject jsonObject2 = (JSONObject) json2;
            if (jsonObject1.size() != jsonObject2.size()) {
                return false;
            }
            for (Map.Entry<String, Object> next : jsonObject1.entrySet()) {
                if (!jsonObject2.containsKey(next.getKey())) {
                    return false;
                }
                Object o1 = next.getValue();
                Object o2 = jsonObject2.get(next.getKey());

                // 1、判断类型
                // 2、转换类型
                if (!o1.getClass().equals(o2.getClass())) {
                    return false;
                }
                if (o1 instanceof String || o1 instanceof Number) {
                    if (!o1.toString().equals(o2.toString())) {
                        return false;
                    }
                } else {
                    JSON newJson1;
                    JSON newJson2;
                    //                    JSON newJson1 = (JSON) JSON.toJSON(next.getValue());
//                    JSON newJson2 = (JSON) JSON.toJSON(jsonObject2.get(next.getKey()));
                    if (isJsonObject(o1)) {
                        newJson1 = JSONObject.parseObject(JSON.toJSONString(o1));
                        newJson2 = JSONObject.parseObject(JSON.toJSONString(o2));
                    } else {
                        newJson1 = JSONArray.parseArray(JSON.toJSONString(o1));
                        newJson2 = JSONArray.parseArray(JSON.toJSONString(o2));
                    }

                    if (!parse(newJson1, newJson2)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (json1 instanceof JSONArray && json2 instanceof JSONArray) {
            JSONArray jsonArray1 = (JSONArray) json1;
            JSONArray jsonArray2 = (JSONArray) json2;
            if (jsonArray1.size() != jsonArray2.size()) {
                return false;
            }
            Iterator iterator = jsonArray1.stream().iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                JSON newJson1 = (JSON) JSON.toJSON(next);
                // 判断一个Array中的元素是否在另一个中存在
                if (!jsonArray2.contains(newJson1)) {
                    return false;
                } else {
                    jsonArray2.remove(newJson1);
                }
            }
        } else {
            return false;
        }
        return true;
    }


}
