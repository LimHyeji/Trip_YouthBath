<template>
    <div>
        <b-container class="bv-example-row mt-3">
          <b-row>
            <b-col></b-col>
            <b-col cols="8">
              <b-card class="text-center mt-3" style="max-width: 40rem">
                  <h2 class="underline-steelblue" style="color:#00bbff; bolder;">
                    <b-icon icon="pencil-square" style="color: #00bbff"></b-icon>글 목록
                  </h2>
                  <br /><br />
                  <!-- -->
                    <b-table striped hover :items="articles" :fields="fields" @row-clicked="detailArticle">
                        <template #cell(title)="data">
                            <router-link :to="{ name: 'boarddetail', params: { articleNo: data.item.articleNo } }">
                            {{ data.item.title }}
                            </router-link>
                        </template>
                    </b-table>
                  <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
              </b-card>
            </b-col>
            <b-col></b-col>
          </b-row>
        </b-container>
    </div>
</template>

<script>
import {listArticle} from "@/api/board";

export default {
    name: 'BoardList',
    components: {},
    data() {
        return {
             articles:[],
             fields:[
                {key:"articleNo",label:"글 번호",tdClass:"tdClass"},
                {key:"title",label:"글 제목",tdClass:"tdTitle"},
                {key:"writer",label:"작성자",tdClass:"tdClass"},
                {key:"regTime",label:"작성일",tdClass:"tdClass"},
                {key:"hit",label:"조회수",tdClass:"tdClass"},
             ],
        };
    },
    created() {
        let param={
            pageNo:1,
            size:20,
            key:null,
            word:null,
        };
        listArticle(
            param,
            ({data})=>{
                this.articles=data;
            },
            (error)=>{
                console.log(error);
            }
        );
    },
    methods: {
        moveWrite(){
            this.$router.push({name:"boardwrite"});//write 페이지로 이동
        },
        detailArticle(article){
            this.$router.push({
                name:"boarddetail",
                params:{articleNo:article.articleNo},
            });
        },
    },
};
</script>

<style scoped>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdTitle {
  width: 300px;
  text-align: left;
}</style>