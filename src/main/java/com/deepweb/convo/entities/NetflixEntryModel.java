package com.deepweb.convo.entities;

import com.deepweb.convo.constants.DurationUnit;
import com.deepweb.convo.constants.RecordType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NetflixEntryModel {
    private Long id;
    private String showId;
    private RecordType type;
    private String title;
    private List<UserModel> director;
    private List<UserModel> cast;
    private List<CountryModel> country;
    private Date dateAdded;
    private String releaseYear;
    private RatingModel rating;
    private Long duration;
    private DurationUnit durationUnit;
    private DurationModel durationM;
    private List<GenreModel> listedIn;
    private String description;
}
