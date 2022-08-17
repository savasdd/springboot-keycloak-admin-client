package com.sinav.service.impl;

import com.sinav.model.UserAraGorev;
import com.sinav.model.UserGorev;
import com.sinav.model.UserGorevView;
import com.sinav.repository.UserAraGorevRepository;
import com.sinav.repository.UserGorevRepository;
import com.sinav.repository.UserGorevViewRepository;
import com.sinav.service.async.IUserGorev;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserGorevServiceImpl implements IUserGorev {

    private final UserGorevRepository repository;
    private final UserGorevViewRepository view;
    private final UserAraGorevRepository gorev;

    @Override
    public UserGorev create(UserGorev dto) {
        log.info("Create Görev");
        return repository.save(dto);
    }


    @Override
    public List<UserGorevView> getAllMimPersonel() {
        List<UserGorevView> personelList = new ArrayList<>();
        List<UserGorevView> list = view.findAll();
        if (list.size() > 0) {
            for (UserGorevView m : list) {
                UserGorevView personel = getMaxPersonel(m);
                if (personel != null) {
                    personelList.add(personel);
                }
            }
        }
        log.info("MIM Personel: " + personelList.size());
        return personelList;
    }

    @Override
    public void addAraGorev() {
        List<UserGorevView> list = view.findAll();
        if (list.size() > 0) {
            gorev.deleteAll();
            for (UserGorevView m : list) {
                UserGorevView personel = getMaxPersonel(m);//m.getSeviyeKodu().replaceAll("\\.", "");
                if (personel != null) {
                    addAraGorev(personel);
                }
            }
        }
    }

    public UserGorevView getMaxPersonel(UserGorevView dto) {
        List<Long> listSeviye = view.getByTc(dto.getTc());
        Long minSeviye = listSeviye.stream().mapToLong(v -> v).min().orElseThrow(NoSuchElementException::new);
        int count = 0;
        for (Long v : listSeviye) {
            if (v == minSeviye)
                count++;
        }

        if (count > 1) {
            if (dto.getSeviyeSize() == minSeviye && (dto.getAsil() != null && dto.getAsil()))
                return dto;
        } else {
            if (dto.getSeviyeSize() == minSeviye)
                return dto;
        }
        return null;
    }

    public void addAraGorev(UserGorevView dto) {
        UserAraGorev araGorev = new UserAraGorev();
        araGorev.setGorevId(dto.getGorevId());
        araGorev.setAd(dto.getAd());
        araGorev.setSoyad(dto.getSoyad());
        araGorev.setBirim(dto.getBirim());
        araGorev.setSeviye(dto.getSeviye());
        araGorev.setTc(dto.getTc());
        araGorev.setAsil(dto.getAsil());
        gorev.save(araGorev);
        log.info("Add Ara Gorev!");
    }
}
