package com.api.behemoth.dtos;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class TrackDto {

    @NotBlank
    private String title;
//    @NotBlank
//    private String artist;
    @NotNull
    private UUID album;

}
