require('dotenv').config();

const express = require('express');
const cors = require('cors');
const app = express();

const carRoute = require('./routes/CarRoute')

app.use(cors());
app.use(express.json());

app.use('/api/cars', carRoute);


const eureka = require('./config/service.registry.config');

eureka.logger.level('debug');
eureka.start(function(error){
  console.log(error || 'Eureka connection complete');
});



const PORT = process.env.PORT || 8081;

app.listen(PORT, () => {
    console.log(`Server has started on port ${PORT}`)
});