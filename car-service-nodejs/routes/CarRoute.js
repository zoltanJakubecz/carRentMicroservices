const express = require('express');
const pool = require('../db');

const router = express.Router();

router.get('/', async (req, res) => {
    try {
        const cars = await pool.query("SELECT * FROM car;");
        res.send(cars.rows);
    } catch (err) {
        console.error(err.message)
    }
    
})


module.exports = router;