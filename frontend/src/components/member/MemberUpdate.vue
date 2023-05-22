<template>
    <div>
      <b-container class="bv-example-row mt-3">
        <b-row>
          <b-col></b-col>
          <b-col cols="8">
            <b-card class="text-center mt-3" style="max-width: 40rem">
              <div>
                <span>아이디 : {{user.response.id}}</span><br>
                <span>이름 : {{user.response.name}}</span><br>
                <button>수정</button><button>취소</button>
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
  import parser from '@/api/lib/responseParser'
  import {mapState,mapMutations } from 'vuex';
  export default {
      name: "MemberMyPage",
      components: {},
      data() {
          return {
            pw:'Abcdefg123!',
            pwMsg:'',
            isAuth:false,
           };
      },
      computed:{
        ...mapState(['user'])
      },
      methods:{
          ...mapMutations(['clearUser']),
          async authentication(){
            let data = {
              password : this.pw
            };
            let accessToken = localStorage.getItem("accessToken");
            let result = await http.post(
              "http://localhost:9999/user/secondary",
              data,
              {
                withCredentials:true,
                headers:{
                  'Authorization':`Bearer ${accessToken}`
              }
            }).then(function(response){
              let data = parser.successParser(response);
              return data.response;
            }).catch(function(response){
              alert("f")
              console.dir(response);
            });

            if(result){
              alert("인증되었습니다.");
              this.isAuth = true;
            }
            else{
              alert("비밀번호를 확인해주세요")
            }
          }
      }
  };
  </script>
  
  <style scoped></style>
  