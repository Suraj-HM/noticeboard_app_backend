/* jshint indent: 1 */

module.exports = function(sequelize, DataTypes) {
	return sequelize.define('departments', {
		dept_id: {
			type: DataTypes.INTEGER(11),
			allowNull: false,
			primaryKey: true
		},
		dept_name: {
			type: DataTypes.STRING(45),
			allowNull: false
		}
	}, {
		tableName: 'departments'
	});
};
