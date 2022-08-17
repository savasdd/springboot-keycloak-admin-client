package com.sinav.service.async;

import com.sinav.model.UserGorev;
import com.sinav.model.UserGorevView;

import java.util.List;

public interface IUserGorev {
    public UserGorev create(UserGorev dto);

    public List<UserGorevView> getAllMimPersonel();

    public void addAraGorev();

}
