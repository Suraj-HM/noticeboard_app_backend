'use strict'

var express = require('express')
var Seq = require('sequelize')

const seq = require('../../db_handler')
var Dept = require('../../models/departments')


var router = express.Router()
var dept = new Dept(seq, Seq)

router.get('/dept', (req, res) => {
    dept.findAll().then(dept => {
        res.send(JSON.stringify(dept))
    })
})

module.exports = router