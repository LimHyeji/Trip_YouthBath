<template>
    <div>
        <b-navbar toggleable="lg" type="dark" style="background-color:#00bbff">
            <b-navbar-brand href="#">
                <b-img :src="require('@/assets/logo.png')" fluid alt="Fluid image"></b-img>
            </b-navbar-brand>

        <b-collapse id="nav-collapse" is-nav>
            <!-- Right aligned nav items -->
            <b-navbar-nav class="ml-auto">
                <!-- <b-nav-form>
                    <b-form-input size="sm" class="mr-sm-2" placeholder="..."></b-form-input>
                    <b-button size="sm" class="my-2 my-sm-0" type="submit">검색</b-button>
                </b-nav-form> -->
            <b-navbar-nav>
                <b-nav-item href="#">로그인</b-nav-item>
                <b-nav-item href="#">회원가입</b-nav-item>
                <b-nav-item href="#" disabled>커뮤니티</b-nav-item>
            </b-navbar-nav>
                <!-- 로그인 후 마이페이지 및 프로필 출력하도록 변경 예정 -->
                <b-nav-item-dropdown right>
                <!-- Using 'button-content' slot -->
                <template #button-content>
                   <b-icon icon="people" font-scale="2"></b-icon>
                </template>
                <b-dropdown-item href="#">로그인</b-dropdown-item>
                <b-dropdown-item href="#">회원가입</b-dropdown-item>
                </b-nav-item-dropdown>
            </b-navbar-nav>
        </b-collapse>
    </b-navbar>
    </div>
</template>

<script>
export default {
    name: "HeaderNav",
    data() {
        return {};
    },
};
</script>

<style scoped></style>