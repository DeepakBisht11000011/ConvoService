package com.deepweb.convo.service.impl;

import com.deepweb.convo.constants.DurationUnit;
import com.deepweb.convo.constants.RecordType;
import com.deepweb.convo.constants.UserType;
import com.deepweb.convo.entities.*;
import com.deepweb.convo.exception.ConvoRecordConversionException;
import com.deepweb.convo.service.RecordConverterService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NetflixRecordConverterService implements RecordConverterService {
    @Override
    public boolean convert(String[] values) throws ConvoRecordConversionException {
        if (values.length == 0) {
            return false;
        }
        try {
            NetflixEntryModel entryModel = new NetflixEntryModel();
            String showId = values[0].trim().substring(1);
            long id = Long.parseLong(showId);
            entryModel.setId(id);
            entryModel.setShowId(showId);
            entryModel.setType(getRecordType(values[1]));
            entryModel.setTitle(values[2].trim());
            entryModel.setDirector(getUsers(values[3], UserType.DIRECTOR));
            entryModel.setCast(getUsers(values[4], UserType.CAST));
            entryModel.setCountry(getCountries(values[5]));
            entryModel.setDateAdded(getDate(values[6]));
            entryModel.setReleaseYear(values[7]);
            entryModel.setRating(getRating(values[8]));
            entryModel.setDurationM(getDurationModel(values[9]));
            entryModel.setListedIn(getListedInList(values[10]));
            entryModel.setDescription(values[11]);
        } catch (Exception exp) {
            throw new ConvoRecordConversionException(exp.getMessage(), exp);
        }
        return true;
    }

    private DurationModel getDurationModel(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        DurationModel durationModel = null;
        if (durationModel == null) {
            String[] duration = value.trim().split(" ");
            durationModel = new DurationModel();
            Long durationMode = Long.parseLong(duration[0].trim());

            durationModel.setDuration(durationMode);
            if (duration[1].trim().toLowerCase().contains(DurationUnit.MIN.getLabel().toLowerCase())) {
                durationModel.setUnit(DurationUnit.MIN);
            } else {
                durationModel.setUnit(DurationUnit.SEASON);
            }
        }
        return durationModel;
    }

    private RatingModel getRating(String value) {
        RatingModel rating = null;
        if (rating == null) {
            rating = new RatingModel();
            rating.setName(value);
        }
        return rating;
    }

    private Date getDate(String value) {
        String pattern = "MMM dd, YYYY";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(value);
        } catch (ParseException exp) {
            return null;
        }
    }

    private List<GenreModel> getListedInList(String value) {
        if (value == null || value.isBlank()) {
            return null;
        } else {
            List<GenreModel> genreModels = new ArrayList<>();
            if (value.contains(",")) {
                String[] vals = value.split(",");
                genreModels.addAll(Arrays.stream(vals).map(this::getGenre).toList());
            } else {
                genreModels.add(getGenre(value));
            }
            return genreModels;
        }
    }

    private GenreModel getGenre(String value) {
        GenreModel genreModel = null;
        if (genreModel == null) {
            genreModel = new GenreModel();
            genreModel.setName(value);
        }
        return genreModel;
    }

    private List<UserModel> getUsers(String value, UserType userType) {
        if (value == null || value.isBlank()) {
            return null;
        } else {
            List<UserModel> users = new ArrayList<>();
            if (value.contains(",")) {
                String[] userArray = value.split(",");
                users.addAll(Arrays.stream(userArray).map(it -> getSingleUser(it, userType)).toList());
            } else {
                users.add(getSingleUser(value, userType));
            }
            return users;
        }
    }

    private UserModel getSingleUser(String value, UserType userType) {
        UserModel user = null;
        //getUser from DB.
        if (user == null) {
            user = new UserModel();
            String[] names = value.split(" ", 2);
            if (!names[0].isBlank()) {
                user.setFirstName(names[0]);
            }
            if (names.length > 1 && !names[1].isBlank()) {
                user.setLastName(names[1]);
            }
            user.setUserType(userType);
        }
        return user;
    }


    private List<CountryModel> getCountries(String value) {
        if (value == null || value.isBlank()) {
            return null;
        } else {
            List<CountryModel> countries = new ArrayList<>();
            if (value.contains(",")) {
                String[] countryArray = value.split(",");
                countries.addAll(Arrays.stream(countryArray).map(this::getSingleCountry).toList());
            } else {
                countries.add(getSingleCountry(value));
            }
            return countries;
        }
    }

    private CountryModel getSingleCountry(String value) {
        CountryModel country = null;
        //getUser from DB.
        if (country == null) {
            country = new CountryModel();
        }
        return country;
    }


    private RecordType getRecordType(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else if (value.toLowerCase().contains(RecordType.MOVIE.getLabel().toLowerCase())) {
            return RecordType.MOVIE;
        } else {
            return RecordType.TV_Show;
        }
    }
}
