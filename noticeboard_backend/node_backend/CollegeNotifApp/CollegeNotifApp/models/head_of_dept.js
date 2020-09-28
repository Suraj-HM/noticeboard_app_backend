/* jshint indent: 1 */

module.exports = function(sequelize, DataTypes) {
	return sequelize.define('head_of_dept', {
		hod_id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			primaryKey: true
		},
		hod_name: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		hod_pwd: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		hod_email: {
			type: DataTypes.STRING(45),
			allowNull: true
		},
		hod_dept_id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			references: {
				model: 'departments',
				key: 'dept_id'
			}
		}
	}, {
		tableName: 'head_of_dept'
	});
};
