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
                <router-link
                  :to="{ name: 'boarddetail', params: { articleNo: data.item.articleNo } }"
                >
                  {{ data.item.title }}
                </router-link>
              </template>
            </b-table>
            <b-button @click="prevPage" type="button" v-if="prev" variant="outline-primary">
              <b-icon icon="arrow-left-square" style="color: #00bbff"></b-icon>
            </b-button>
            <span> 현재 페이지 : {{ pageNo }} </span>
            <b-button @click="nextPage" type="button" v-if="next" variant="outline-primary">
              <b-icon icon="arrow-right-square" style="color: #00bbff"></b-icon>
            </b-button>
            <br /><br />
            <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
          </b-card>
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { listArticle } from "@/api/board";

export default {
  name: "BoardList",
  components: {},
  data() {
    return {
      articles: [],
      fields: [
        { key: "articleNo", label: "글 번호", tdClass: "tdClass" },
        { key: "title", label: "글 제목", tdClass: "tdTitle" },
        { key: "writer", label: "작성자", tdClass: "tdClass" },
        { key: "regTime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
      pageNo: 0,
      prev: null,
      next: null,
    };
  },
  mounted() {
    listArticle(
      { pageNo: this.pageNo },
      ({ data }) => {
        this.articles = data.response.articles;
        this.prev = data.response.prev;
        this.next = data.response.next;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "boardwrite" }); //write 페이지로 이동
    },
    detailArticle(article) {
      this.$router.push({
        name: "boarddetail",
        params: { articleNo: article.articleNo },
      });
    },
    prevPage() {
      this.pageNo -= 1;
      listArticle(
        { pageNo: this.pageNo },
        ({ data }) => {
          console.log(data);
          this.articles = data.response.articles;
          this.prev = data.response.prev;
          this.next = data.response.next;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    nextPage() {
      this.pageNo += 1;
      listArticle(
        { pageNo: this.pageNo },
        ({ data }) => {
          console.log(data);
          this.articles = data.response.articles;
          this.prev = data.response.prev;
          this.next = data.response.next;
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
  //   computed: {
  //     pageCount() {
  //       const listLength = this.articles.length;
  //       const listSize = 10;
  //       let page = Math.floor(listLength / listSize);
  //       if (listLength % listSize > 0) page += 1;
  //       return page;
  //     },
  //     paginatedData() {
  //       const start = this.pageNo * 10;
  //       const end = start + 10;
  //       return this.articles.slice(start, end);
  //     },
  //   },
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
}
</style>
