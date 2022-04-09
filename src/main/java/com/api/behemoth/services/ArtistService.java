package com.api.behemoth.services;

import com.api.behemoth.models.ArtistModel;
import com.api.behemoth.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Transactional
    public ArtistModel save(ArtistModel artistModel) {
        return artistRepository.save(artistModel);
    }

    public Page<ArtistModel> findAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

    public Optional<ArtistModel> findById(UUID id) {
        return artistRepository.findById(id);
    }
}
