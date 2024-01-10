package org.joseph.quarkus.jdbc;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistRepo {

	@Inject
	DataSource dataSource;

	public void persist(Artist artist) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?, ?, ?, ?)";
		artist.setId(Math.abs(new Random().nextLong()));

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, artist.getId());
			ps.setString(2, artist.getName());
			ps.setString(3, artist.getBio());
			ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
			ps.executeUpdate();

		}
		con.close();

	}

	public Artist findById(Long id) throws SQLException {
		Connection con = dataSource.getConnection();
		String sql = "SELECT id, name, bio, created_date FROM t_artists where id = ?";
		Artist artist = new Artist();
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				artist.setId(rs.getLong(1));
				artist.setName(rs.getString(2));
				artist.setBio(rs.getString(3));
				artist.setCreatedDate(rs.getTimestamp(4).toInstant());
			}
		}
		con.close();
		return artist;
	}
}
