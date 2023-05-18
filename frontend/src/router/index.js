import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain";

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

export default router;
