require('dotenv').config();

const express = require('express');
const cors = require('cors');
const app = express();
const eurekaHelper = require('./eureka-helper');

const carRoute = require('./routes/CarRoute');

app.use(cors());
app.use(express.json());
app.use(express.static('public'));


app.use(carRoute);

const PORT = process.env.PORT || 8081;

eurekaHelper.registerWithEureka('car-service', PORT);

app.listen(PORT, () => {
    console.log(`Server has started on port ${PORT}`)
});