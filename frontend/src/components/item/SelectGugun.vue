<template>
  <b-col class="sm-3">
    <b-form-select v-model="gugunCode" :options="guguns" @change="changeGugun"></b-form-select>
  </b-col>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const itemStore = "itemStore";

export default {
  name: "SelectGugun",
  data() {
    return {
      gugunCode: null,
    };
  },
  props: {
    sidoCode: String,
  },
  watch: {
    sidoCode() {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
  },
  computed: {
    ...mapState(itemStore, ["guguns"]),
  },
  created() {},
  methods: {
    ...mapActions(itemStore, ["getGugun"]),
    ...mapMutations(itemStore, ["CLEAR_GUGUN_LIST"]),
    changeGugun() {
      this.$emit("select-gugun", this.gugunCode);
    },
  },
};
</script>

<style scoped></style>
