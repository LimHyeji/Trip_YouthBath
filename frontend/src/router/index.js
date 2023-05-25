import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain";
import http from '@/api/http';
import parser from '@/api/lib/responseParser';
import store from '@/store/index';

Vue.use(VueRouter);

// // https://v3.router.vuejs.org/kr/guide/advanced/navigation-guards.html
// const onlyAuthUser = async (to, from, next) => {
//   const checkUserInfo = store.getters["memberStore/checkUserInfo"];
//   const checkToken = store.getters["memberStore/checkToken"];
//   let token = sessionStorage.getItem("access-token");
//   console.log("로그인 처리 전", checkUserInfo, token);

//   if (checkUserInfo != null && token) {
//     console.log("토큰 유효성 체크하러 가자!!!!");
//     await store.dispatch("memberStore/getUserInfo", token);
//   }
//   if (!checkToken || checkUserInfo === null) {
//     alert("로그인이 필요한 페이지입니다..");
//     // next({ name: "login" });
//     router.push({ name: "login" });
//   } else {
//     console.log("로그인 했다!!!!!!!!!!!!!.");
//     next();
//   }
// };

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/member",
    name: "member",
    component: () => import(/* webpackChunkName: "member" */ "@/views/AppMember"),
    children: [
      {
        path: "regist",
        name: "regist",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberRegist"),
      },
      {
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberLogin"),
      },
      {
        path: "mypage",
        name: "mypage",
        //beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberMyPage"),
      },
      {
        path: "update",
        name: "update",
        //beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberUpdate"),
      },
    ],
  },
  {
    path: "/board",
    name: "board",
    component: () => import(/* webpackChunkName: "board" */ "@/views/AppBoard"),
    children: [
      {
        path: "write",
        name: "boardwrite",
        component: () => import(/* webpackChunkName: "board" */ "@/components/board/BoardWrite"),
      },
      {
        path: "list",
        name: "boardlist",
        component: () => import(/* webpackChunkName: "board" */ "@/components/board/BoardList"),
      },
      {
        path: "modify",
        name: "boardmodify",
        component: () => import(/* webpackChunkName: "board" */ "@/components/board/BoardModify"),
      },
      {
        path: "delete/:articleNo",
        name: "boarddelete",
        component: () => import(/* webpackChunkName: "board" */ "@/components/board/BoardDelete"),
      },
      {
        path: "detail/:articleNo",
        name: "boarddetail",
        component: () => import(/* webpackChunkName: "board" */ "@/components/board/BoardDetail"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach(async (to, from, next) => {
  // const accessToken = localStorage.getItem('accessToken');
  const accessToken = store.state.accessToken;
  
  // /member/login 또는 /member/regist 페이지로 이동하는 경우 항상 허용합니다.
  if (to.path === '/member/login' || to.path === '/member/regist') {
    next();
  }
  else{
      // 다른 페이지로 이동하는 경우 accessToken을 확인합니다.
    if (accessToken) {
      let info = await isValidToken(accessToken);
      if(info){
        store.commit("setUser",info.response);
        next();
      }
      else{
        next('/member/login');
      }
    }
    // accessToken이 없거나 유효하지 않은 경우 /member/login으로 리디렉션합니다.
    else {
      next('/member/login');
    }
  }
});

// accessToken이 유효한지 확인하는 함수입니다.
async function isValidToken(token) {
  // 토큰 유효성 검사 로직을 구현하세요.
  // 유효한 토큰인 경우 true를 반환하고, 그렇지 않은 경우 false를 반환합니다.
  console.log(token);
  let data = await http.get("http://localhost:9999/user",{
    withCredentials:true,
    headers:{
      'Authorization':`Bearer ${token}`
    }
  })
  .then(function(response){
      let responseData = parser.successParser(response);
      return responseData;
  })
  .catch(function(){
      return false;
  });
  return data;
}
export default router;
