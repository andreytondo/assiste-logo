package com.github.andreytondo.api.show;

import com.github.andreytondo.api.show.season.Season;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Show {

    private Integer id;
    private String name;
    private String description;
    private String cover;
    private boolean adult;
    private LocalDate releaseDate;
    private List<Season> seasons;
    private String backdrop;
}
