const pool = require('../database/db');


const getCars = async () => {
    try {
        return await pool.query("SELECT * FROM car;");
    } catch (error) {
        console.error(error.message);
    }
    
};

const find = async (id) => {
    return await pool.query("SELECT * FROM car WHERE id = $1", [id]);
}


module.exports = {
    getCars,
    find
};