const express = require('express');
const service = require('../services/car.sevice')

const router = express.Router();

router.get('/', async (req, res) => {
        const cars = await service.getCars();
        res.status(200).json(cars.rows);
    
});


module.exports = router;