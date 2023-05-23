<template>
    <div>
              <b-form @submit="onSubmit" @reset="onReset">
                <b-form-group id="title-group" label="제목:" label-for="title">
                    <b-form-input
                        id="title"
                        v-model="article.title"
                        type="text"
                        required
                        placeholder="제목 입력..."
                    ></b-form-input>
                    </b-form-group>
                    <b-form-group id="content-group" label="내용:" label-for="content">
                    <b-form-textarea
                        id="content"
                        v-model="article.content"
                        placeholder="내용 입력..."
                        rows="10"
                        max-rows="15"
                    ></b-form-textarea>
                </b-form-group>
                <b-button type="submit" style="background-color: #00bbff; width: 200px"
                class="m-1" v-if="this.type === 'regist'">글작성</b-button>
                <b-button type="submit" style="background-color: #00bbff; width: 200px"
                class="m-1" v-else>글수정</b-button>
                <b-button type="reset" style="background-color: #00bbff; width: 200px"
                class="m-1">초기화</b-button>
            </b-form>
    </div>
</template>

<script>
import { writeArticle, modifyArticle, detailArticle } from "@/api/board";

export default {
    name: 'BoardArticleInput',
    components: {},
    data() {
        return {
            article:{
                aticleno:0,
                title:"",
                content:"",
            },
        };
    },
    props:{
        type:{type:String},
    },
    created(){
        if(this.type==="modify"){
            let param=this.$route.params.articleNo;
            detailArticle(
                param,
                ({data})=>{
                    this.article=data;
                },
                (error)=>{
                    console.log(error);
                }
            );
        }
    },
    methods:{
        onSubmit(event){
            event.preventDefault();
            
            let err=true;
            let msg="";
            err && !this.article.title && ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
            err && !this.article.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());
            
            if(!err) alert(msg);
            else this.type==="regist" ? this.registArticle():this.modifyArticle();
        },
        onReset(event){
            event.preventDefault();
            this.article.articleNo=0;
            this.article.title="";
            this.article.content="";
            this.moveList();
        },
        registArticle(){
            let param={
                title:this.article.title,
                content:this.article.content,
            };

            writeArticle(
                param,
                ({data})=>{
                    let msg ="글 등록이 제대로 되지 않았습니다";
                    if(data.success){
                        msg="등록이 완료되었습니다";
                    }
                    alert(msg);
                    this.moveList();//list 페이지로 이동
                },
                (error)=>{
                    console.log(error);
                }
            );
        },
        modifyArticle(){
            let param={
                articleNo:this.article.articleNo,
                title:this.article.title,
                content:this.article.content,
            };
            modifyArticle(
                param,
                ({data})=>{
                    let msg="글 수정이 제대로 되지 않았습니다";
                    if(data==="success"){
                        msg="수정이 완료되었습니다";
                    }
                    alert(msg);
                    this.moveList();//list 페이지로 이동
                },
                (error)=>{
                    console.log(error);
                }
            );
        },
        moveList(){
            this.$router.push({name:"boardlist"});
        },
    },
};
</script>

<style scoped></style>