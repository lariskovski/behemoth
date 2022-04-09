package com.api.behemoth.dtos;


import com.api.behemoth.models.AlbumModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ArtistDto {

    @NotBlank
    private String name;
    @NotNull
    private Integer followers;

}
