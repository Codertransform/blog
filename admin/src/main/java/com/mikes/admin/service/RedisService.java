package com.mikes.admin.service;

import java.util.Map;

public interface RedisService {

    Map<String, Object> addKeyValue(String username, String layid, String href, String title);
}
