import axios from "axios";
import store from "@/store/index.js";

// local vue api axios instance
function apiInstance() {
    const instance = axios.create({
      baseURL: process.env.VUE_APP_API_BASE_URL,
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
    });
    return instance;
}
  
function apiToCheckInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
      Authorization:store.state.access-token,
    },
  });
  return instance;
}
  
  // trip deal API axios instance
  function tripInstance() {
    const instance = axios.create({
      baseURL: process.env.VUE_APP_TRIP_DEAL_URL,
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization:store.state.access-token,
      },
    });
    return instance;
  }
  
  export { apiInstance, apiToCheckInstance, tripInstance };
  