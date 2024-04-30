package publicservicedesign.service;

import java.util.List;
import java.util.Optional;

import publicservicedesign.domain.Analysis1;

public interface Analysis1Service {
    List<Analysis1> getAllAnalysis1s() throws Exception;

    Optional<Analysis1> getAnalysis1ById(String complaintType) throws Exception;

    Analysis1 createAnalysis1(Analysis1 analysis1) throws Exception;

    Analysis1 updateAnalysis1(Analysis1 analysis1) throws Exception;

    void deleteAnalysis1(String complaintType) throws Exception;
}
