package com.github.andreytondo.api.show.season;

import com.github.andreytondo.api.show.Show;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Season {

    private Integer id;
    private Show show;
    private Integer episodes;
    private LocalDate aired;
    private String name;

}
