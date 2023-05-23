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
                 <!-- 어디서 삭제할지 추가 작업 필요 -->
                 <b-alert show variant="danger">삭제처리중...</b-alert>    
              </b-card>
            </b-col>
            <b-col></b-col>
          </b-row>
        </b-container>
    </div>
</template>

<script>
import {deleteArticle} from "@/api/board";

export default {
    name: 'BoardDelete',
    created() {
        let param=this.$route.params.articleNo;
        deleteArticle(
            param,
            ({data})=>{
                let msg="글 삭제가 제대로 되지 않았습니다";
                if(data==="success"){
                    msg="글 삭제가 완료되었습니다";
                }
                alert(msg);
                this.$router.push({name:"boardlist"});//list 페이지로 이동
            },
            (error)=>{
                console.log(error);
            }
        );
    },
};
</script>

<style scoped></style>