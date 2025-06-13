package org.tenxumainshi;

//比较俩个json字符串是否相同

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
       String json1 = "{\n" +
               "    \"code\": 200001,\n" +
               "    \"msg\": \"success\",\n" +
               "  \"xxx\": [{\"msg2\": \"success2\"}     ,{\"msg1\": \"success1\"},{\"msg\": \"success\"}],\n  "+
               "    \"data\": {\n" +
               "        \"JSON\": {\n" +
               "            \"name\": \"张三、李四、小王\"\n" +
               "        }\n" +
               "    }\n" +
               "}";
       String json2 = "{\n" +
               "    \"code\": 200001,\n" +
               "    \"msg\": \"success\",\n" +
               "  \"xxx\": [{\"msg\": \"success\"},{\"msg2\": \"success2\"},{\"msg1\": \"success1\"}],\n  "+
               "    \"data\": {\n" +
               "        \"JSON\": {\n" +
               "            \"name\": \"张三、李四、小王\"\n" +
               "        }\n" +
               "    }\n" +
               "}";

        Main main = new Main();
        System.out.println(main.eqT(json1, json2));
    }

    private boolean eqT(String json1, String json2) {

        Object parse1 = JSONObject.parse(json1);
        Object parse2 = JSONObject.parse(json2);

        return panJson(parse1,parse2);
    }

    private boolean eqJsonObject(JSONObject jsonObject1, JSONObject jsonObject2) {

        Set<String> keySet1 = jsonObject1.keySet();
        Set<String> keySet2 = jsonObject2.keySet();


        if (keySet1.size() != keySet2.size()) {
            return false;
        }
        if (!keySet1.containsAll(keySet2)) {
            return false;
        }

        Iterator<String> iterator = keySet1.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!panJson(jsonObject1.get(next),jsonObject2.get(next))) {
                return false;
            }
        }
        return true;
    }

    private boolean eqJsonArray(JSONArray jsonArray1, JSONArray jsonArray2) {
        if (jsonArray1.size() != jsonArray2.size()){
            return false;
        }

       Set<Integer> json2Set = new HashSet<Integer>();

        for (int i = 0; i < jsonArray1.size(); i++) {//不能使用jsonArray1.get(i)  因为俩个jsonArray中的对象顺序可能不同
            boolean flag = false;
            for (int j = 0; j < jsonArray1.size(); j++) {
                if (json2Set.contains(j)) {
                    continue;
                }
                if (panJson(jsonArray1.get(i),jsonArray2.get(j))) {
                    json2Set.add(j);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return false;
            }
        }
        return true;
    }


    private boolean panJson(Object object1,Object object2){
        if (object1 == null && object2 == null){//都等于null则返回treu
            return true;
        }
        if (object1 == null || object2 == null){//根据上一个判断 至少有一个不为null  ，所以只要有一个为null  说明另一个一定不为null，则返回false
            return false;
        }
        if (!object1.getClass().equals(object2.getClass())){//String  Integer Double...  jSONOBJECT JSONARRAY
            return false;
        }
        if (object1 instanceof JSONObject){
            return eqJsonObject((JSONObject)object1,(JSONObject)object2);
        }else if (object1 instanceof JSONArray){
            return eqJsonArray((JSONArray)object1,(JSONArray)object2);
        }else {//基本数据类型
            return object1.equals(object2);
        }
    }
}
