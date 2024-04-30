package publicservicedesign.service;

import java.util.List;
import java.util.Optional;
import publicservicedesign.domain.*;

public interface MinwonType2Service {
    List<MinwonType2> getAllMinwonType2s() throws Exception;
    Optional<MinwonType2> getMinwonType2ById(String name) throws Exception;
    MinwonType2 createMinwonType2(MinwonType2 minwonType2) throws Exception;
    MinwonType2 updateMinwonType2(MinwonType2 minwonType2) throws Exception;
    void deleteMinwonType2(String name) throws Exception;

    MinwonType2 updateMinwonType2(
        UpdateMinwonType2Command updateMinwonType2Command
    ) throws Exception;
}
