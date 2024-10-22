package com.example.demostarter;

import com.example.demostarter.java.DemoStarterApplication;
import com.example.demostarter.java.Escape;
import com.stars.logdesenspringbootstarter.LogStarterConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoStarterApplication.class)
//@ContextConfiguration
class DemoStarterApplicationTests {

    @Autowired
    private LogStarterConfig logStarterConfig;

    @Test
    void wwe() {
        System.out.println(logStarterConfig.getUserName());
    }

    @Test
    void www() {
        Integer valueInt = Integer.parseInt("01");
        String valueHex = Integer.toHexString(valueInt);
        if (valueHex.length() % 2 != 0) {
            valueHex = "0" + valueHex;
        }
        //附加键值
        Integer addInt = 30;
        String addHex = Integer.toHexString(addInt);
        if (addHex.length() % 2 != 0) {
            addHex = "0" + addHex;
        }
        valueInt = Integer.parseInt(valueHex + addHex, 16);
        String command = String.valueOf(valueInt);
        System.out.println(command);

        String res = "";
        String temp = Integer.toHexString(Integer.parseInt(command));
        if (temp.length() % 2 == 1) temp = "0" + temp;
        res += temp;//高位

        byte[] bs = Escape.hexStringToBytes(res);
        int len=2;
        int lenReal=2;
        if(len==0){
            len=2;
        }
        byte[] initBytes=new byte[len];
        for(int i=len-1;i>=0;i--) {
            if(i>=lenReal) {
                initBytes[i]=0x00;
            }else {
                initBytes[i]=(byte)(0x00|bs[i]);
            }
        }
        System.out.println(initBytes);
    }

}
