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
                <!-- 조회부분 -->
                <div v-if="!updateMode">
                  <span>아이디 : {{user.response.id}}</span><br>
                  <span>이름 : {{user.response.name}}</span><br>
                  <button v-on:click="toggleUpdateMode">수정</button><button v-on:click="deleteMember">삭제</button>
                </div>
                <!-- 수정부분 -->
                <div v-else>
                  <span>아이디 : {{user.response.id}}</span><br>
                  이름 : <input type="text" id="nameInput" v-bind:value="user.response.name"><br>
                  <button v-on:click="updateMember">수정하기</button><button v-on:click="toggleUpdateMode">취소</button>
                </div>
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
  import store from '@/store/index';
  export default {
      name: "MemberMyPage",
      components: {},
      data() {
          return {
            pw:'Abcdefg123!',
            pwMsg:'',
            isAuth:false,
            updateMode:false,
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
            console.log(accessToken);
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
          },
          toggleUpdateMode(){
            this.updateMode = !this.updateMode;
          },
          updateMember(){
            //업데이트 될 데이터 모으기
            let token = localStorage.getItem("accessToken");
            const data = {
              name : document.querySelector("#nameInput").value
            }
            http.post("http://localhost:9999/user/update",data,{
              withCredentials:true,
              headers:{
                'Authorization':`Bearer ${token}`
              }
            }).then(response=>{
              let responseData = parser.successParser(response);
              store.commit("setUser",responseData);
              alert("수정되었습니다.");
              this.toggleUpdateMode();
            }).catch(response=>{
              console.log(response);
              alert("오류")
            })
          },
          deleteMember(){
            let conf = confirm("삭제하시겠습니까?");
            if(conf){
              let token = localStorage.getItem("accessToken");
              //삭제로직
              http.post("http://localhost:9999/user/delete",{},{
                withCredentials:true,
                headers:{
                  'Authorization':`Bearer ${token}`
                }
              }).then(function(){
                store.commit('setUser',null);
                alert("삭제되었습니다!");
                location.href="/member/login";
              }).catch(function(){
                alert("삭제중 오류가 발생했습니다.");
              })
            }
          }
      }
  };
  </script>
  
  <style scoped></style>
  