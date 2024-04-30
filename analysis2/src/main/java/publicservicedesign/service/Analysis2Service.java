package publicservicedesign.service;

import java.util.List;
import java.util.Optional;
import publicservicedesign.domain.*;

public interface Analysis2Service {
    List<Analysis2> getAllAnalysis2s() throws Exception;
    Optional<Analysis2> getAnalysis2ById(Long id) throws Exception;
    Analysis2 createAnalysis2(Analysis2 analysis2) throws Exception;
    Analysis2 updateAnalysis2(Analysis2 analysis2) throws Exception;
    void deleteAnalysis2(Long id) throws Exception;
}
