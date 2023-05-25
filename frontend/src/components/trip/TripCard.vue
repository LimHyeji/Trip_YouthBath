<template>
  <b-card-group columns>
    <b-card title="국립 청태산자연휴양림">
      <b-img :src="'http://tong.visitkorea.or.kr/cms/resource/21/2657021_image2_1.jpg'" fluid alt="Fluid image"></b-img>
      <b-card-text>
        <br>해발 1,200m의 청태산을 주봉으로 하여 인공림과 천연림이 잘 조화된 울창한 산림을 바탕으로 한 국유림 경영 시범단지로서 숲속에는 온갖 야생 동식물이 고루 서식하고 있어 자연박물관을 찾은 기분을 느낄 수 있다. 영동고속도로 신갈기점 강릉방향 128km 지점에 위치하고 있어 여름철 동해안 피서객들이 잠시 쉬었다 가기에 편리하고, 청소년의 심신수련을 위한 숲속교실도 설치되어 있으며 울창한 잣나무 숲속의 산림욕장은 한번왔다간 사람은 누구나 매료되어 찾는 곳이기도 하다. * 구역면적 - 403 ha
      </b-card-text>
      <template #footer>
        <small class="text-muted">충청북도 충주시 호암동</small>
      </template>
    </b-card>

    <b-card title="마니산(강화)">
      <b-img :src="'http://tong.visitkorea.or.kr/cms/resource/74/1659674_image2_1.jpg'" fluid alt="Fluid image"></b-img>
      <b-card-text>
       <br>강화도 남서단에 위치하고 한반도의 중앙에 자리잡고 있어 마니산을 중심으로 한라산과 백두산까지의 거리가 같다. 마니산이 단군이 제천할 정도의 명산으로 용이 승천하고 용마가 나왔으며, 신선이 사는 곳으로 72대 왕후장상이 나올 곳이라 한다. 마니산 정상에는 단군성조께서 하늘에 제천의식을 봉행하신 참성단이 있으며 ‘88 세계 장애자 올림픽을 비롯 매년 전국체전시 성화를 채화 봉송하고 있는 민족의 영산이다. 등산로를 따라 918개의 돌계단을 올라가노라면 서해바다 풍경이 한눈에 들어와 아름다운 경치를 만끽할 수 있으며, 동쪽 기슭으로 신라 선덕여왕때 지은 정수사 법당 살문짝 꽃무늬의 아름다움도 즐길 수 있다. 또한 마니산 치유의 숲은 소나무 산림유전자 보호림으로 다량의 피톤치드를 느끼며 힐링 할 수 있는 숲으로 곶게 뻗은 소나무와 삼나무 사이를 걷다보면 스트레스는 날아가고 힐링되는 기분을 느낄 수 있다.
       </b-card-text>
      <b-card-text class="small text-muted">인천광역시 강화군 화도면 마니산로675번길 18</b-card-text>
    </b-card>

    <b-card title="만장굴 (제주도 국가지질공원)">
      <b-img :src="'http://tong.visitkorea.or.kr/cms/resource/04/2658504_image2_1.jpeg'" fluid alt="Fluid image" width="500px"></b-img>
      <b-card-text>
        <br>제주시 구좌읍 김녕리에 위치하는 만장굴은 전체길이 약 7,400 m, 최대 높이 약 25 m, 최대 폭 약 18 m로서 제주 세계자연유산의 한 부분인 거문오름용암동굴계(황상구 외, 2005)에 속하는 용암동굴...
      </b-card-text>
      <template #footer>
        <small class="text-muted">제주특별자치도 제주시 구좌읍 만장굴길 182</small>
      </template>
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
  </b-card-group>
</template>

<script>
import { searchAllTrip } from "@/api/trip";

export default {
  name: "TripCard",
  components: {},
  data() {
    return {
      trips:[],
      trip:null,
    };
  },
  mounted:{
    search(){
      searchAllTrip(
        ({data})=>{
          console.log(data);
          this.trips=data.response.tripList;
        },
        (error)=>{
          console.log("searchAllError"+error);
        }
      );
    },
  },
  methods:{
    
  },
};
</script>

<style scoped></style>
