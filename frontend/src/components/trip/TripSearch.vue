<template>
  <div>
    <br/>
    <b-row class="mt-3">
      <select-sido @select-sido="selectSido"></select-sido>
      <select-gugun :sidoCode="sidoCode" @select-gugun="selectGugun"></select-gugun>
    </b-row>
    <br/>
    <b-row class="mt-3">
      <b-col></b-col>
      <b-col cols="10">
        <kakao-map />
      </b-col>
      <b-col></b-col>
    </b-row>
  </div>
</template>

<script>
import SelectSido from "@/components/item/SelectSido.vue";
import SelectGugun from "@/components/item/SelectGugun.vue";
import KakaoMap from "@/components/trip/KakaoMap.vue";

export default {
  name: "TripSearch",
  components: {
    SelectSido,
    SelectGugun,
    KakaoMap,
  },
  data() {
    return {
      sidoCode:null,
    };
  },
  methods:{
    selectSido(sidoCode){
      this.sidoCode=sidoCode;
      console.log(sidoCode);
    },
    selectGugun(gugunCode){
      console.log(gugunCode);
    },
  },
};
</script>

<style scoped></style>
