require('dotenv').config();

const express = require('express');
const cors = require('cors');
const app = express();

const carRoute = require('./routes/CarRoute')

app.use(cors());
app.use(express.json());

app.use('/api/cars', carRoute);

// ------------------ Eureka Config --------------------------------------------


const Eureka = require('eureka-js-client').Eureka;

const eureka = new Eureka({
  instance: {
    app: 'carservice',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    statusPageUrl: 'http://localhost:8081',
    port: {
      '$': 8081,
      '@enabled': 'true',
    },
    vipAddress: 'localhost',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    }
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps/'
  }
});
eureka.logger.level('debug');
eureka.start(function(error){
  console.log(error || 'complete');
});


// ------------------ Server Config --------------------------------------------



const PORT = process.env.PORT || 8081;

app.listen(PORT, () => {
    console.log(`Server has started on port ${PORT}`)
});