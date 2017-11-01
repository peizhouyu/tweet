package cn.mrpei.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Token cache.
 */
public class TokenCache {

    private static TokenCache instance;

    private Map<String, String> tokenMap;

    private TokenCache(){
        tokenMap = new HashMap<String, String>();
    }

    public static TokenCache getInstance(){
        if (instance == null){
            synchronized (TokenCache.class){
                if (instance == null){
                    instance = new TokenCache();
                }
            }
        }
        return instance;
    }

    /**
     * 保存token与对应的手机号
     * @param token
     * @param phone 手机号
     */
    public void saveTokenByPhone(String token, String phone) {
        tokenMap.put(token, phone);
    }

    /**
     * 根据token获取用户信息(手机号)
     * @param token
     * @return 手机号
     */
    public String getPhone(String token) {
        return tokenMap.get(token);
    }


    /**
     * Save token by name.
     *根据用户名存储对应的token
     * @param token the token
     * @param name  the name
     */
    public void saveTokenByName(String token, String name){
        tokenMap.put(token, name);
    }


    /**
     * Get name string.
     *根据token 获取相应的用户名
     * @param token the token
     * @return the string
     */
    public String getName(String token){
        return tokenMap.get(token);
    }
}
