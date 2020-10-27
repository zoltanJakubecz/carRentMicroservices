const express = require('express');
const service = require('../services/car.sevice')

const router = express.Router();
const baseUrl = process.env.BACKEND_URL;

router.get('/', async (req, res) => {
        try {
            const cars = await service.findAll();
            for(car of cars.rows){
                if(car.image) car.image = `${baseUrl}/api/cars/imgs/${car.image}`;
                else car.image = `${baseUrl}/api/cars/imgs/no-picture-available.jpg`;
            }
            res.status(200).json(cars.rows);            
        } catch (error) {
            console.log(error);
            res.status(404);
        }

});

router.get('/:id', async (req, res) => {
    try {
        const car = await service.find(req.params.id);
        if(!car.rows[0]) res.status(404).send('The given id was not found');
        res.status(200).send(car.rows[0]);
        
    } catch (error) {
        console.error(error);
        res.status(404);        
    }

});


router.post('/', async (req, res) => {
    try {
        const newCar = await service.addCar(req.body);
        res.status(200).send(newCar.rows[0]);
    } catch (error) {
        console.log(error);
        res.status(404);
    }
    
});

router.put('/:id', async (req,res) => {
    const { id } = req.params;
    try {
        const updateCar = await service.update(id, req.body);
        res.send(updateCar.rows[0]);
    } catch (error) {
        res.status(404);
    }
    
})



module.exports = router;