const pool = require('../database/db');
const uuid = require('uuid');


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

const addCar = async (newCar) => {
    const {brand, model, reg_plate} = newCar;
    const id = uuid.v4();
    const active = true;
    return await pool.query("INSERT INTO car (id, brand, model, active, reg_plate) VALUES ($1, $2, $3, $4, $5)", [id, brand, model, active, reg_plate]);
}


module.exports = {
    getCars,
    find,
    addCar
};