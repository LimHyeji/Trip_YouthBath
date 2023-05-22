<template>
    <div>
      <b-container class="bv-example-row mt-3">
        <b-row>
          <b-col></b-col>
          <b-col cols="8">
            <b-card class="text-center mt-3" style="max-width: 40rem">
              <!-- 이부분은 인증을 위한 페이지. 초반엔 인증이 되지 않았으므로 이부분이 떠야함 -->
              <div v-if="!isAuth">
                <b-form class="m-2">
                  <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                    <b-icon icon="person-lines-fill" style="color: #00bbff"></b-icon>내정보 조회
                  </h2>
                  <br /><br />
                  <!-- 비밀번호 확인 후 이동 필요 -->
                  <!-- 비밀번호 확인 필요 -->
                  <b-form-input
                    v-model="pw"
                    id="pw"
                    placeholder="비밀번호"
                    type="password"
                    style="height: 50px"
                  >
                  </b-form-input>
                  <span>{{ pwMsg }}</span>
                  <b-button
                    type="button"
                    style="background-color: #00bbff; width: 200px"
                    class="m-1"
                    v-on:click="authentication"
                    >비밀번호 확인</b-button
                  >
                </b-form>
              </div>
              <!-- 이부분은 정보를 노출시키는 부분. 인증이 되었을 때 보여야함 -->
              <div v-else>
                인증되었습니다.
              </div>
            </b-card>
          </b-col>
          <b-col></b-col>
        </b-row>
      </b-container>
    </div>
  </template>
  
  <script>
  import http from '@/api/http';
  export default {
      name: "MemberMyPage",
      components: {},
      data() {
          return {
            pw:'',
            pwMsg:'',
            isAuth:false,
           };
      },
      methods:{
          authentication(){
            let data = {
              password : this.pw
            };
            let accessToken = localStorage.getItem("accessToken");
            http.post(
              "http://localhost:9999/user/secondary",
              data,
              {
                withCredentials:true,
                headers:{
                  'Authorization':`Bearer ${accessToken}`
              }
            }).then(function(response){
              alert("s")
              console.dir(response);

            }).catch(function(response){
              alert("f")
              console.dir(response);
            })
          }
      }
  };
  </script>
  
  <style scoped></style>
  