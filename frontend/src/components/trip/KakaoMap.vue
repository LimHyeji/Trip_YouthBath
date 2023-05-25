<template>
  <div id="map"></div>
</template>

<script>
export default {
  name: "KakaoMap",
  components: {},
  data() {
    return {
      map: null,
      positions: [],
      markers: [],
    };
  },
  props: {
    trips:[],
  },
  watch: {
    trips(){
      console.log("여행지 리스트",this.trips);
      this.positions=[];
      this.trips.forEach((trip)=>{
        let obj={};
        obj.title=trip.title;
        obj.latlng=new window.kakao.maps.LatLng(trip.latitude,trip.longitude);
        this.positions.push(obj);
      });
      this.loadMarker();
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" +
        process.env.VUE_APP_KAKAO_MAP_API_KEY +
        "&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);

      document.head.appendChild(script);
    },
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };

      this.map = new window.kakao.maps.Map(container, options);
    },
    loadMarker() {
      //마커 띄우는 함수
      this.deleteMarker();
      this.markers=[];
      this.positions.forEach((position)=>{
        const marker=new window.kakao.maps.Marker({
          map:this.map,
          position:position.latlng,
          title:position.title,
        });
        this.markers.push(marker);
      });
      console.log("마커수"+this.markers.length);

      const bounds=this.positions.reduce(
        (bounds,position)=>bounds.extend(position.latlng),
        new window.kakao.maps.LatLngBounds()
      );

      this.map.setBounds(bounds);
    },
    deleteMarker() {
      //마커 지우는 함수
      if(this.markers.length>0){
        this.markers.forEach((item)=>{
          item.setMap(null);
        });
      }
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 700px;
}
</style>
