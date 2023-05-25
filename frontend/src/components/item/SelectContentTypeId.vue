<template>
  <div>
    <b-form-select
      :options="ids"
      class="form-select me-2"
      v-model="contentTypeId"
      @change="changeContentTypeId"
    >
    </b-form-select>
  </div>
</template>

<script>
export default {
  name: "SelectContentTypeId",
  data() {
    return {
      ids: [{ value: null, text: "관광지 유형" },
      { value: 12, text: "관광지" },
      { value: 14, text: "문화시설" },
      { value: 15, text: "축제공연행사" },
      { value: 25, text: "여행코스" },
      { value: 28, text: "레포츠" },
      { value: 32, text: "숙박" },
      { value: 38, text: "쇼핑" },
      { value: 39, text: "음식점" }],
      contentTypeId: null,
    };
  },
  created: {

  },
  methods: {
    changeContentTypeId() {
      console.log(this.contentTypeId);
      this.$emit("select-content-type-id", this.contentTypeId);
    },
  },
};
</script>

<style scoped></style>
