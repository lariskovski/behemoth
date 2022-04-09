package com.api.behemoth.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_ARTIST")
public class ArtistModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID artistId;
    @Column(nullable = false, length = 70)
    private String name;
    @Column(nullable = false)
    private Integer followers;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "artist")
    private List<AlbumModel> albums;
}
