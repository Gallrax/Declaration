package com.cxgt.test;

import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/30
 */
public class UploadTest {

    //test ok !
    @Test
    public void test01() {
        File tempFile = new File("D:\\tmp\\temp.png");
        HashMap<String, Object> fileHashMap = new HashMap<>();
        fileHashMap.put("file", tempFile);
        String result = HttpUtil.post("http://cs.ananas.chaoxing.com/upload", fileHashMap);
        System.out.println("rresult : " + result);
    }
}
