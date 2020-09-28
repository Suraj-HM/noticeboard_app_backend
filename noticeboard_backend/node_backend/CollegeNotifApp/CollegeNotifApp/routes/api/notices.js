'use strict'

var express = require('express')
var Seq = require('sequelize')

const seq = require('../../db_handler')
var Notices = require('../../models/notices')


var router = express.Router()
var notices = new Notices(seq, Seq)
const Op = Seq.Op

// routes
router.get('/notice', (req, res) =>
    notices.findAll().then( notices =>
        res.send(JSON.stringify(notices))
    )
)

router.get('/notice/:dept_id', (req, res) => {
    notices.findAll({
        where: {
            [Op.or]: [
                { notice_dept_id: req.params.dept_id },
                { notice_dept_id: 0 }
            ]
        }
    }).then(notices => {
        res.send(JSON.stringify(notices))
    })
})

module.exports = router