const axios = require('axios');

const getRents = async (id) => {
    const resp = await axios.get(`${process.env.RENT_URL}bycars/${id}`);
    return resp.data;
}

const getAll = async () => {
    const resp = await axios.get(process.env.RENT_URL);
    console.log(resp.data);
}

module.exports = {
    getRents,
    getAll
}