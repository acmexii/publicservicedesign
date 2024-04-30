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
import publicservicedesign.domain.Analysis2;
import publicservicedesign.domain.Analysis2Repository;
import publicservicedesign.service.Analysis2Service;

@Service("analysis2Service")
@Transactional
public class Analysis2ServiceImpl
    extends EgovAbstractServiceImpl
    implements Analysis2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        Analysis2ServiceImpl.class
    );

    @Autowired
    Analysis2Repository analysis2Repository;

    @Override
    public List<Analysis2> getAllAnalysis2s() throws Exception {
        // Get all analysis2s
        return StreamSupport
            .stream(analysis2Repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Analysis2> getAnalysis2ById(Long id) throws Exception {
        // Get a analysis2 by ID
        return analysis2Repository.findById(id);
    }

    @Override
    public Analysis2 createAnalysis2(Analysis2 analysis2) throws Exception {
        // Create a new analysis2
        return analysis2Repository.save(analysis2);
    }

    @Override
    public Analysis2 updateAnalysis2(Analysis2 analysis2) throws Exception {
        // Update an existing analysis2 via Analysis2Service
        if (analysis2Repository.existsById(analysis2.getId())) {
            return analysis2Repository.save(analysis2);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteAnalysis2(Long id) throws Exception {
        // Delete a analysis2
        analysis2Repository.deleteById(id);
    }
}
