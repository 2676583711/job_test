package cn.zhou.utils;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

//生成 token ,以及验证 token
public class JwtUtil {
    /*
    1秒=1000毫秒(ms) 1毫秒=1／1,000秒(s)
    1秒=1,000,000 微秒(μs) 1微秒=1／1,000,000秒(s)
    1秒=1,000,000,000 纳秒(ns) 1纳秒=1／1,000,000,000秒(s)
    1秒=1,000,000,000,000 皮秒(ps) 1皮秒=1／1,000,000,000,000秒(s)
    1分钟=60秒
    1小时=60分钟=3600秒
     */
    //过期时间
    private static final long EXPIRE_TIME = 1000;
    //私钥
    private static final String TOKEN_SECRET = "privateKey";

    /**
     * 生成签名，15分钟过期
     */
    public static String createToken(String userId) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("JwtUtil工具生成Token异常:" + e.getMessage());
        }
        return null;
    }

    /**
     * 检验token是否正确
     * Long
     */
    public static Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);

            //getClaim 可以获取用户登录信息
            Long userId = jwt.getClaim("userId").asLong();
            return true;
//            return userId;
        } catch (Exception e) {
            System.out.println("JwtUtil工具验证异常:" + e.getMessage());
        }
        //     return 0L;
        return false;
    }


    public static DecodedJWT decodedJWT(String tokenName) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            return verifier.verify(tokenName);
        } catch (Exception e) {
            System.out.println("JwtUtil工具验证异常:" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String token = createToken("");
        System.out.println(token);

        Boolean aBoolean = verifyToken(token);
        System.out.println("verify token:" + aBoolean);
    }
}


/*
eyJhbGciOiJIUzI1NiIsIlR5cGUiOiJKd3QiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE1OTM5NjIwNTYsInVzZXJJZCI6MzEyNjQ2NTY0Nn0.
0oz7nldBgUmwzgoGvej3Dya3C9evskLhy3Wk1CqfJbs
verify token:true

eyJhbGciOiJIUzI1NiIsIlR5cGUiOiJKd3QiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE1OTM5NjIxMjQsInVzZXJJZCI6IjMxMjY0NjU2NDZMIn0.jh4o9CXP2wrzqFiaquniz52F5AASa4C9niMvpepTKW4
verify token:true

 */