const pool = require('../database/db');


const getCars = () => {
    try {
        return pool.query("SELECT * FROM car;");
    } catch (error) {
        console.error(error.message);
    }
    
};

const find = (id) => {
    return pool.query("SELECT * FROM car WHERE id = $1", [id]);
}


module.exports = {
    getCars,
    find
};