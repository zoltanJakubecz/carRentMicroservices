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

module.exports = eureka;