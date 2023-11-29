package com.deepweb.convo.repository;

import com.deepweb.convo.entities.NetflixEntryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NetflixEntryRepository extends MongoRepository<NetflixEntryModel,Long> {

    @Override
    Page<NetflixEntryModel> findAll(Pageable pageable);

    @Query("{ listedIn: { $elemMatch: { name: { $regex: ?0 } } } }")
    Page<NetflixEntryModel> findByListedIn(String genreStr,Pageable pageable);
}
