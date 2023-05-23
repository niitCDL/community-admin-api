package com.soft2242.one.base.security.cache;

import com.soft2242.one.base.common.cache.RedisCache;
import com.soft2242.one.base.common.cache.RedisKeys;
import com.soft2242.one.base.security.user.UserDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 认证 Cache
 *
 * @author ao&dl
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
