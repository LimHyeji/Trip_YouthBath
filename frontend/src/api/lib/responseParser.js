/**
 * 
 * axios의 response 객체를 api return 명세대로 바꿔주는 객체
 * 
 */
const parser={
    successParser : function(response){
        return response.data;
    },
    failureParser : function(response){
        return response.response.data;
    }
}

export default parser;