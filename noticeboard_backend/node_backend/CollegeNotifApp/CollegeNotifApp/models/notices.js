/* jshint indent: 1 */

module.exports = function(sequelize, DataTypes) {
	return sequelize.define('notices', {
		id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			primaryKey: true
		},
		message: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		notice_dept_id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			references: {
				model: 'departments',
				key: 'dept_id'
			}
		},
		title: {
			type: DataTypes.STRING(40),
			allowNull: false
		}
	}, {
		tableName: 'notices'
	});
};
