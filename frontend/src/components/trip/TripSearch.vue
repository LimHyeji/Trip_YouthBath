<template>
  <div>
    <b-dropdown
      split
      split-variant="outline-primary"
      variant="primary"
      text="Split Variant Dropdown"
      class="m-2"
    >
      <b-dropdown-item href="#">Action</b-dropdown-item>
      <b-dropdown-item href="#">Another action</b-dropdown-item>
      <b-dropdown-item href="#">Something else here...</b-dropdown-item>
    </b-dropdown>
    <b-dropdown
      split
      split-variant="outline-primary"
      variant="primary"
      text="Split Variant Dropdown"
      class="m-2"
    >
      <b-dropdown-item href="#">Action</b-dropdown-item>
    </b-dropdown>
    <kakao-map />
  </div>
</template>

<script>
import { sidoList, gugunList } from "@/api/trip.js";
import KakaoMap from "@/components/trip/KakaoMap.vue";

export default {
  name: "TripSearch",
  components: {
    KakaoMap,
  },
  data() {
    return {
      message: "",
    };
  },
  mounted() {
    sidoList(
      ({ data }) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
    gugunList(
      { sidoCode: 1 },
      ({ data }) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style scoped></style>
