import axios from 'axios'

const service = axios.create({
    baseURL: 'http://127.0.0.1:12580',
    timeout: 5000
});

// http request 拦截器
service.interceptors.request.use(
    config => {
        config.data = JSON.stringify(config.data);
        config.headers = {
            'Content-Type': 'application/x-www-form-urlencoded'
        };
        return config
    },
    error => {
        return Promise.reject(error)
    }
);

// http response 拦截器
service.interceptors.response.use(
    response => {
        const res = response.data;
        if (res.code !== 200) {
            return Promise.reject(new Error('Error'))
        } else {
            return res
        }
    },
    error => {
        return Promise.reject(error)
    }
);

export default service
