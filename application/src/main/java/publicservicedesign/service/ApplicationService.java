package publicservicedesign.service;

import java.util.List;
import java.util.Optional;
import publicservicedesign.domain.*;

public interface ApplicationService {
    List<Application> getAllApplications() throws Exception;
    Optional<Application> getApplicationById(String 민원번호) throws Exception;
    Application createApplication(Application application) throws Exception;
    Application updateApplication(Application application) throws Exception;
    void deleteApplication(String 민원번호) throws Exception;
}
