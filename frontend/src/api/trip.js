import { apiToCheckInstance } from "@/api/index.js";

const api = apiToCheckInstance();

  
function searchTrip(params, success, fail) {
  api.post(`/trip/search`, JSON.stringify(params)).then(success).catch(fail);
}

  export { searchTrip };
