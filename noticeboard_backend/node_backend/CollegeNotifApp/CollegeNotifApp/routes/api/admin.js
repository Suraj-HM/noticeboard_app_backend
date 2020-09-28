'use strict'

var express = require('express')
var Seq = require('sequelize')

const seq = require('../../db_handler')
var Admin = require('../../models/admin_users')


var router = express.Router()
var admins = new Admin(seq, Seq)

router.get('/admin', (req, res) => {
    admins.findAll().then(admins => {
        res.send(JSON.stringify(admins))
    })
})

module.exports = router