package com.api.behemoth.controllers;

import com.api.behemoth.dtos.AlbumDto;
import com.api.behemoth.models.AlbumModel;
import com.api.behemoth.services.AlbumService;
import com.api.behemoth.services.ArtistService;
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
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @Autowired
    ArtistService artistService;

    @PostMapping
    public ResponseEntity<AlbumModel> saveTrack(@RequestBody @Valid AlbumDto albumDto){

        AlbumModel albumModel = new AlbumModel();
        BeanUtils.copyProperties(albumDto, albumModel);
        albumModel.setArtist(artistService.findById(albumDto.getArtist()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.save(albumModel));
    }

    @GetMapping
    public ResponseEntity<Page<AlbumModel>> getAllTracks(@PageableDefault(page = 0, size = 10, sort = "albumId", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<AlbumModel> albumModelOptional = albumService.findById(id);
        if (!albumModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(albumModelOptional.get());
    }
}
