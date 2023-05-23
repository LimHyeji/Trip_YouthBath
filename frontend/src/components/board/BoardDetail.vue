<template>
    <div>
        <b-container class="bv-example-row mt-3">
          <b-row>
            <b-col></b-col>
            <b-col cols="8">
              <b-card class="text-center mt-3" style="max-width: 40rem">
                  <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                    <b-icon icon="pencil-square" style="color: #00bbff"></b-icon>글 보기
                  </h2>
                  <br /><br />
                 <!-- UI 확인 필요 -->
                <b-col class="text-left">
                    <b-button style="color: #00bbff" @click="moveList">목록</b-button>
                </b-col>
                <b-col class="text-right" v-if="user.userid === article.writer">
                    <b-button style="color: #00bbff" size="sm" @click="moveModifyArticle" class="mr-2">글수정</b-button>
                    <b-button style="color: #00bbff" size="sm" @click="deleteArticle">글삭제</b-button>
                </b-col>
                <b-card
                :header-html="`<h3>${article.articleNo}.
                ${article.title} [${article.hit}]</h3><div><h6>${article.writer}</div><div>${article.regtime}</h6></div>`"
                class="mb-2"
                border-variant="dark"
                no-body
                >
                <b-card-body class="text-left">
                    <div v-html="message"></div>
                </b-card-body>
                </b-card>   
              </b-card>
            </b-col>
            <b-col></b-col>
          </b-row>
        </b-container>
    </div>
</template>

<script>
import { detailArticle } from "@/api/board";
import { mapState, mapMutations } from "vuex";

export default {
    name: 'BoardDetail',
    components: {},
    data() {
        return {
            article: {},
        };
    },
     computed:{
    ...mapState(['user']),
    message(){
        if(this.article.content) return this.article.content.split("\n").join("<br>");
        return "";
    },
  },
  created(){
    let param=this.$route.params.articleNo;
    detailArticle(
        param,
        ({data})=>{
            this.article=data;
        },
        (error)=>{
            console.log(error);
        },
    );
  },
  methods:{
    ...mapMutations(['clearUser']),
    moveModifyArticle(){
    this.$router.replace({
        name:"boardmodify",
        params:{articleNo:this.article.articleNo},
    });
       this.$router.push({ path: `/board/modify/${this.article.articleno}` });//modfy 페이지로 이동
    },
    deleteArticle(){
        if(confirm("글을 삭제하시겠습니까?")){
            this.$router.replace({
                name:"boarddelete",
                params:{articleNo:this.article.articleNo},
            });
        }
    },
    moveList(){
        this.$router.push({name:"boardlist"});
    },
  },
};
</script>

<style scoped></style>