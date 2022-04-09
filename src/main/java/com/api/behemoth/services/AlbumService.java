package com.api.behemoth.services;

import com.api.behemoth.models.AlbumModel;
import com.api.behemoth.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    @Transactional
    public AlbumModel save(AlbumModel albumModel) {
        return albumRepository.save(albumModel);
    }

    public Page<AlbumModel> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    public Optional<AlbumModel> findById(UUID id) {
        return albumRepository.findById(id);
    }
}
