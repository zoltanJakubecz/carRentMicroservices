const pool = require('../database/db');
const uuid = require('uuid');
const rentService = require('./rent.service');


const findAll = async () => {
    try {
        await rentService.getAll();
        const cars = await pool.query("SELECT id, brand, model, image FROM car WHERE active = true;");
        for(car of cars.rows){
            // console.log(car);
            car.rents = await rentService.getRents(car.id) || [];
        }
        console.log(cars.rows);
        return cars;
    } catch (error) {
        console.error(error.message);
    }    
};

const find = async (id) => {
    rents = await rentService.getRents(id);
    console.log(rents);
    car = await pool.query("SELECT id, brand, image, model, image, active FROM car WHERE id = $1", [id]);
    car.rows[0].rents = rents;
    return car;
}

const addCar = async (newCar) => {
    const {brand, model, reg_plate} = newCar;
    const id = uuid.v4();
    const active = true;
    const added = new Date(Date.now());
    return await pool.query("INSERT INTO car (id, brand, model, active, reg_plate, added) VALUES ($1, $2, $3, $4, $5, $6) RETURNING *",
                                [id, brand, model, active, reg_plate, added]);
}

const update = async (id, body) => {
    const {brand, model, reg_plate, active} = body;
    return await pool.query("UPDATE car SET brand = $1, model = $2, reg_plate = $3, active = $4 WHERE id = $5 RETURNING *",
                                [brand, model, reg_plate, active, id]);
}


module.exports = {
    findAll,
    find,
    addCar,
    update
};