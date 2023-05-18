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
              <b-form-input id="id" placeholder="아이디(이메일)" style="height: 50px">
              </b-form-input>
              <br /><br />
              <b-form-input
                id="password"
                placeholder="비밀번호"
                type="password"
                style="height: 50px"
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
export default {
  name: "MemberLogin",
  components: {},
  data() {
    return {};
  },
};
</script>

<style scoped></style>
