package com.deepweb.convo.service;

import com.deepweb.convo.entities.NetflixEntryModel;

import java.util.List;

public interface NetflixService {

    List<NetflixEntryModel> findAllRecordsPaginated(int pageNo);
    List<NetflixEntryModel> findByGenre(String genreStr,int pageNo);
    List<NetflixEntryModel> search(String param1,String param2,int pageNo);
}
