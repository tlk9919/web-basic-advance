package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testJwt(){

        Map<String, Object> dataMap=new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==")//加密算法和密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();//生成token
        System.out.println(jwt);
    }
    @Test
    public void testParseJwt(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0MjIwMzExMH0.tVSna1L8oQK3Qm0Cf2euS6sYSiak8c29l-D_my094Xo";
        Claims claims = Jwts.parser()
                .setSigningKey("aXRoZWltYQ==")//指定密钥
                .parseClaimsJws(token)//解析token
                .getBody();//获取自定义信息
        System.out.println(claims);
    }
}
