<template>
  <div>
    <b-container class="bv-example-row mt-3">
      <b-row>
        <b-col></b-col>
        <b-col cols="8">
          <b-card class="text-center mt-3" style="max-width: 40rem">
            <b-form class="m-2">
              <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                <b-icon icon="person-lines-fill" style="color: #00bbff"></b-icon>로그인
              </h2>
              <br /><br />
              <b-form-input 
                id="id" 
                placeholder="아이디(이메일)" 
                style="height: 50px"
                v-model="id"
              >
              </b-form-input>
              <br /><br />
              <b-form-input
                id="password"
                placeholder="비밀번호"
                type="password"
                style="height: 50px"
                v-model="pw"
              >
              </b-form-input>
              <br /><br />
              <b-button
                type="button"
                style="background-color: #00bbff; width: 200px"
                class="m-1"
                v-on:click="submit"
                >로그인</b-button
              >
            </b-form>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import http from '@/api/http';
import parser from '@/api/lib/responseParser';
import store from '@/store/index';
export default {
  name: "MemberLogin",
  components: {},
  data() {
    return {
      id:'aa@gmail.com',
      pw:'Abcdefg123!'
    };
  },
  methods:{
    submit(){
      const data = {
        id:this.id,
        password:this.pw
      };

      http.post("http://localhost:9999/user/login",JSON.stringify(data))
      .then(function(response){
        let responseData = parser.successParser(response);//로그인 성공에 대한 결과를 받아옴
        let accessToken = responseData.response.accessToken;//accessToken을 가져옴

        //일단은 로컬스토리지에 저장
        // localStorage.setItem("accessToken",accessToken);
        store.commit("setAccessToken",accessToken);
        location.href="/";
      })
      .catch(function(response){
        console.dir(response);
        let responseData = parser.failureParser(response);
        alert(responseData.error.message);//에러메세지를 alert
      })
    }
  }
};
</script>

<style scoped></style>
