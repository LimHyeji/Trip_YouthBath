<template>
    <div>
        마이 뷰
        이름 : {{user.response.name}}<br>
        <button>수정하기</button><br/>
        <button>삭제하기</button><br>
    </div>
</template>

<script>
import {mapState,mapMutations } from 'vuex';
export default {
    name: "MemberMyPage",
    components: {},
    data() {
        return { };
    },
    computed:{
    ...mapState(['user'])
    },
    methods:{
        ...mapMutations(['clearUser']),
        logout() {
        // 로그아웃 로직을 구현하세요.
        // 로컬 스토리지의 토큰을 제거하고, 상태를 초기화합니다.
        localStorage.removeItem('accessToken');
        this.clearUser();
        alert("로그아웃 되었습니다.");
        location.href="/";
        }
    }
};
</script>

<style scoped></style>