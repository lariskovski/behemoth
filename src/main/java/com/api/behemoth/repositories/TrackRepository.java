package com.api.behemoth.repositories;

import com.api.behemoth.models.TrackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<TrackModel, UUID> {
}
