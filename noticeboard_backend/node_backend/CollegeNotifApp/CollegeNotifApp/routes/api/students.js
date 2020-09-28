'use strict'

var express = require('express')
var Seq = require('sequelize')

const seq = require('../../db_handler')
var Students = require('../../models/student')


var router = express.Router()
var students = new Students(seq, Seq)


router.get('/student', (req, res) => {
    students.findAll().then(students => {
        res.send(JSON.stringify(students))
    })
})

router.get('/student/auth', (req, res) =>
    res.send(
        'Directions to use : api/student/auth/email/password'
    )
)

router.get('/student/auth/:username/:password', (req, res) => {
    students.findAll({
        where: {
            student_email: req.params.username,
            student_pwd: req.params.password
        }
    }).then( student =>
        res.send(JSON.stringify(student[0]))
    )
})

router.get('/student/find/:stu_id', (req, res) => {
    students.findAll({
        where: {
            student_id: req.params.stu_id
        }
    }).then(student =>
        res.send(JSON.stringify(student))
    )
})

router.get('/student/register', (req, res) => {
    res.send(
        'Directions to use : /student/register/name/email/pass/phone/dept_id'
    )
})

router.get('/student/register/:name/:email/:pass/:phone/:dept_id', (req, res) => {
    students.create({
        student_name: req.params.name,
        student_email: req.params.email,
        student_pwd: req.params.pass,
        phone_no: req.params.phone,
        student_dept_id: req.params.dept_id
    }).then(student => {
        console.log(student)
        res.send(JSON.stringify({ "regitered": true }))
    }
    ).catch(err => {
        console.log(err)
        res.send(JSON.stringify({ "regitered": false }))
    })
})


module.exports = router



