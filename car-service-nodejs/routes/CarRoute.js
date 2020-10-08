const express = require('express');
const { getCars } = require('../services/car.sevice');
const service = require('../services/car.sevice')

const router = express.Router();

router.get('/', async (req, res) => {

        const cars = await service.getCars();
        res.status(200).json(cars.rows);

});

router.get('/:id', async (req, res) => {


    const car = await service.find(req.params.id);
    if(!car.rows[0]) res.status(404).send('Not found');
    res.status(200).send(car.rows[0]);

})


module.exports = router;