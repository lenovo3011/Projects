import axios from "axios";

const api = axios.create({
    baseURL : 'https://weatherwiseai.onrender.com/'
    // baseURL : 'http://localhost:8080/'
})

export const postData =(jsonData)=> {

    return (api.post('genai', jsonData))
}