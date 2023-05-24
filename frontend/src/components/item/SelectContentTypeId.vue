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
      ids: [{ value: null, text: "관광지 유형" }],
      contentTypeId: null,
    };
  },
  created: {
    setOptions() {
      this.ids.push({ value: 12, text: "관광지" });
      this.ids.push({ value: 14, text: "문화시설" });
      this.ids.push({ value: 15, text: "축제공연행사" });
      this.ids.push({ value: 25, text: "여행코스" });
      this.ids.push({ value: 28, text: "레포츠" });
      this.ids.push({ value: 32, text: "숙박" });
      this.ids.push({ value: 38, text: "쇼핑" });
      this.ids.push({ value: 39, text: "음식점" });
    },
  },
  methods: {
    changeContentTypeId() {
      this.$emit("select-content-type-id", this.contentTypeId);
    },
  },
};
</script>

<style scoped></style>
