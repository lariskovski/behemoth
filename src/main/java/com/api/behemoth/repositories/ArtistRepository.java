package com.api.behemoth.repositories;

import com.api.behemoth.models.ArtistModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistRepository extends JpaRepository<ArtistModel, UUID> {
}
