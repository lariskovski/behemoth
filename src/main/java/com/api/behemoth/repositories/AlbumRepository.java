package com.api.behemoth.repositories;

import com.api.behemoth.models.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<AlbumModel, UUID> {
}
