const pool = require('../database/db');


const getCars = () => {
    try {
        return pool.query("SELECT * FROM car;");
    } catch (error) {
        console.error(error.message);
    }
    
} 


module.exports = {getCars};