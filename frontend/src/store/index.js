import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
// module import
import memberStore from "@/store/modules/memberStore";
import sidogugunStore from "@/store/modules/sidogugunStore";

Vue.use(Vuex);

export default new Vuex.Store({
  state:{
    user: null,
    accessToken:null
  },
  modules: {
    memberStore,
    sidogugunStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
  mutations: {
    setUser(state, user) {
      state.user = user;
    },
    clearUser(state) {
      state.user = null;
    },
    setAccessToken(state, accessToken) {
      state.accessToken = accessToken;
    },
    clearAccessToken(state) {
      state.accessToken = null;
    }
  },
});
