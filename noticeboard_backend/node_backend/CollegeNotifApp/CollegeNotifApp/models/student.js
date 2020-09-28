/* jshint indent: 1 */

module.exports = function(sequelize, DataTypes) {
	return sequelize.define('student', {
		student_id: {
			type: DataTypes.INTEGER(11),
			autoincrement: true,
			primaryKey: true
		},
		student_name: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		student_pwd: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		student_email: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		phone_no: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		student_dept_id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			references: {
				model: 'departments',
				key: 'dept_id'
			}
		}
	}, {
		tableName: 'student'
	});
};
