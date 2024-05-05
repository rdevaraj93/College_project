import axios from "axios";

const GET_EXAM_LIST_REST_API_URL = 'http://localhost:8080/generate/getallexamList';
 

export const listAllExam = () => {
    return axios.get(GET_EXAM_LIST_REST_API_URL)
};
