import { apiInstance } from "./index.js";

const api = apiInstance();

function writeArticle(article, success, fail) {
    api.post(`/board`, JSON.stringify(article)).then(success).catch(fail);
}
  
function listArticle(param, success, fail) {
  api.get(`/board`, { params: param }).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  api.post(`/board/modify`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleNo, success, fail) {
  api.post(`/board/delete`, JSON.stringify(articleNo)).then(success).catch(fail);
}

function detailArticle(articleNo, success, fail) {
    api.get(`/board/${articleNo}`).then(success).catch(fail);
  }

export { writeArticle, listArticle, modifyArticle, deleteArticle, detailArticle };
