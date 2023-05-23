<template>
  <div>
    <trip-card />
    <trip-search />
  </div>
</template>

<script>
import TripCard from "@/components/trip/TripCard.vue";
import TripSearch from "@/components/trip/TripSearch.vue";

export default {
  name: "AppMain",
  components: {
    TripCard,
    TripSearch,
  },
  data() {
    return {};
  },
};
</script>

<style scoped></style>
