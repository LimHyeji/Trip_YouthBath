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
 console.log("저장된 토큰 : " + store.state.accessToken);
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    withCredentials:true,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
      'Authorization':`Bearer ${store.state.accessToken}`,
    },
  });
  return instance;
}
  
  // trip deal API axios instance
function tripInstance() {
  console.log("저장된 토큰 : " + store.state.accessToken);
    const instance = axios.create({
      baseURL: process.env.VUE_APP_API_BASE_URL,
      withCredentials:true,
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        'Authorization':`Bearer ${store.state.accessToken}`,
      },
    });
    return instance;
  }
  
  export { apiInstance, apiToCheckInstance, tripInstance };
  