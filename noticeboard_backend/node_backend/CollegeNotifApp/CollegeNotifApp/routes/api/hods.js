'use strict'

var express = require('express')
var Seq = require('sequelize')

const seq = require('../../db_handler')
var Hods = require('../../models/head_of_dept')


var router = express.Router()
var hods = new Hods(seq, Seq)

router.get('/hods', (req, res) => {
    hods.findAll().then(hods => {
        res.send(JSON.stringify(hods))
    })
})



module.exports = router