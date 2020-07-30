package com.cloud.eureka;

import com.alibaba.fastjson.JSON;
import lombok.Data;

public class T1 {
    public static void main(String[] args) {
       /* TBean tt =new TBean();
        tt.setId("1");
        tt.setName("name1");
        String jsonStr= JSON.toJSONString(tt);
        System.out.println(jsonStr);
        Object o=JSON.parseObject(jsonStr,TBean.class);
        if ( o instanceof TBean){
            System.out.println(1);
        }else{
            System.out.println(JSON.parse(jsonStr).getClass());
        }
*/
        Double a=-1.345;
        char [] b= String.valueOf(a).replace(".","").toCharArray();
        String str="-";
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
            System.out.println("-".equals(String.valueOf(b[i])));
        }

        System.out.println("-".equals(String.valueOf(a)));
    }


}
@Data
class TBean {
    String id;
    String name;

}