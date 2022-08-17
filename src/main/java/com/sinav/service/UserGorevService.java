package com.sinav.service;

import com.sinav.service.async.IUserGorev;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class UserGorevService {

    private final IUserGorev gorev;
}
