import axios from "axios";

const ADD_USER_REST_API_URL = 'http://localhost:8080/user/adduser';
const DELTE_USER_REST_API_URL = 'http://localhost:8080/user/deleteuser/';
const UPDATE_USER_REST_API_URL = 'http://localhost:8080/user/adduser';
const USER_LIST_REST_API_URL = 'http://localhost:8080/user/getuser/userlist/';
const USER_LOGIN_REST_API_URL = 'http://localhost:8080/user/userlogin/';
const GET_USER_BY_ID_REST_API_URL = 'http://localhost:8080/user/userlogin/';
const GET_USER_BY_ROLLID_REST_API_URL = 'http://localhost:8080/user/userlogin/';


export const listUsers = () => {
    return axios.get(USER_LIST_REST_API_URL)
};

export const createUser = (user) => {
    return axios.post(ADD_USER_REST_API_URL, user)
}

export const getuserById = (userId) => {
    return axios.get(GET_USER_BY_ID_REST_API_URL + '/' + userId);
}

export const getuserByRollId = (userrollId) => {
    return axios.get(GET_USER_BY_ROLLID_REST_API_URL + '/' + userrollId);
}

export const updateUser = (user) => {
    return axios.post(UPDATE_USER_REST_API_URL ,user );
}

export const deleteUser = (userid) => {
    return axios.delete(DELTE_USER_REST_API_URL + '/' + userid);
}

export const userLogin = (userlogin) => {
    return axios.get(USER_LOGIN_REST_API_URL, userlogin);
}