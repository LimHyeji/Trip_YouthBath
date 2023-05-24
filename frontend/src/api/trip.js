import { tripInstance } from "@/api/index.js";

const api = tripInstance();

function searchTrip(params, success, fail) {
  api.post(`/trip/search`, JSON.stringify(params)).then(success).catch(fail);
}

  export { searchTrip };
