const axios = require('axios');

const getRents = async (id) => {
    const resp = await axios.get(`http://localhost:8071/${id}`);
    return resp.data;
}

module.exports = {
    getRents
}