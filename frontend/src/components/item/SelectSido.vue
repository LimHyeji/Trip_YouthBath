<template>
  <b-col class="sm-3">
    <b-form-select v-model="sidoCode" :options="sidos" @change="changeSido"></b-form-select>
  </b-col>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const itemStore = "itemStore";

export default {
  name: "SelectSido",
  data() {
    return {
      sidoCode: null,
    };
  },
  computed: {
    ...mapState(itemStore, ["sidos"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(itemStore, ["getSido"]),
    ...mapMutations(itemStore, ["CLEAR_SIDO_LIST"]),
    changeSido() {
      this.$emit("select-sido", this.sidoCode);
    },
  },
};
</script>

<style scoped></style>
