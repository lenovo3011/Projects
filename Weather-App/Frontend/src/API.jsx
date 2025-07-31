import axios from "axios";

const api = axios.create({
    baseURL : 'https://weatherwiseai.onrender.com/'
})

export const postData =(jsonData)=> {

    return (api.post('genai', jsonData))
}