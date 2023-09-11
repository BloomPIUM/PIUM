package com.bloom.pium.service.impl;

import com.bloom.pium.data.entity.Matching;
import com.bloom.pium.data.repository.MatchingRepository;
import com.bloom.pium.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingServiceImpl  implements MatchingService {

    @Autowired
    private MatchingRepository matchingRepository;


    @Override
    public List<Matching> getParticipateList() {
        return matchingRepository.findByParticipateTrue();
    }


}
