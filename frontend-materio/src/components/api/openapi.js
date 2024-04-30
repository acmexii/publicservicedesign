import applicationYaml from "./application-openapi.yaml";
import investigationYaml from "./investigation-openapi.yaml";
import processingYaml from "./processing-openapi.yaml";
import minwonType2Yaml from "./minwonType2-openapi.yaml";
import rewardApplicationYaml from "./rewardApplication-openapi.yaml";
import compensationPaymentYaml from "./compensationPayment-openapi.yaml";
import analysis1Yaml from "./analysis1-openapi.yaml";
import analysis2Yaml from "./analysis2-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let applicationSpec = YAML.stringify(applicationYaml);
apiSpec += applicationSpec;

let investigationSpec = YAML.stringify(investigationYaml);
apiSpec += investigationSpec;

let processingSpec = YAML.stringify(processingYaml);
apiSpec += processingSpec;

let minwonType2Spec = YAML.stringify(minwonType2Yaml);
apiSpec += minwonType2Spec;

let rewardApplicationSpec = YAML.stringify(rewardApplicationYaml);
apiSpec += rewardApplicationSpec;

let compensationPaymentSpec = YAML.stringify(compensationPaymentYaml);
apiSpec += compensationPaymentSpec;

let analysis1Spec = YAML.stringify(analysis1Yaml);
apiSpec += analysis1Spec;

let analysis2Spec = YAML.stringify(analysis2Yaml);
apiSpec += analysis2Spec;


export default apiSpec;