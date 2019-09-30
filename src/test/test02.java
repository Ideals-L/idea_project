package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test02 {
    public static void main(String[] args) {
        HashMap<String,Integer> flatten=new HashMap<>();
        //HashMap<String,Object> temp=null;
        HashMap<String,Object> resultMap=new HashMap<>();
        String[] array=new  String[10];
        flatten.put("A",1);
        flatten.put("B.A",2);
        flatten.put("B.B",3);
        flatten.put("CC.D.E",4);
        flatten.put("CC.D.F",5);
        System.out.println(flatten);



        for (HashMap.Entry<String,Integer> entry:flatten.entrySet()) {
           int index = entry.getKey().indexOf(".");

            if (index >= 0) {
                String firstKey = entry.getKey().substring(0, index);
                String restKey = entry.getKey().substring(index + 1);

                HashMap<String,Object> temp=transfer(restKey, entry.getValue(), (HashMap<String, Object>) resultMap.get(firstKey));
                resultMap.put(firstKey, temp);

            } else {
                resultMap.put(entry.getKey(), entry.getValue());
            }


        }
        System.out.print(resultMap);
    }



    private static HashMap<String,Object> transfer(String restKey,Integer value,HashMap<String,Object> map){
        HashMap<String,Object> temp=new HashMap<>();
        HashMap<String,Object> curKeyMap=null;
        int index=restKey.indexOf(".");
        if(index>=0){
            String curKey = restKey.substring(0, index);
            String curRestKey = restKey.substring(index + 1);
            if(map!=null){
                curKeyMap=(HashMap<String, Object>) map.get(curKey);
            }

            HashMap<String,Object> resultMap2=transfer(curRestKey,value,curKeyMap);
            temp.put(curKey,resultMap2);
        }
        else{
            if(map != null){
                temp=map;//map是根据firstkey获得的剩下的值，比如根据B获取其value为（A:2），即map(A:2)，把存在的map赋值给temp,
                // 再往里面加入新的键值，下行就是添加（B:3）
            }
           temp.put(restKey,value);

        }
        return temp;

    }

}


