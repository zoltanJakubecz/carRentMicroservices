const axios = require('axios');

const getRents = async (id) => {
    const resp = await axios.get(`${process.env.RENT_URL}bycars/${id}`);
    return resp.data;
}

module.exports = {
    getRents
}