<template>
  <div>
    <b-form-select v-model="gugunCode" :options="guguns" @change="changeGugun"></b-form-select>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const sidogugunStore = "sidogugunStore";

export default {
  name: "SelectGugun",
  data() {
    return {
      gugunCode: null,
    };
  },
  props: {
    sidoCode: Number,
  },
  watch: {
    sidoCode() {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) {
        //console.log(this.sidoCode);
        this.getGugun(this.sidoCode);}

    },
  },
  computed: {
    ...mapState(sidogugunStore, ["guguns"]),
  },
  created() {},
  methods: {
    ...mapActions(sidogugunStore, ["getGugun"]),
    ...mapMutations(sidogugunStore, ["CLEAR_GUGUN_LIST"]),
    changeGugun() {
      this.$emit("select-gugun", this.gugunCode);
    },
  },
};
</script>

<style scoped></style>
