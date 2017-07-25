package com.example.controller;

import com.example.entity.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

/**
 * Created by baixiangzhu on 2017/7/24.
 */
@RestController
@RequestMapping("/httpClient")
public class HttpClientController {

    /**   ========== GET  ================= **/

    @GetMapping()
    public User get(String id, String name, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println("id:="+id);
        System.out.println("name:="+name);

        return new User(id,name);
    }

    @GetMapping("/noResult")
    public void getNoResult(String id, String name, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println("id:="+id);
        System.out.println("name:="+name);
    }


    /**   ========== POST  ================= **/

    @PostMapping()
    public User post(String id,String name,@RequestBody User user, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) -> System.out.println(k +"-->"+ v));

        System.out.println(user);
        return new User(id,name);
    }

    @PostMapping("/noResult")
    public void postNoResult(@RequestBody User user, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->System.out.println(k +"-->"+ v));

        System.out.println(user);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,String id,@RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->System.out.println(k +"-->"+ v));

        String filename = file.getOriginalFilename();
        System.out.println(filename);

        InputStream in = null;
        OutputStream out = null;

        try {
            in = file.getInputStream();

            File outFile = new File("a.txt");

            out = new FileOutputStream(outFile);

            IOUtils.copy(in,out);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return filename;
    }


    /**   ========== PUT  ================= **/

    @PutMapping()
    public User put(String id, String name,@RequestBody User user, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println(user);
        return new User(id,name);
    }

    @PutMapping("/noResult")
    public void putNoResult(@RequestBody User user, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println(user);
    }


    /**   ========== DELETE  ================= **/

    @DeleteMapping()
    public User delete(User user, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println(user);
        return user;
    }

    @DeleteMapping("/noResult")
    public void deleteNoResult(String id, String name, @RequestHeader Map<String,String> headers){

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println(new User(id,name));
    }


}
