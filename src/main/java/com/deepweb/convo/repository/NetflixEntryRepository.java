package com.deepweb.convo.repository;

import com.deepweb.convo.entities.NetflixEntryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NetflixEntryRepository extends MongoRepository<NetflixEntryModel,Long> {
}
