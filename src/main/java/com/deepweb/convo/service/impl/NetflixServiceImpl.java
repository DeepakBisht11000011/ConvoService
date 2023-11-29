package com.deepweb.convo.service.impl;

import com.deepweb.convo.entities.NetflixEntryModel;
import com.deepweb.convo.repository.NetflixEntryRepository;
import com.deepweb.convo.service.NetflixService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetflixServiceImpl implements NetflixService {
    private static final Logger Log = LoggerFactory.getLogger(NetflixServiceImpl.class);

    @Autowired
    private NetflixEntryRepository netflixEntryRepo;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<NetflixEntryModel> findAllRecordsPaginated(int pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 20);
        Page<NetflixEntryModel> page = netflixEntryRepo.findAll(pageable);
        return page.toList();
    }

    @Override
    public List<NetflixEntryModel> findByGenre(String genreStr, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 20);
        Page<NetflixEntryModel> page = netflixEntryRepo.findByListedIn(genreStr, pageable);
        return page.toList();
    }

    @Override
    public List<NetflixEntryModel> search(String param1, String param2, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 20);
        Query query = new Query().with(pageable);
        List<Criteria> criteriaExpr = new ArrayList<>();
        if (StringUtils.isNoneEmpty(param1)) {
            criteriaExpr.add(Criteria.where("type").is(param1));
        }
        if (StringUtils.isNoneEmpty(param2)) {
            criteriaExpr.add(Criteria.where("listedIn")
                    .elemMatch(Criteria.where("name").regex(param2)));
        }
        query.addCriteria(new Criteria().andOperator(criteriaExpr));
        List<NetflixEntryModel> list = mongoTemplate.find(query, NetflixEntryModel.class);
        return PageableExecutionUtils.getPage(
                list,
                pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), NetflixEntryModel.class)).toList();
    }
}
