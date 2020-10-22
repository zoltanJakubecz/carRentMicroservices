const express = require('express');
const service = require('../services/car.sevice')

const router = express.Router();

router.get('/', async (req, res) => {

        const cars = await service.getCars();
        for(car of cars.rows){
            car.image =  `http://localhost:8762/imgs/${car.image}`;
        }
        res.status(200).json(cars.rows);

});

router.get('/:id', async (req, res) => {

    const car = await service.find(req.params.id);
    if(!car.rows[0]) res.status(404).send('The given id was not found');
    res.status(200).send(car.rows[0]);

});



module.exports = router;