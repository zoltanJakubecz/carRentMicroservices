const express = require('express');
const pool = require('../database/db');
const service = require('../services/car.sevice')

const router = express.Router();

router.get('/', async (req, res) => {
        const cars = await service.getCars();
        res.send(cars.rows);
    
})


module.exports = router;