<template>
  <b-card-group columns>
    <b-card title="여행지를 소개합니다">
      <b-img :src="require('@/assets/sample1.jpg')" fluid alt="Fluid image"></b-img>
      <b-card-text>
        This is a wider card with supporting text below as a natural lead-in to additional content.
        This content is a little bit longer. ...
      </b-card-text>
    </b-card>

    <b-card header="인용문구">
      <blockquote class="blockquote mb-0">
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante. ...
        </p>
        <footer class="blockquote-footer">
          Someone famous in <cite title="Source Title">Source Title</cite>
        </footer>
      </blockquote>
    </b-card>

    <b-card title="제주도">
      <b-img :src="require('@/assets/sample2.jpg')" fluid alt="Fluid image"></b-img>
      <b-card-text>
        This card has supporting text below as a natural lead-in to additional content. ...
      </b-card-text>
      <b-card-text class="small text-muted">Last updated 3 mins ago</b-card-text>
    </b-card>

    <b-card bg-variant="primary" text-variant="white">
      <blockquote class="card-blockquote">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
        <footer>
          <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
        </footer>
      </blockquote>
    </b-card>

    <b-card title="색다른 여행지">
      <b-img :src="require('@/assets/sample3.jpg')" fluid alt="Fluid image" width="500px"></b-img>
      <b-card-text>
        This is a wider card with supporting text below as a natural lead-in to additional content.
        This card has even longer content than the first. ...
      </b-card-text>
      <template #footer>
        <small class="text-muted">id : ssafy</small>
      </template>
    </b-card>
  </b-card-group>
</template>

<script>
export default {
  name: "TripCard",
  components: {},
  data() {
    return {};
  },
};
</script>

<style scoped></style>
