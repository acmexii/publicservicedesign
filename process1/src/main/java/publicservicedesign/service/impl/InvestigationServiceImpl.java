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

import publicservicedesign.domain.Investigation;
import publicservicedesign.domain.InvestigationRepository;
import publicservicedesign.domain.UpdateInvestigationCommand;
import publicservicedesign.service.InvestigationService;

@Service("investigationService")
@Transactional
public class InvestigationServiceImpl
        extends EgovAbstractServiceImpl
        implements InvestigationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            InvestigationServiceImpl.class);

    @Autowired
    InvestigationRepository investigationRepository;

    @Override
    public List<Investigation> getAllInvestigations() throws Exception {
        // Get all investigations
        return StreamSupport
                .stream(investigationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Investigation> getInvestigationById(String name)
            throws Exception {
        // Get a investigation by ID
        return investigationRepository.findById(name);
    }

    @Override
    public Investigation createInvestigation(Investigation investigation)
            throws Exception {
        // Create a new investigation
        return investigationRepository.save(investigation);
    }

    @Override
    public Investigation updateInvestigation(Investigation investigation)
            throws Exception {
        // Update an existing investigation via InvestigationService
        if (investigationRepository.existsById(investigation.getName())) {
            return investigationRepository.save(investigation);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteInvestigation(String name) throws Exception {
        // Delete a investigation
        investigationRepository.deleteById(name);
    }

    @Override
    public Investigation updateInvestigation(
            UpdateInvestigationCommand updateInvestigationCommand) throws Exception {
        // You can implement logic here, or call the domain method of the Investigation.

        /** Choice 1: implement logic here */
        Optional<Investigation> optionalInvestigation = investigationRepository
                .findById(updateInvestigationCommand.getInvestigationId());

        if (optionalInvestigation.isPresent()) {
            Investigation investigation = optionalInvestigation.get();

            investigation.updateInvestigation(updateInvestigationCommand);
            investigationRepository.save(investigation);

            return investigation;
        } else {
            throw processException("info.nodata.msg");
        }

    }
}
