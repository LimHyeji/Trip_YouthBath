import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain";
import http from '@/api/http';
import parser from '@/api/lib/responseParser';
import store from '@/store/index';

Vue.use(VueRouter);

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
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberLogin"),
      },
      {
        path: "regist",
        name: "regist",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberRegist"),
      },
      {
        path: "mypage",
        name: "mypage",
        //beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberMyPage"),
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
  const accessToken = localStorage.getItem('accessToken');
  
  // /member/login 또는 /member/regist 페이지로 이동하는 경우 항상 허용합니다.
  if (to.path === '/member/login' || to.path === '/member/regist') {
    next();
  }
  else{
      // 다른 페이지로 이동하는 경우 accessToken을 확인합니다.
    if (accessToken) {
      let info = await isValidToken(accessToken);
      if(info){
        store.commit("setUser",info);
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
