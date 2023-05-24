<template>
  <div>
    <b-form-select class="form-select me-2" v-model="contentTypeId" @change="changeContentTypeId">
            <option value="0" selected>관광지 유형</option>
            <option value="12">관광지</option>
            <option value="14">문화시설</option>
            <option value="15">축제공연행사</option>
            <option value="25">여행코스</option>
            <option value="28">레포츠</option>
            <option value="32">숙박</option>
            <option value="38">쇼핑</option>
            <option value="39">음식점</option>
      </b-form-select>  
  </div>
</template>

<script>

export default {
  name: "SelectContentTypeId",
  data() {
    return {
      contentTypeId:null,
    };
  },
  methods: {
    changeContentTypeId() {
      this.$emit("select-content-type-id", this.contentTypeId);
    },
  },
};
</script>

<style scoped></style>
