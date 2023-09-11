package com.bloom.pium.service;

import com.bloom.pium.data.entity.Matching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchingService {

    List<Matching> getParticipateList();
}
