import axios from "axios";

const api = axios.create({
    baseURL : 'https://weatherwiseai-0vf9.onrender.com/'
})

export const postData =(jsonData)=> {

    return (api.post('genai', jsonData))
}