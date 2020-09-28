/* jshint indent: 1 */

module.exports = function(sequelize, DataTypes) {
	return sequelize.define('admin_users', {
		admin_id: {
			type: DataTypes.INTEGER(10),
			allowNull: false,
			primaryKey: true
		},
		admin_name: {
			type: DataTypes.STRING(45),
			allowNull: false
		},
		admin_pwd: {
			type: DataTypes.STRING(45),
			allowNull: false
		}
	}, {
		tableName: 'admin_users'
	});
};
