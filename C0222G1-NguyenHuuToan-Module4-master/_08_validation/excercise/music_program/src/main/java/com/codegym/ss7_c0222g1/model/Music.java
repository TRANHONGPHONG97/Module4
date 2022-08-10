package com.codegym.ss7_c0222g1.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="song_id")
    private Integer id;

    @Column(name = "name_music")
    @NotBlank(message = "Can't blank or empty")
    private String nameMusic;

    @Column(name = "name_artist")
    @NotBlank(message = "Can't blank or empty")
    private String nameArtist;

    @Column(name = "song_type")
    @NotBlank(message = "Can't blank or empty")
    private String type;

    @Column(name = "song_url")
    @NotBlank(message = "Can't blank or empty")
    private String url;

    public Music() {
    }

    public Music(Integer id, String nameMusic, String nameArtist, String type, String url) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.nameArtist = nameArtist;
        this.type = type;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}