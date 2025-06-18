package detectors;

import java.util.HashMap;
import java.util.Map;

import edu.memphis.ccrg.lida.pam.tasks.BasicDetectionAlgorithm;
import ws3dproxy.model.Thing;

public class LeafletStatusDetector extends BasicDetectionAlgorithm {

    private final String modality = "";
    private Map<String, Object> detectorParams = new HashMap<>();

    @Override
    public void init() {
        super.init();
        detectorParams.put("mode", "leafletStatus");
    }

    @Override
    public double detect() {
        @SuppressWarnings("unchecked")
        Map<Long, Boolean> leafletStatus = (Map<Long, Boolean>) sensoryMemory.getSensoryContent(modality, detectorParams);

        double activation = 0.0;

        if (leafletStatus != null) {
            boolean anyTrue = leafletStatus.values().stream().anyMatch(Boolean::booleanValue);

            if (anyTrue) {
                activation = 1.0;
            }
        }

        return activation;
    }
}
