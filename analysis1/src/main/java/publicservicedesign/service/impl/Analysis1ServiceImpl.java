package publicservicedesign.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import publicservicedesign.domain.Analysis1;
import publicservicedesign.domain.Analysis1Repository;
import publicservicedesign.service.Analysis1Service;

@Service("analysis1Service")
@Transactional
public class Analysis1ServiceImpl
        extends EgovAbstractServiceImpl
        implements Analysis1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            Analysis1ServiceImpl.class);

    @Autowired
    Analysis1Repository analysis1Repository;

    @Override
    public List<Analysis1> getAllAnalysis1s() throws Exception {
        // Get all analysis1s
        return StreamSupport
                .stream(analysis1Repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Analysis1> getAnalysis1ById(String complaintType)
            throws Exception {
        // Get a analysis1 by ID
        return analysis1Repository.findById(complaintType);
    }

    @Override
    public Analysis1 createAnalysis1(Analysis1 analysis1) throws Exception {
        // Create a new analysis1
        return analysis1Repository.save(analysis1);
    }

    @Override
    public Analysis1 updateAnalysis1(Analysis1 analysis1) throws Exception {
        // Update an existing analysis1 via Analysis1Service
        if (analysis1Repository.existsById(analysis1.getComplaintType())) {
            return analysis1Repository.save(analysis1);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteAnalysis1(String complaintType) throws Exception {
        // Delete a analysis1
        analysis1Repository.deleteById(complaintType);
    }
}
