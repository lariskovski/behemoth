package com.api.behemoth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "albumId")
@Data
@Entity
@Table(name = "TB_ALBUM")
public class AlbumModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID albumId;

    @Column(nullable = false)
    private String coverUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 70)
    private String releaseYear;

    @OneToMany(mappedBy = "album")
    private List<TrackModel> tracks;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "artistId")
    private ArtistModel artist;
}
