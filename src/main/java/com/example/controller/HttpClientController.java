package com.example.controller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

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

        headers.forEach((k,v) ->{
            System.out.println(k +"-->"+ v);
        });

        System.out.println(user);
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
