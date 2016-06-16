package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class DAOLorannWorld extends DAOEntity<LorannWorld> {

	
	public DAOLorannWorld(final Connection connection) throws SQLException {
		super(connection);
	}


	@Override
	public LorannWorld find(int idmap) {
		LorannWorld lorannWorld = new LorannWorld();

		try {
			final String sql = "{call lorannworldById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idmap);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				lorannWorld = new LorannWorld(idmap, resultSet.getString("key"), resultSet.getString("maptxt"));
				
			}
			return lorannWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean create(LorannWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(LorannWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(LorannWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public LorannWorld find(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	






}
