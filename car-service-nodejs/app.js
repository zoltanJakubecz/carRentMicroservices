require('dotenv').config();

const express = require('express');
const cors = require('cors');
const app = express();

const carRoute = require('./routes/CarRoute')

app.use(cors());
app.use(express.json());

app.use('/api/cars', carRoute);

const PORT = process.env.PORT || 8081;

app.listen(PORT, () => {
    console.log(`Server has started on port ${PORT}`)
})