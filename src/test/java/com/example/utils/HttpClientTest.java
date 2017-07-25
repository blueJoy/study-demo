package com.example.utils;


import org.junit.*;

import java.io.File;
import java.util.*;

/**
 * Created by baixiangzhu on 2017/7/24.
 */
public class HttpClientTest {


    public static final String TEST_URL = "http://localhost:8080/httpClient";

    public static final String TEST_NOT_RESULT_URL = "http://localhost:8080/httpClient/noResult";

    public static final String QUERY_PARAMTERS ="?id=1&name=bxz";

    private static final String ASSERT_MSG = "返回结果与预期不一致";

    static Map<String,String> headers = new HashMap<>();
    static Map<String,String> parameters = new HashMap<>();
    static Map<String,Object> body = new HashMap<>();

    static {

        headers.put("traceId", UUID.randomUUID().toString());
        headers.put("app","IOS");

        parameters.put("id","2");
        parameters.put("name","qq");


        body.put("id","3");
        body.put("name","剑仙");
        body.put("sex","M");
        body.put("age",25);
    }

    /**   =================   TEST GET ======================= **/

    @Test
    public void testGet(){

        String url = TEST_URL + QUERY_PARAMTERS;

        String result = HttpUtils.get(url);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"1\",\"name\":\"bxz\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testGetAndHeaders(){

        String url = TEST_NOT_RESULT_URL + QUERY_PARAMTERS;

        //如果结果没有返回值，默认为""
        String result = HttpUtils.get(url,headers);

        Assert.assertEquals(ASSERT_MSG,"",result);

    }

    @Test
    public void testGetAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.getFromQueryParameter(url,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testGetAndHeadersAndParameters(){

        String url = TEST_NOT_RESULT_URL;

        String result = HttpUtils.getFromQueryParameter(url,headers,parameters);

        Assert.assertEquals(ASSERT_MSG,"",result);

    }


    /**   =================   TEST POST ======================= **/

    @Test
    public void testPost(){

        String url = TEST_URL + QUERY_PARAMTERS;

        String result = HttpUtils.post(url,body);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"1\",\"name\":\"bxz\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testPostndHeaders(){

        String url = TEST_NOT_RESULT_URL;

        //如果结果没有返回值，默认为""
        String result = HttpUtils.post(url,body,headers);

        Assert.assertEquals(ASSERT_MSG,"",result);

    }

    @Test
    public void testPostAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.postFromQueryParameters(url,body,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testPostAndHeadersAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.postFromQueryParameters(url,body,headers,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void postFile(){

        String url =  TEST_URL + "/upload" + QUERY_PARAMTERS;

        File file = new File("E:/text.txt");

        System.out.println(file.isFile());

        String result = HttpUtils.postFile(url, file,null,headers);

        System.out.println(result);

    }



    /**   =================   TEST PUT ======================= **/

    @Test
    public void testPut(){

        String url = TEST_URL + QUERY_PARAMTERS;

        String result = HttpUtils.put(url,body);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"1\",\"name\":\"bxz\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testPutAndHeaders(){

        String url = TEST_NOT_RESULT_URL;

        //如果结果没有返回值，默认为""
        String result = HttpUtils.put(url,body,headers);

        Assert.assertEquals(ASSERT_MSG,"",result);

    }

    @Test
    public void testPutAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.putFromQueryParameters(url,body,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testPutAndHeadersAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.putFromQueryParameters(url,body,headers,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }


    /**   =================   TEST DELETE ======================= **/

    @Test
    public void testDelete(){

        String url = TEST_URL + QUERY_PARAMTERS;

        String result = HttpUtils.delete(url);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"1\",\"name\":\"bxz\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testDeleteAndHeaders(){

        String url = TEST_NOT_RESULT_URL + QUERY_PARAMTERS;

        //如果结果没有返回值，默认为""
        String result = HttpUtils.delete(url,headers);

        Assert.assertEquals(ASSERT_MSG,"",result);

    }

    @Test
    public void testDeleteAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.deleteFromQueryParameters(url,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }

    @Test
    public void testDeleteAndHeadersAndParameters(){

        String url = TEST_URL;

        String result = HttpUtils.deleteFromQueryParameters(url,headers,parameters);

        Assert.assertEquals(ASSERT_MSG,"{\"id\":\"2\",\"name\":\"qq\",\"sex\":null,\"age\":0}",result);

    }


}
