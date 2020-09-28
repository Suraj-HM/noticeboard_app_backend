// API for collge notification app

// IMPORTS

var express = require('express')

const admins = require('./routes/api/admin')
const hods = require('./routes/api/hods')
const depts = require('./routes/api/dept')
const students = require('./routes/api/students')
const notices = require('./routes/api/notices')
var index = require('./routes/index')


// DECLERATIONS
var app = express()
app.set('view engine', 'pug')

var port = 5500
let domain = '192.168.1.106'
// let domain = 'localhost'


// ROUING

// static web views
app.use('/', index)

// view to guide to apis
app.get('/api', (req, res) => {
    res.render('api')
})

// api routes
app.use('/api/', admins)
app.use('/api/', hods)
app.use('/api/', depts)
app.use('/api/', students)
app.use('/api/', notices)



// RUN APP
app.listen(port, domain, () => {
    console.log(`Log start : app started on @ http://${domain}:${port}`)
})

