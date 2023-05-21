<template>
  <div>
    <trip-card />
    <kakao-map />
  </div>
</template>

<script>
import TripCard from "@/components/trip/TripCard.vue";
import KakaoMap from "@/components/trip/KakaoMap.vue";

export default {
  name: "AppMain",
  components: {
    TripCard,
    KakaoMap,
  },
  data() {
    return {};
  },
};
</script>

<style scoped></style>
