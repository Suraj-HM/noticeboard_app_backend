
// to generate sequlize models from existing databse

var SequelizeAuto = require('sequelize-auto')



try {
    db_name - 'college_notice_board'
    var auto = new SequelizeAuto(db_name, 'root', 'root', {
        host: 'localhost',
        port: '3306',
        dialect: 'mysql'
    });

    auto.run(function (err) {
        if (err) throw err;
        console.log(auto.tables); // table list
        console.log(auto.foreignKeys); // foreign key list
    });
} catch (err) {
    console.log("Eroor loading the Database \n", err);
}

