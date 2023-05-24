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
    SET_DETAIL_TRIP(state, trip) {
      state.trip = trip;
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
          commit("SET_TRIP_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    detailTrip: ({ commit }, trip) => {
      commit("SET_DETAIL_TRIP", trip);
    },
  },
};

export default tripStore;
