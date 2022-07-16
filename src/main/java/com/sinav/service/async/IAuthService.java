package com.sinav.service.async;

import com.sinav.dto.UserDto;

import java.util.Map;

public interface IAuthService {
    public Map<String, String> authToken(UserDto dto);
}
