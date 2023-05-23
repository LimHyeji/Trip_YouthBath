<template>
    <div>
        <b-container class="bv-example-row mt-3">
          <b-row>
            <b-col></b-col>
            <b-col cols="8">
              <b-card class="text-center mt-3" style="max-width: 40rem">
                  <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                    <b-icon icon="pencil-square" style="color: #00bbff"></b-icon>글 수정
                  </h2>
                  <br /><br />
                  <board-article-input type="modify"/>      
              </b-card>
            </b-col>
            <b-col></b-col>
          </b-row>
        </b-container>
    </div>
</template>

<script>
import BoardArticleInput from "@/components/board/article/BoardArticleInput.vue";

export default {
    name: 'BoardModify',
    components: {
        BoardArticleInput,
    },
};
</script>

<style scoped></style>