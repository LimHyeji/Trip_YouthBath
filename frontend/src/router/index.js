import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'

Vue.use(VueRouter)

//url 추가해야 해요
const routes = [
  {
    path: '/',//홈 url : "/"
    name: 'home',
    component: HomeView
  },
  {
    path: "/user",//url : "/user"
    name: "user",
    component: () => import("@/views/UserView.vue"),
    children: [
      {
        path: "singin",//로그인 url : "/user/signin"
        name: "signIn",
        component: () => import( "@/components/user/UserLogin.vue"),
      },
      {
        path: "singup",//회원가입 url : "/user/signup"
        name: "signUp",
        component: () =>
          import("@/components/user/UserRegister.vue"),
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
