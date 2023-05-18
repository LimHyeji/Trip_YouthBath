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
  name: "MemberRegist",
  components: {},
  data() {
    return {
      id: "", //입력받는 문자열
      pw: "",
      pwCheck: "",
      name: "",
      idValid: false, //유효성 판단할 변수
      pwValid: false,
      pwCheckValid: false,
      nameValid: false,
      idMsg: "", //출력할 문자열
      pwMsg: "",
      pwCheckMsg: "",
      nameMsg: "",
    };
  },
  methods: {
    idInput() {
      /*
                인증번호, api, 트랜잭션 필요
            */

      let regex = /^[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,}$/;
      let isValid = regex.test(this.id);

      if (this.id.length < 5) {
        this.idMsg = `아이디는 5자 이상이어야 합니다`;
        this.idValid = false;
      } else if (!isValid) {
        this.idMsg = `이메일 형식이 아닙니다`;
        this.idValid = false;
      } else {
        this.idValid = true;
      }
    },
    pwInput() {
      /*
                1. 대문자/소문자/숫자/기호 각각 최소 1개 이상 포함
                2. 10자 이상의 길이
                3. 연속된 숫자 x
                4. 아이디와 3자리 이상 중복 x
            */

      //아이디와 중복된 3자리 이상의 문자열이 있는지 판단
      let isContain = false;
      for (let len = 3; len < this.id.length; len++) {
        for (let start = 0; start < this.id.length - len; start++) {
          let subStr = this.id.substring(start, start + len);

          if (this.pw.includes(subStr)) {
            isContain = true;
            break;
          }
        }
        if (isContain) break;
      }

      //나머지 조건에 부합하는지 판단
      let regex =
        /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()-=_+`~[\]\\{}|;':",./<>?])(?!.*(.)\1\1\1)(?!.*(1234|1111))(?=.{10,})[A-Za-z\d!@#$%^&*()-=_+`~[\]\\{}|;':",./<>?]+$/;
      let isValid = regex.test(this.pw);

      if (!isValid) {
        this.pwMsg = `연속된 숫자를 포함할 수 없으며, 대문자/소문자/숫자/특수문자를 최소 1개씩 포함한 10자 이상의 문자열이어야 합니다`;
        this.pwValid = false;
      } else if (isContain) {
        this.pwMsg = `아이디와 3자리 이상의 문자가 중복되어서는 안됩니다`;
        this.pwValid = false;
      } else {
        this.pwValid = true;
      }
    },
    pwCheckInput() {
      if (this.pwValid && this.pw === this.pwCheck) {
        this.pwCheckValid = true;
      } else {
        this.pwCheckMsg = `비밀번호가 일치하지 않습니다`;
        this.pwCheckValid = false;
      }
    },
    nameInput() {
      if (this.name.trim() === "") {
        this.nameValid = false;
      } else {
        this.nameValid = true;
      }
    },
    regist() {
      if (this.idValid && this.pwValid && this.pwCheckValid && this.nameValid) {
        //api 호출
        alert("ok");
      } else {
        alert("fail");
      }
    },
  },
};
</script>

<style scoped></style>
