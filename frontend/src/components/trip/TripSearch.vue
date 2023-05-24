<template>
  <div>
    <br/>
    <b-row class="mt-3">
      <b-col></b-col>
      <b-col cols="4">
      <select-sido @select-sido="selectSido"></select-sido>
      </b-col>
      <b-col cols="4">
      <select-gugun :sidoCode="sidoCode" @select-gugun="selectGugun"></select-gugun>
      </b-col>
      <b-col cols="2">
      <select-content-type-id @select-content-type-id="selectContentTypeId"></select-content-type-id>
      </b-col>
      <b-button variant="outline-primary" @click="searchTrip">검색</b-button>
      <b-col></b-col>
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
import SelectContentTypeId from "@/components/item/SelectContentTypeId.vue";
import KakaoMap from "@/components/trip/KakaoMap.vue";
import { mapActions } from "vuex";

const tripStore="tripStore";

export default {
  name: "TripSearch",
  components: {
    SelectSido,
    SelectGugun,
    SelectContentTypeId,
    KakaoMap,
  },
  data() {
    return {
      sidoCode:null,
      gugunCode:null,
      contentTypeId:null,
    };
  },
  watch:{
    
  },
  methods:{
    ...mapActions(tripStore,["getSearchTrip"]),
    selectSido(sidoCode) {
      this.sidoCode = sidoCode;
    },
    selectGugun(gugunCode) {
      this.gugunCode=gugunCode;
    },
    selectContentTypeId(contentTypeId){
      this.contentTypeId=contentTypeId;
            console.log(this.sidoCode);
            console.log(this.gugunCode);
            console.log(this.contentTypeId);
            this.getSearchTrip(this.sidoCode,this.gugunCode,this.contentTypeId);
    }
  },
};
</script>

<style scoped></style>
