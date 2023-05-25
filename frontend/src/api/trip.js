import { tripInstance } from "@/api/index.js";

const api = tripInstance();

function searchAllTrip(success, fail) {
  api.get(`/trip/search`).then(success).catch(fail);
}

function searchTrip(params, success, fail) {
  api.post(`/trip/search`, JSON.stringify(params)).then(success).catch(fail);
}

  export { searchAllTrip, searchTrip };
