const proxy = require("http-proxy-middleware");

module.exports = function(app){app.use(proxy(['/*'],{target:"https://cors-anywhere.herokuapp.com/https://ahsan-calc-spring.herokuapp.com"}))}