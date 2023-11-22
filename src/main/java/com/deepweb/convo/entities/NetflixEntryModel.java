package com.deepweb.convo.entities;

import com.deepweb.convo.constants.DurationUnit;
import com.deepweb.convo.constants.RecordType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@ToString
@Setter
@Document("netflixentry")
public class NetflixEntryModel {
    @Id
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
