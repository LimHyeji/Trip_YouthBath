<template>
  <div>
    <b-navbar toggleable="lg" type="dark" style="background-color: #00bbff">
      <b-navbar-brand href="#">
        <router-link :to="{ name: 'main' }">
        <b-img :src="require('@/assets/logo.png')" id="logo" alt="logo"></b-img>
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <!-- <b-nav-form>
                        <b-form-input size="sm" class="mr-sm-2" placeholder="..."></b-form-input>
                        <b-button size="sm" class="my-2 my-sm-0" type="submit">검색</b-button>
                    </b-nav-form> -->
          <b-navbar-nav>
            <router-link :to="{ name: 'login' }" class="m-2 link" v-if="!user">
              <b-icon icon="key"></b-icon> 로그인
            </router-link>
            <router-link :to="{ name: 'regist' }" class="m-2 link" v-if="!user">
              <b-icon icon="person-circle"></b-icon> 회원가입
            </router-link>
            <b-nav-item href="#" v-if="user">{{user.name}}님 반갑습니다.</b-nav-item>
            <router-link :to="{ name: 'boardlist' }" class="m-2 link" v-if="user">
              <b-icon icon="people-fill"></b-icon>커뮤니티
            </router-link>
          </b-navbar-nav>
          <!-- 로그인 후에만 출력하도록 변경 예정 -->
          <b-nav-item-dropdown right v-if="user">
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <b-icon icon="people" font-scale="2"></b-icon>
            </template>
            <b-dropdown-item href="#">
              <router-link :to="{ name: 'mypage' }" class="link align-self-center">
                마이페이지
              </router-link><br>
              <a class="link align-self-center" v-on:click="logout">
                로그아웃
              </a>
            </b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import {mapState,mapMutations } from 'vuex';
export default {
  name: "HeaderNav",
  data() {
    return {
    };
  },
  computed:{
    ...mapState(['user'])
  },
  methods:{
    ...mapMutations(['clearUser']),
    logout() {
      // 로그아웃 로직을 구현하세요.
      // 로컬 스토리지의 토큰을 제거하고, 상태를 초기화합니다.
      this.clearUser();
      this.clearAccessToken();
      alert("로그아웃 되었습니다.");
      location.href="/";
    }
  }
};
</script>

<style scoped></style>
