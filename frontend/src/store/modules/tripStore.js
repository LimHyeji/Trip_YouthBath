import { searchTrip } from "@/api/trip.js";

const tripStore = {
  namespaced: true,
  state: {
    trips: [],
    trip: null,
  },
  getters: {},
  mutations: {
    CLEAR_TRIP_LIST(state) {
      state.trips = [];
      state.trip = null;
    },
    SET_TRIP_LIST(state, trips) {
      state.trips = trips;
    },
  },
  actions: {
    getSearchTrip: ({ commit }, sidoCode,gugunCode,contentTypeId) => {
      const params = {
          sidoCode: sidoCode,
          gugunCode: gugunCode,
          contentTypeId: contentTypeId,
      };
      searchTrip(
        params,
        ({ data }) => {
          console.log(data);
          commit("SET_TRIP_LIST", data.response);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default tripStore;
