import axios from "axios";

const USER_ADD_REST_API_URL = 'http://localhost:8080/user/getuser/userlist/';

class TestService{

    getUser(){
        return axios.get(USER_ADD_REST_API_URL);
    }

}

export default new TestService();