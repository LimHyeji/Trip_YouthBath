import { apiInstance, apiToCheckInstance } from "@/api/index.js";

const api = apiInstance();
const apiToCheck = apiToCheckInstance();

async function regist(user, success, fail) {
    await api.post(`/user/regist`,
        JSON.stringify(user)).then(success).catch(fail);
}

async function login(user, success, fail) {
    await api.post(`/user/login`,
        JSON.stringify(user)).then(success).catch(fail);
}

export { regist, login };