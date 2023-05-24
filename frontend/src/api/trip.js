import { apiInstance } from "@/api/index.js";

const api = apiInstance();

function sidoList(success, fail) {
    api.get(`/trip/sido`).then(success).catch(fail);
  }
  
  function gugunList(sidoCode, success, fail) {
    api.get(`/trip/gugun/${sidoCode}`).then(success).catch(fail);
  }
  export { sidoList, gugunList };
