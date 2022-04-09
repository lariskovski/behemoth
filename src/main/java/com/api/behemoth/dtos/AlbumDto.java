package com.api.behemoth.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class AlbumDto {

    @NotBlank
    private String title;
    @NotBlank
    private String coverUrl;
    @NotBlank
    private String releaseYear;
    @NotNull
    private UUID artist;
}
