package com.api.behemoth.services;

import com.api.behemoth.models.TrackModel;
import com.api.behemoth.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrackService {
    @Autowired
    TrackRepository trackRepository;

    @Transactional
    public TrackModel save(TrackModel trackModel) {
        return trackRepository.save(trackModel);
    }

    public Page<TrackModel> findAll(Pageable pageable) {
        return trackRepository.findAll(pageable);
    }

    public Optional<TrackModel> findById(UUID id) {
        return trackRepository.findById(id);
    }
}
