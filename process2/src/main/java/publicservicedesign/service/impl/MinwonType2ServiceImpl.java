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
import publicservicedesign.domain.MinwonType2;
import publicservicedesign.domain.MinwonType2Repository;
import publicservicedesign.domain.UpdateMinwonType2Command;
import publicservicedesign.service.MinwonType2Service;

@Service("minwonType2Service")
@Transactional
public class MinwonType2ServiceImpl
    extends EgovAbstractServiceImpl
    implements MinwonType2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        MinwonType2ServiceImpl.class
    );

    @Autowired
    MinwonType2Repository minwonType2Repository;

    @Override
    public List<MinwonType2> getAllMinwonType2s() throws Exception {
        // Get all minwonType2s
        return StreamSupport
            .stream(minwonType2Repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<MinwonType2> getMinwonType2ById(String name)
        throws Exception {
        // Get a minwonType2 by ID
        return minwonType2Repository.findById(name);
    }

    @Override
    public MinwonType2 createMinwonType2(MinwonType2 minwonType2)
        throws Exception {
        // Create a new minwonType2
        return minwonType2Repository.save(minwonType2);
    }

    @Override
    public MinwonType2 updateMinwonType2(MinwonType2 minwonType2)
        throws Exception {
        // Update an existing minwonType2 via MinwonType2Service
        if (minwonType2Repository.existsById(minwonType2.getName())) {
            return minwonType2Repository.save(minwonType2);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteMinwonType2(String name) throws Exception {
        // Delete a minwonType2
        minwonType2Repository.deleteById(name);
    }

    @Override
    public MinwonType2 updateMinwonType2(
        UpdateMinwonType2Command updateMinwonType2Command
    ) throws Exception {
        // You can implement logic here, or call the domain method of the MinwonType2.

        /** Choice 1:  implement logic here        
        Optional<MinwonType2> optionalMinwonType2 = minwonType2Repository.findById(updateMinwonType2Command.getMinwonType2Id());

        if (optionalMinwonType2.isPresent()) {
            MinwonType2 minwonType2 = optionalMinwonType2.get();
            
            // business Logic....
            minwonType2Repository.save(minwonType2);

            return minwonType2;
        } else {
            throw processException("info.nodata.msg");
        }
       

        /** Choice 2:  call the domain method of the MinwonType2.   
        return MinwonType2.updateMinwonType2(updateMinwonType2Command);
           */
        return null;
    }
}
