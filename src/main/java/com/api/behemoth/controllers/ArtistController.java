package com.api.behemoth.controllers;

import com.api.behemoth.dtos.ArtistDto;
import com.api.behemoth.dtos.TrackDto;
import com.api.behemoth.models.ArtistModel;
import com.api.behemoth.models.TrackModel;
import com.api.behemoth.services.AlbumService;
import com.api.behemoth.services.ArtistService;
import com.api.behemoth.services.TrackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @PostMapping
    public ResponseEntity<ArtistModel> saveTrack(@RequestBody @Valid ArtistDto artistDto){
        ArtistModel artistModel = new ArtistModel();
        BeanUtils.copyProperties(artistDto, artistModel);
        artistModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        // The get method on Optional gets the entity
        // artistModel.setAlbum(albumService.findById(trackDto.getAlbum()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.save(artistModel));
        // return new ResponseEntity<>(trackModel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ArtistModel>> getAllTracks(@PageableDefault(page = 0, size = 10, sort = "artistId", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(artistService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<ArtistModel> trackModelOptional = artistService.findById(id);
        if (!trackModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trackModelOptional.get());
    }
}
