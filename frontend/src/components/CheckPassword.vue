<template>
  <div>
    <b-container class="bv-example-row mt-3">
      <b-row>
        <b-col></b-col>
        <b-col cols="8">
          <b-card class="text-center mt-3" style="max-width: 40rem">
            <b-form class="m-2">
              <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                <b-icon icon="person-lines-fill" style="color: #00bbff"></b-icon>회원가입
              </h2>
              <br /><br />
              <!-- 검증(이메일 형식, 중복확인, 인증번호) 필요 -->
              <b-form-input
                id="id"
                v-model="id"
                v-on:input="idInput"
                placeholder="아이디(이메일)"
                style="height: 50px"
              >
              </b-form-input>
              <span>{{ idMsg }}</span>
              <br /><br />
              <!-- 비밀번호 확인 필요 -->
              <b-form-input
                v-model="pw"
                v-on:input="pwInput"
                id="pw"
                placeholder="비밀번호"
                type="password"
                style="height: 50px"
              >
              </b-form-input>
              <span>{{ pwMsg }}</span>
              <br /><br />
              <b-form-input
                v-model="pwCheck"
                v-on:input="pwCheckInput"
                id="pwCheck"
                placeholder="비밀번호 확인"
                type="password"
                style="height: 50px"
              >
              </b-form-input>
              <span>{{ pwCheckMsg }}</span>
              <br /><br />
              <b-form-input
                v-model="name"
                v-on:input="nameInput"
                id="name"
                placeholder="이름"
                style="height: 50px"
              >
              </b-form-input>
              <br /><br />
              <!-- 주소 생략 -->
              <b-button
                type="button"
                style="background-color: #00bbff; width: 200px"
                class="m-1"
                v-on:click="regist"
                >회원가입</b-button
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
export default {
  name: "MemberMyPage",
  components: {},
  data() {
    return {};
  },
};
</script>

<style scoped></style>
