package com.accenture.ada.sessionManager.sessionmanager.service;

import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.baseapp.service.BaseService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserSessionCacheService extends BaseService {

    private static final String CACHE_NAME = "sessions";

    // return session if the cache contains it
    @Cacheable(cacheNames = CACHE_NAME, key = "#sessionId")
    public BaseContext<UserContext> get(String sessionId) {
        return null;
    }

    // write and return the session in the cache
    @CachePut(cacheNames = CACHE_NAME, key = "#context.sessionId")
    public BaseContext<UserContext> put(BaseContext<UserContext> context) {
        return context;
    }

    // remove session from cache
    @CacheEvict(cacheNames = CACHE_NAME, key = "#sessionId")
    public void remove(String sessionId) {
    }

}
