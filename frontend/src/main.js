 /*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from './router';
Vue.config.productionTip = false;
require('./GlobalStyle.css');

const axios = require("axios").default;

// backend host url
axios.backend = null; //"http://localhost:8088";

// axios.backendUrl = new URL(axios.backend);
axios.fixUrl = function(original){

  if(!axios.backend && original.indexOf("/")==0) return original;

  var url = null;

  try{
    url = new URL(original);
  }catch(e){
    url = new URL(axios.backend + original);
  }

  if(!axios.backend) return url.pathname;

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
}

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function(tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = []

pluralCaseList.push( {plural: "applications/applications", pascal: "ApplicationApplication"} )

pluralCaseList.push( {plural: "process1s/investigations", pascal: "Process1Investigation"} )
pluralCaseList.push( {plural: "process1s/processings", pascal: "Process1Processing"} )

pluralCaseList.push( {plural: "process2s/minwonType2s", pascal: "Process2MinwonType2"} )

pluralCaseList.push( {plural: "compensations/rewardApplications", pascal: "CompensationRewardApplication"} )
pluralCaseList.push( {plural: "compensations/compensationPayments", pascal: "CompensationCompensationPayment"} )

pluralCaseList.push( {plural: "analysis1s/analysis1s", pascal: "Analysis1Analysis1"} )

pluralCaseList.push( {plural: "analysis2s/analysis2s", pascal: "Analysis2Analysis2"} )



Vue.prototype.$ManagerLists.forEach(function(item, idx) {
  pluralCaseList.forEach(function(tmp) {
    if(item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural
      }
      Vue.prototype.$ManagerLists[idx] = obj
    }
  })
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
