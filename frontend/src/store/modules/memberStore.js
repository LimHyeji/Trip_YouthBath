// import jwtDecode from "jwt-decode";
// import router from "@/router";
import { login } from "@/api/member";

const memberStore = {
    namespaced: true,
    state: {
        isLogin: false,
        isLoginError: false,
        memberInfo: null,
        isValidToken:false,
    },
    getters: {
        checkMemberInfo: function (state) {
            return state.memberInfo;
        },
        checkToken: function (state) {
            return state.isValidToken;
        },
    },
    mutations: {
        SET_IS_LOGIN: (state, isLogin) => {
            state.isLogin = isLogin;
        },
        SET_IS_LOGIN_ERROR: (state, isLoginError) => {
            state.isLoginError = isLoginError;
          },
        SET_IS_VALID_TOKEN: (state, isValidToken) => {
            state.isValidToken = isValidToken;
          },
        SET_MEMBER_INFO: (state, memberInfo) => {
            state.isLogin = true;
            state.memberInfo = memberInfo;
          },
    },
    action: {
        async memberConfirm({ commit },member) {
            await login(
                member,
                ({ data }) => {
                    if (data.message === "success") {
                        let accessToken = data["access-token"];
                        //리프레쉬 토큰 사용 미정
                        commit("SET_IS_LOGIN", true);
                        commit("SET_IS_LOGIN_ERROR", false);
                        commit("SET_IS_VALID_TOKEN", true);
                        sessionStorage.setItem("access-token", accessToken);
                    } else {
                        commit("SET_IS_LOGIN", false);
                        commit("SET_IS_LOGIN_ERROR", true);
                        commit("SET_IS_VALID_TOKEN", false);
                    }
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        //findById 이용,,,, getMemberInfo
    }
}

export default memberStore;