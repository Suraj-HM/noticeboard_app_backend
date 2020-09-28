
// sequelize orm
/*
var Sequelize = require('sequelize');

var user = 'root';
var pass = 'root';
var dbname = 'college_notice_board';

const sequelize = new Sequelize(dbname, user, pass, {
    dialect: 'mysql',
    define: {
        timestamps: false
    }
});
var notices = sequelize.import(__dirname + "/models/notices.js");

sequelize.sync({ force: false }).then(() => {
    notices.findAll().then(notices => {
        console.log(customers[0]['dataValues']);
        console.log('Log : data fetched ..!')
    });
});
*/


var Sequelize = require('sequelize')

/*
    var Notices = require('./models/notices')
    var Students = require('./models/student')
    var Admin = require('./models/admin_users')
    var HODs = require('./models/head_of_dept')
    var Departments = require('./models/departments')
*/
try {
    var user = 'root'
    var pass = 'root'
    var dbname = 'college_notice_board'

    const sequelize = new Sequelize(dbname, user, pass, {
        dialect: 'mysql',
        define: {
            timestamps: false
        }
    })
    
    /*
        const notices = Notices(sequelize, Sequelize)
        const students = Students(sequelize, Sequelize)
        const admins = Admin(sequelize, Sequelize)
        const hods = HODs(sequelize, Sequelize)
        const departments = Departments(sequelize, Sequelize)
    */

    // if force is true all tables will be dropped and recreated 
    // therefore all data will be lost

    sequelize.sync({ force: false }).then(() => {
        console.log(`Log : Database connected ..!`)
    })

    module.exports = sequelize

} catch (e) {
    console.log("Error connecting to the database ..!", e)
}
