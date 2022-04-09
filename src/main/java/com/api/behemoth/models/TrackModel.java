package com.api.behemoth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "trackId")
@Data
@Entity
@Table(name = "TB_TRACK")
public class TrackModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID trackId;

    @Column(nullable = false, length = 70)
    private String title;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "albumId")
    private AlbumModel album;
}
