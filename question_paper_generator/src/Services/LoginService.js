import axios from "axios";

const USER_LOGIN_REST_API_URL = 'http://localhost:8080/user/userlogin/'; 


export const getUserLogin = (userdetails) => {
    return axios.get(USER_LOGIN_REST_API_URL,userdetails)
};

 