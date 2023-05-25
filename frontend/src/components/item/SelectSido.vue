<template>
  <div>
    <b-form-select v-model="sidoCode" :options="sidos" @change="changeSido"></b-form-select>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const sidogugunStore = "sidogugunStore";

export default {
  name: "SelectSido",
  data() {
    return {
      sidoCode: null,
    };
  },
  computed: {
    ...mapState(sidogugunStore, ["sidos"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(sidogugunStore, ["getSido"]),
    ...mapMutations(sidogugunStore, ["CLEAR_SIDO_LIST"]),
    changeSido() {
      this.$emit("select-sido", this.sidoCode);
    },
  },
};
</script>

<style scoped></style>
